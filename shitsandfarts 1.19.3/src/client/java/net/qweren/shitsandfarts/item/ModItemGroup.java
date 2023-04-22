package net.qweren.shitsandfarts.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.qweren.shitsandfarts.ShitsandFarts;

public class ModItemGroup {
    public static final ItemGroup SHIT = FabricItemGroup.builder(new Identifier(ShitsandFarts.MOD_ID, "shit")).displayName(Text.literal("Shits and Farts")).icon(() -> new ItemStack(ModItems.SHIT)).build();
}
