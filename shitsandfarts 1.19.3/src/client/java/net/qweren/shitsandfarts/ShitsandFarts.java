package net.qweren.shitsandfarts;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.qweren.shitsandfarts.block.ModBlocks;
import net.qweren.shitsandfarts.item.ModItems;
import net.qweren.shitsandfarts.networking.ModMessages;
import net.qweren.shitsandfarts.sounds.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShitsandFarts implements ModInitializer {
	public static final String MOD_ID = "shitsandfarts";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.RegisterModItems();
		ModBlocks.registerModBlocks();

		ModMessages.registerC2SPackets();

		Registry.register(Registries.SOUND_EVENT, ModSounds.FART_SOUND_ID, ModSounds.FART_SOUND_EVENT);

		CompostingChanceRegistry.INSTANCE.add(ModItems.SHIT, 1F);
		CompostingChanceRegistry.INSTANCE.add(ModItems.DRY_SHIT, 1F);
	}
}