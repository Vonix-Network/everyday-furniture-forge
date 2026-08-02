package net.vonix.everydayfurniture;

import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EverydayFurnitureMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class EverydayFurnitureClient {
    private EverydayFurnitureClient() { }
    @SubscribeEvent public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) { event.registerEntityRenderer(EverydayFurnitureMod.SEAT_ENTITY.get(), NoopRenderer::new); }
}
