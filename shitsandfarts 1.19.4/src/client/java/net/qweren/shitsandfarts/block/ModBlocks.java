package net.qweren.shitsandfarts.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.qweren.shitsandfarts.ShitsandFarts;
import net.qweren.shitsandfarts.item.ModItemGroup;

public class ModBlocks {
    public static final Block SHIT_BLOCK = registerBlock("shit_block",
            new Block(FabricBlockSettings.of(Material.SOIL)
                    .hardness(0.5f)
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.MUD)),
            ModItemGroup.SHIT
            );



    public static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(ShitsandFarts.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ShitsandFarts.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(item));
        return item;
    }


    public static void registerModBlocks(){
        ShitsandFarts.LOGGER.debug("Registering blocks for mod: " + ShitsandFarts.MOD_ID);
    }
}
