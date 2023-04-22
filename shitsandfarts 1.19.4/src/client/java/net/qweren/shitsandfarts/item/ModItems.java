package net.qweren.shitsandfarts.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.qweren.shitsandfarts.ShitsandFarts;

public class ModItems {

    public static final Item SHIT = registerItem(
            "shit",
            new Item(new FabricItemSettings().food(new FoodComponent.Builder()
                    .hunger(1)
                    .saturationModifier(0.6f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*10), 1)
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*10), 1)
                    .build()))
    );

    public static final Item DRY_SHIT = registerItem(
            "dry_shit",
            new Item(new FabricItemSettings()));



    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(ShitsandFarts.MOD_ID, name), item);
    }


    public static void RegisterModItems() {
        ShitsandFarts.LOGGER.debug("Registering items for mod: " + ShitsandFarts.MOD_ID);

        addItemsToItemGroups();
    }

    public static void addItemsToItemGroups() {
        addToItemGroup(ModItemGroup.SHIT, SHIT);
        addToItemGroup(ModItemGroup.SHIT, DRY_SHIT);
    }


    public static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
}
