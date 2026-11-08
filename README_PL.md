# SPcheats — Fabric 1.21.4

Lekki, klientowy mod Fabric z białym menu i powiadomieniami Elytra.

## Funkcje w tej wersji
- Menu otwierane klawiszem RIGHT SHIFT.
- Jasny, minimalistyczny ekran SPcheats.
- Elytra Alert: powiadomienie, gdy inny widoczny gracz zaczyna szybować na Elytrze.
- Powiadomienie, gdy taki gracz kończy szybowanie.
- Powiadomienie jest wyświetlane przez około 4 sekundy.

## Wymagania
- Minecraft Java 1.21.4
- Java 21
- Fabric Loader
- Fabric API dla 1.21.4

## Budowanie
W katalogu projektu uruchom `gradle build`.
Plik JAR powinien pojawić się w `build/libs/spcheats-1.0.0.jar`.

## Ograniczenia
To projekt źródłowy, nie skompilowany ani przetestowany tutaj w uruchomionej grze.
Elytra Alert wykrywa tylko graczy, których klient aktualnie zna w załadowanym świecie;
nie omija zasięgu renderowania, niewidzialności ani zabezpieczeń serwera.
Menu jest szkieletem startowym, nie zawiera jeszcze rozbudowanego zestawu modułów.
