package net.qweren.shitsandfarts;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.qweren.shitsandfarts.event.KeyInputHandler;
import net.qweren.shitsandfarts.networking.ModMessages;
import net.qweren.shitsandfarts.networking.packet.SyncOnJoin;

public class ExampleModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		KeyInputHandler.register();

		ModMessages.registerS2CPackets();
		ClientPlayConnectionEvents.JOIN.register(new SyncOnJoin());
	}
}