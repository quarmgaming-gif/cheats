package pl.spcheats;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public final class SPcheatsScreen extends Screen {
    private static final int PANEL = 0xFFF7F7F7;
    private static final int INK = 0xFF202020;
    private static final int MUTED = 0xFF777777;

    public SPcheatsScreen() {
        super(Text.literal("SPcheats"));
    }

    @Override
    protected void init() {
        int panelWidth = 300;
        int left = (this.width - panelWidth) / 2;
        int top = (this.height - 210) / 2;

        addDrawableChild(ButtonWidget.builder(Text.literal("Elytra Alert: ON"),
                button -> button.setMessage(Text.literal("Elytra Alert: ON")))
                .dimensions(left + 18, top + 82, 264, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.literal("Close"),
                button -> close())
                .dimensions(left + 18, top + 172, 264, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        int panelWidth = 300;
        int panelHeight = 210;
        int left = (this.width - panelWidth) / 2;
        int top = (this.height - panelHeight) / 2;

        context.fill(left, top, left + panelWidth, top + panelHeight, PANEL);
        context.fill(left, top, left + panelWidth, top + 2, 0xFFFFFFFF);
        context.drawTextWithShadow(textRenderer, Text.literal("SPCHEATS"), left + 18, top + 18, INK);
        context.drawTextWithShadow(textRenderer,
                Text.literal("Fabric 1.21.4  •  RIGHT SHIFT"), left + 18, top + 38, MUTED);
        context.drawTextWithShadow(textRenderer,
                Text.literal("Powiadomienia o starcie i koncu lotu Elytra"),
                left + 18, top + 62, INK);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
