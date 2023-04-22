package net.qweren.shitsandfarts.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.qweren.shitsandfarts.ShitsandFarts;
import net.qweren.shitsandfarts.networking.packet.PoopyncDataS2CPacket;
import net.qweren.shitsandfarts.networking.packet.ShittingC2SPacket;

public class ModMessages {
    public static final Identifier SHITTING_ID = new Identifier(ShitsandFarts.MOD_ID, "shitting");
    public static final Identifier POOP_SYNC_ID = new Identifier(ShitsandFarts.MOD_ID, "poop_sync");

    public static void registerC2SPackets(){
        ServerPlayNetworking.registerGlobalReceiver(SHITTING_ID, ShittingC2SPacket::receive);
    }
    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(POOP_SYNC_ID, PoopyncDataS2CPacket::receive);
    }
}
