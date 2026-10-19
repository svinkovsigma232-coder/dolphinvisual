package com.dolphin;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class DolphinVisual implements ClientModInitializer {
    private boolean wasPressed = false;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.getWindow() == null) return;

            boolean isPressed = InputUtil.isKeyPressed(client.getWindow(), GLFW.GLFW_KEY_RIGHT_SHIFT);

            if (isPressed && !wasPressed && client.currentScreen == null) {
                client.setScreen(DolphinScreen.create(null));
            }
            wasPressed = isPressed;
        });
    }
}
