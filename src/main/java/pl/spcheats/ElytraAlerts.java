package pl.spcheats;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ElytraAlerts {
    private static final Map<UUID, Boolean> GLIDING = new HashMap<>();
    private static String message = "";
    private static long shownUntil = 0L;

    private ElytraAlerts() {}

    public static void tick(MinecraftClient client) {
        if (client.world == null || client.player == null) {
            GLIDING.clear();
            return;
        }

        for (PlayerEntity player : client.world.getPlayers()) {
            if (player == client.player) continue;

            boolean hasElytra = player.getEquippedStack(EquipmentSlot.CHEST).isOf(Items.ELYTRA);
            boolean flying = hasElytra && player.isGliding();
            boolean wasFlying = GLIDING.getOrDefault(player.getUuid(), false);

            if (flying && !wasFlying) {
                show(player.getName().getString() + " zaczal latac Elytra");
            } else if (!flying && wasFlying) {
                show(player.getName().getString() + " zakonczyl lot Elytra");
            }
            GLIDING.put(player.getUuid(), flying);
        }

        GLIDING.keySet().removeIf(uuid ->
                client.world.getPlayers().stream().noneMatch(p -> p.getUuid().equals(uuid))
        );
    }

    private static void show(String text) {
        message = text;
        shownUntil = System.currentTimeMillis() + 4000L;
    }

    public static void render(DrawContext context, MinecraftClient client) {
        if (client.options.hudHidden || message.isEmpty()) return;
        long remaining = shownUntil - System.currentTimeMillis();
        if (remaining <= 0) return;

        String line = "Elytra Alert  |  " + message;
        int width = client.textRenderer.getWidth(line);
        int x = client.getWindow().getScaledWidth() - width - 24;
        int y = 18;
        context.fill(x - 8, y - 6, x + width + 8, y + 17, 0xEFFFFFFF);
        context.drawTextWithShadow(client.textRenderer, Text.literal(line), x, y, 0xFF222222);
    }
}
