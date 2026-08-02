package net.vonix.everydayfurniture;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
@Mod(EverydayFurnitureMod.MOD_ID)
public final class EverydayFurnitureMod {
 public static final String MOD_ID="everydayfurniture";
 public static final DeferredRegister<Block> BLOCKS=DeferredRegister.create(ForgeRegistries.BLOCKS,MOD_ID);
 public static final DeferredRegister<Item> ITEMS=DeferredRegister.create(ForgeRegistries.ITEMS,MOD_ID);
 private static RegistryObject<Block> b(String id,VoxelShape s){return BLOCKS.register(id,()->new FurnitureBlock(s));}
 private static RegistryObject<Item> i(String id,RegistryObject<Block> b){return ITEMS.register(id,()->new BlockItem(b.get(),new Item.Properties().tab(EverydayFurnitureTab.TAB)));}
 private static final VoxelShape SEAT=Block.box(1,0,1,15,10,15), TABLE_SHAPE=Block.box(1,0,1,15,12,15), TALL=Block.box(1,0,1,15,16,15);
 public static final RegistryObject<Block> CHAIR=b("chair",SEAT); public static final RegistryObject<Item> CHAIR_ITEM=i("chair",CHAIR);
 public static final RegistryObject<Block> TABLE=b("table",TABLE_SHAPE); public static final RegistryObject<Item> TABLE_ITEM=i("table",TABLE);
 public static final RegistryObject<Block> SOFA=b("sofa",Block.box(0,0,0,16,12,12)); public static final RegistryObject<Item> SOFA_ITEM=i("sofa",SOFA);
 public static final RegistryObject<Block> BEDSIDE_TABLE=b("bedside_table",Block.box(1,0,1,15,14,15)); public static final RegistryObject<Item> BEDSIDE_TABLE_ITEM=i("bedside_table",BEDSIDE_TABLE);
 public static final RegistryObject<Block> CABINET=b("cabinet",TALL); public static final RegistryObject<Item> CABINET_ITEM=i("cabinet",CABINET);
 public static final RegistryObject<Block> LAMP=b("lamp",Block.box(4,0,4,12,16,12)); public static final RegistryObject<Item> LAMP_ITEM=i("lamp",LAMP);
 public static final RegistryObject<Block> BOOKSHELF=b("bookshelf",TALL); public static final RegistryObject<Item> BOOKSHELF_ITEM=i("bookshelf",BOOKSHELF);
 public static final RegistryObject<Block> KITCHEN_COUNTER=b("kitchen_counter",Block.box(0,0,0,16,14,16)); public static final RegistryObject<Item> KITCHEN_COUNTER_ITEM=i("kitchen_counter",KITCHEN_COUNTER);
 public static final RegistryObject<Block> SINK=b("sink",Block.box(1,10,1,15,16,15)); public static final RegistryObject<Item> SINK_ITEM=i("sink",SINK);
 public static final RegistryObject<Block> TOILET=b("toilet",Block.box(2,0,2,14,12,14)); public static final RegistryObject<Item> TOILET_ITEM=i("toilet",TOILET);
 public static final RegistryObject<Block> FRIDGE=b("fridge",TALL); public static final RegistryObject<Item> FRIDGE_ITEM=i("fridge",FRIDGE);
 public static final RegistryObject<Block> COFFEE_MAKER=b("coffee_maker",Block.box(2,0,2,14,10,14)); public static final RegistryObject<Item> COFFEE_MAKER_ITEM=i("coffee_maker",COFFEE_MAKER);

 public static final RegistryObject<Block> DINING_TABLE=b("dining_table",Block.box(0,0,0,16,12,16)); public static final RegistryObject<Item> DINING_TABLE_ITEM=i("dining_table",DINING_TABLE);
 public static final RegistryObject<Block> BAR_STOOL=b("bar_stool",Block.box(3,0,3,13,12,13)); public static final RegistryObject<Item> BAR_STOOL_ITEM=i("bar_stool",BAR_STOOL);
 public static final RegistryObject<Block> KITCHEN_ISLAND=b("kitchen_island",Block.box(0,0,0,16,14,16)); public static final RegistryObject<Item> KITCHEN_ISLAND_ITEM=i("kitchen_island",KITCHEN_ISLAND);
 public static final RegistryObject<Block> WALL_CABINET=b("wall_cabinet",Block.box(0,2,0,16,16,14)); public static final RegistryObject<Item> WALL_CABINET_ITEM=i("wall_cabinet",WALL_CABINET);
 public static final RegistryObject<Block> OVEN=b("oven",Block.box(1,0,1,15,16,15)); public static final RegistryObject<Item> OVEN_ITEM=i("oven",OVEN);
 public static final RegistryObject<Block> MICROWAVE=b("microwave",Block.box(1,4,1,15,14,15)); public static final RegistryObject<Item> MICROWAVE_ITEM=i("microwave",MICROWAVE);
 public static final RegistryObject<Block> DISHWASHER=b("dishwasher",Block.box(1,0,1,15,14,15)); public static final RegistryObject<Item> DISHWASHER_ITEM=i("dishwasher",DISHWASHER);
 public static final RegistryObject<Block> TRASH_BIN=b("trash_bin",Block.box(2,0,2,14,14,14)); public static final RegistryObject<Item> TRASH_BIN_ITEM=i("trash_bin",TRASH_BIN);
 public static final RegistryObject<Block> PLATE_RACK=b("plate_rack",Block.box(1,3,1,15,16,15)); public static final RegistryObject<Item> PLATE_RACK_ITEM=i("plate_rack",PLATE_RACK);
 public static final RegistryObject<Block> KITCHEN_SHELF=b("kitchen_shelf",Block.box(0,5,0,16,8,16)); public static final RegistryObject<Item> KITCHEN_SHELF_ITEM=i("kitchen_shelf",KITCHEN_SHELF);
 public EverydayFurnitureMod(){IEventBus bus=FMLJavaModLoadingContext.get().getModEventBus(); BLOCKS.register(bus); ITEMS.register(bus);}
}
