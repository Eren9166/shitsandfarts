package net.qweren.shitsandfarts.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.qweren.shitsandfarts.util.IEntityDataSaver;
import net.qweren.shitsandfarts.util.PoopData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class EatMixin {

    @Shadow public abstract void sendMessage(Text message, boolean actionBar);

    @Inject(method = "eatFood", at = @At("TAIL"))
    protected void inhjectMethod(World world, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
        if (world instanceof ServerWorld){
            FoodComponent foodComponent = stack.getItem().getFoodComponent();

            if (foodComponent != null) {
                // Add the poop amount to the player's data
                IEntityDataSaver dataPlayer = (IEntityDataSaver) this;
                PoopData.addPoop(dataPlayer, (stack.getItem().getFoodComponent().getHunger()/2));
            }
        }
    }
}
