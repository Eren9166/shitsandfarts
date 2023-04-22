package net.qweren.shitsandfarts.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.qweren.shitsandfarts.networking.ModMessages;

public class PoopData {
    public static int addPoop(IEntityDataSaver player, int amount){
        NbtCompound nbt = player.getPersistentData();
        int poop = nbt.getInt("poop");
        if(poop + amount >= 10){
            poop = 10;
        } else{
            poop += amount;
        }

        nbt.putInt("poop", poop);
        PoopData.syncPoop(player.getPersistentData().getInt("poop"), (ServerPlayerEntity) player);
        return poop;
    }

    public static int removePoop(IEntityDataSaver player, int amount){
        NbtCompound nbt = player.getPersistentData();
        int poop = nbt.getInt("poop");
        if(poop - amount < 0){
            poop = 0;
        } else{
            poop -= amount;
        }

        nbt.putInt("poop", poop);
        PoopData.syncPoop(player.getPersistentData().getInt("poop"), (ServerPlayerEntity) player);
        return poop;
    }

    public static void syncPoop(int poop, ServerPlayerEntity player){
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(poop);
        ServerPlayNetworking.send(player, ModMessages.POOP_SYNC_ID, buffer);
    }
}
