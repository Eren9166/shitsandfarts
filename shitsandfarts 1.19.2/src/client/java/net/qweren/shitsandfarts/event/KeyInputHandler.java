package net.qweren.shitsandfarts.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.qweren.shitsandfarts.networking.ModMessages;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_SHIT = "key.category.shitsandfarts.shitcategory";
    public static final String KEY_SHIT = "key.shitsandfarts.shit";

    public static KeyBinding shitKey;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(shitKey.wasPressed()){
                ClientPlayNetworking.send(ModMessages.SHITTING_ID, PacketByteBufs.create());
            }
        });
    }

    public static void register(){
        shitKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_SHIT,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_U,
                KEY_CATEGORY_SHIT
        ));

        registerKeyInputs();
    }

}
