package net.qweren.shitsandfarts.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.random.Random;
import net.qweren.shitsandfarts.item.ModItems;
import net.qweren.shitsandfarts.sounds.ModSounds;
import net.qweren.shitsandfarts.util.IEntityDataSaver;
import net.qweren.shitsandfarts.util.PoopData;

public class ShittingC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender){
        if (((IEntityDataSaver) player).getPersistentData().getInt("poop") >= 3) {

            //server side
            ServerWorld world = player.getWorld();

            player.dropItem(ModItems.SHIT, 1);

            world.playSound(null, player.getBlockPos(), ModSounds.FART_SOUND_EVENT, SoundCategory.PLAYERS, 0.5f, 1f);
            PoopData.removePoop(((IEntityDataSaver) player), 3);
            PoopData.syncPoop(((IEntityDataSaver) player).getPersistentData().getInt("poop"), player);


        } else {
            ServerWorld world = player.getWorld();
            world.playSound(null, player.getBlockPos(), ModSounds.SMALL_FART_EVENT, SoundCategory.PLAYERS, 0.5f, 1f);
            PoopData.syncPoop(((IEntityDataSaver) player).getPersistentData().getInt("poop"), player);
        }
    };
}
