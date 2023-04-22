package net.qweren.shitsandfarts.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.qweren.shitsandfarts.ShitsandFarts;
import net.qweren.shitsandfarts.util.IEntityDataSaver;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {

    @Shadow
    @Final
    private MinecraftClient client;

    private static final Identifier FILLED_SHIT = new Identifier(ShitsandFarts.MOD_ID, "textures/gui/fullshit.png");
    private static final Identifier EMPTY_SHIT = new Identifier(ShitsandFarts.MOD_ID, "textures/gui/emptyshit.png");

    @Inject(method = "renderStatusBars", at = @At("TAIL"))
    private void renderPoopBar(MatrixStack matrices, CallbackInfo ci) {
        int x = 0;
        int y = 0;

        int width = client.getWindow().getScaledWidth();
        int height = client.getWindow().getScaledHeight();

        x = width/2;
        y= height;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f,1f,1f,1f);
        RenderSystem.setShaderTexture(0,FILLED_SHIT);
        for(int i = 0; i <10; i++){
            DrawableHelper.drawTexture(matrices, x+10 + (i*8), y-49, 0,0,9,9,9,9);
        }

        RenderSystem.setShaderTexture(0,EMPTY_SHIT);
        
        float poop = ((IEntityDataSaver)MinecraftClient.getInstance().player).getPersistentData().getInt("poop");
        for (int i = 0; i < 10; i++) {
            if (10 - poop > i){
                DrawableHelper.drawTexture(matrices, x+10 + (i *8), y-49,0,0,9,9,9,9);
            }else {
                break;
            }
        }

    }
}
