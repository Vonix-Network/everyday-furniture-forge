package net.vonix.everydayfurniture;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

/** Optional, runtime-only bridge. Culinary Dragons remains the owner of all food/drink items. */
public final class CulinaryCompat {
    private static final String MOD_ID = "culinarydragons";
    private CulinaryCompat() {}

    public static boolean loaded() { return ModList.get().isLoaded(MOD_ID); }

    public static ItemStack process(String station, ItemStack input) {
        if (!loaded() || input.isEmpty()) return ItemStack.EMPTY;
        String in = ForgeRegistries.ITEMS.getKey(input.getItem()).toString();
        String out = switch (station) {
            case "oven" -> switch (in) {
                case "minecraft:potato" -> "baked_potato_platter";
                case "minecraft:beef" -> "cooked_meat_platter";
                case "minecraft:carrot" -> "vegetable_stew";
                default -> null;
            };
            case "microwave" -> switch (in) {
                case "minecraft:cocoa_beans" -> "hot_chocolate";
                case "culinarydragons:vegetable_stew" -> "cooked_meat_platter";
                default -> null;
            };
            case "coffee_maker" -> switch (in) {
                case "minecraft:apple" -> "apple_juice";
                case "culinarydragons:grapes" -> "grape_juice";
                case "culinarydragons:mixed_berries" -> "berry_juice";
                case "culinarydragons:cherries" -> "cherry_juice";
                default -> null;
            };
            default -> null;
        };
        if (out == null) return ItemStack.EMPTY;
        Item result = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MOD_ID, out));
        return result == null ? ItemStack.EMPTY : new ItemStack(result);
    }
}
