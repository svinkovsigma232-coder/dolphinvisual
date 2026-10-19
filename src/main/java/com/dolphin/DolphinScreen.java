package com.dolphin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class DolphinScreen extends Screen {
    private final Screen parent;

    public DolphinScreen(Screen parent) {
        super(Text.literal("Dolphin Visual"));
        this.parent = parent;
    }

    public static Screen create(Screen parent) {
        return new DolphinScreen(parent);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        int centerX = this.width / 2;
        int centerY = this.height / 2;
        int menuWidth = 360;
        int menuHeight = 240;
        int menuX = centerX - menuWidth / 2;
        int menuY = centerY - menuHeight / 2;

        context.fill(menuX, menuY, menuX + menuWidth, menuY + menuHeight, 0xEE1A1A1A);
        drawBorder(context, menuX, menuY, menuWidth, menuHeight, 0xFF00FFFF);
        context.drawCenteredTextWithShadow(this.textRenderer, "§b§lDolphin Visual", centerX, menuY + 15, 0x00FFFF);
        context.fill(centerX - 60, centerY - 40, centerX + 60, centerY + 40, 0x4400FFFF);
        context.drawCenteredTextWithShadow(this.textRenderer, "§7[Место для дельфина]", centerX, centerY, 0xAAAAAA);

        int startX = menuX + 30;
        int startY = menuY + 100;
        int btnWidth = 90;
        int btnHeight = 25;
        int gap = 10;

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 3; col++) {
                int x = startX + col * (btnWidth + gap);
                int y = startY + row * (btnHeight + gap);
                context.fill(x, y, x + btnWidth, y + btnHeight, 0xFF2A2A2A);
                drawBorder(context, x, y, btnWidth, btnHeight, 0xFF00FFFF);
                context.drawCenteredTextWithShadow(this.textRenderer, "§bФункция", x + btnWidth / 2, y + 8, 0x00FFFF);
            }
        }

        super.render(context, mouseX, mouseY, delta);
    }

    private void drawBorder(DrawContext context, int x, int y, int width, int height, int color) {
        context.fill(x, y, x + width, y + 1, color);
        context.fill(x, y + height - 1, x + width, y + height, color);
        context.fill(x, y, x + 1, y + height, color);
        context.fill(x + width - 1, y, x + width, y + height, color);
    }

    @Override
    public void close() {
        this.client.setScreen(this.parent);
    }
}
