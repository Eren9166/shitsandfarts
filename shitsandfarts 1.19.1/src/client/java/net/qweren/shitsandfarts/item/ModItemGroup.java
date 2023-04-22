package net.qweren.shitsandfarts.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.qweren.shitsandfarts.ShitsandFarts;

public class ModItemGroup {
    public static final ItemGroup SHIT = FabricItemGroupBuilder.build(new Identifier(ShitsandFarts.MOD_ID, "shit"), () -> new ItemStack(ModItems.SHIT));
}
