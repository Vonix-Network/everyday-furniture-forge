package net.vonix.everydayfurniture;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
public final class EverydayFurnitureTab { public static final CreativeModeTab TAB=new CreativeModeTab("everydayfurniture"){ @Override public ItemStack makeIcon(){return new ItemStack(EverydayFurnitureMod.CHAIR_ITEM.get());} }; private EverydayFurnitureTab(){} }
