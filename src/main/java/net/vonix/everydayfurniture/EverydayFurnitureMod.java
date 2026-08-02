package net.vonix.everydayfurniture;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(EverydayFurnitureMod.MOD_ID)
public final class EverydayFurnitureMod {
    public static final String MOD_ID = "everydayfurniture";
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);

    private static RegistryObject<Block> furniture(String id, VoxelShape shape) {
        String appliance = id.equals("oven") || id.equals("microwave") || id.equals("coffee_maker") ? id : "";
        float seatHeight = id.equals("chair") ? .625f : (id.equals("sofa") || id.equals("bar_stool") ? .75f : (id.equals("toilet") ? .55f : 0f));
        return BLOCKS.register(id, () -> new FurnitureBlock(shape, appliance, seatHeight));
    }
    private static RegistryObject<Block> storage(String id, VoxelShape shape) { return BLOCKS.register(id, () -> new StorageBlock(shape)); }
    private static RegistryObject<Item> item(String id, RegistryObject<Block> block) { return ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(EverydayFurnitureTab.TAB))); }

    private static final VoxelShape SEAT = Block.box(1, 0, 1, 15, 10, 15);
    private static final VoxelShape TABLE_SHAPE = Block.box(1, 0, 1, 15, 12, 15);
    private static final VoxelShape TALL = Block.box(1, 0, 1, 15, 16, 15);

    public static final RegistryObject<Block> CHAIR = furniture("chair", SEAT); public static final RegistryObject<Item> CHAIR_ITEM = item("chair", CHAIR);
    public static final RegistryObject<Block> TABLE = furniture("table", TABLE_SHAPE); public static final RegistryObject<Item> TABLE_ITEM = item("table", TABLE);
    public static final RegistryObject<Block> SOFA = furniture("sofa", Block.box(0, 0, 0, 16, 12, 12)); public static final RegistryObject<Item> SOFA_ITEM = item("sofa", SOFA);
    public static final RegistryObject<Block> BEDSIDE_TABLE = storage("bedside_table", Block.box(1, 0, 1, 15, 14, 15)); public static final RegistryObject<Item> BEDSIDE_TABLE_ITEM = item("bedside_table", BEDSIDE_TABLE);
    public static final RegistryObject<Block> CABINET = storage("cabinet", TALL); public static final RegistryObject<Item> CABINET_ITEM = item("cabinet", CABINET);
    public static final RegistryObject<Block> LAMP = BLOCKS.register("lamp", LampBlock::new); public static final RegistryObject<Item> LAMP_ITEM = item("lamp", LAMP);
    public static final RegistryObject<Block> BOOKSHELF = storage("bookshelf", TALL); public static final RegistryObject<Item> BOOKSHELF_ITEM = item("bookshelf", BOOKSHELF);
    public static final RegistryObject<Block> KITCHEN_COUNTER = storage("kitchen_counter", Block.box(0, 0, 0, 16, 14, 16)); public static final RegistryObject<Item> KITCHEN_COUNTER_ITEM = item("kitchen_counter", KITCHEN_COUNTER);
    public static final RegistryObject<Block> SINK = BLOCKS.register("sink", () -> new SinkBlock(Block.box(1, 10, 1, 15, 16, 15))); public static final RegistryObject<Item> SINK_ITEM = item("sink", SINK);
    public static final RegistryObject<Block> TOILET = furniture("toilet", Block.box(2, 0, 2, 14, 12, 14)); public static final RegistryObject<Item> TOILET_ITEM = item("toilet", TOILET);
    public static final RegistryObject<Block> FRIDGE = storage("fridge", TALL); public static final RegistryObject<Item> FRIDGE_ITEM = item("fridge", FRIDGE);
    public static final RegistryObject<Block> COFFEE_MAKER = furniture("coffee_maker", Block.box(2, 0, 2, 14, 10, 14)); public static final RegistryObject<Item> COFFEE_MAKER_ITEM = item("coffee_maker", COFFEE_MAKER);
    public static final RegistryObject<Block> DINING_TABLE = furniture("dining_table", Block.box(0, 0, 0, 16, 12, 16)); public static final RegistryObject<Item> DINING_TABLE_ITEM = item("dining_table", DINING_TABLE);
    public static final RegistryObject<Block> BAR_STOOL = furniture("bar_stool", Block.box(3, 0, 3, 13, 12, 13)); public static final RegistryObject<Item> BAR_STOOL_ITEM = item("bar_stool", BAR_STOOL);
    public static final RegistryObject<Block> KITCHEN_ISLAND = storage("kitchen_island", Block.box(0, 0, 0, 16, 14, 16)); public static final RegistryObject<Item> KITCHEN_ISLAND_ITEM = item("kitchen_island", KITCHEN_ISLAND);
    public static final RegistryObject<Block> WALL_CABINET = storage("wall_cabinet", Block.box(0, 2, 0, 16, 16, 14)); public static final RegistryObject<Item> WALL_CABINET_ITEM = item("wall_cabinet", WALL_CABINET);
    public static final RegistryObject<Block> OVEN = furniture("oven", Block.box(1, 0, 1, 15, 16, 15)); public static final RegistryObject<Item> OVEN_ITEM = item("oven", OVEN);
    public static final RegistryObject<Block> MICROWAVE = furniture("microwave", Block.box(1, 4, 1, 15, 14, 15)); public static final RegistryObject<Item> MICROWAVE_ITEM = item("microwave", MICROWAVE);
    public static final RegistryObject<Block> DISHWASHER = storage("dishwasher", Block.box(1, 0, 1, 15, 14, 15)); public static final RegistryObject<Item> DISHWASHER_ITEM = item("dishwasher", DISHWASHER);
    public static final RegistryObject<Block> TRASH_BIN = BLOCKS.register("trash_bin", () -> new TrashBinBlock(Block.box(2, 0, 2, 14, 14, 14))); public static final RegistryObject<Item> TRASH_BIN_ITEM = item("trash_bin", TRASH_BIN);
    public static final RegistryObject<Block> PLATE_RACK = storage("plate_rack", Block.box(1, 3, 1, 15, 16, 15)); public static final RegistryObject<Item> PLATE_RACK_ITEM = item("plate_rack", PLATE_RACK);
    public static final RegistryObject<Block> KITCHEN_SHELF = storage("kitchen_shelf", Block.box(0, 5, 0, 16, 8, 16)); public static final RegistryObject<Item> KITCHEN_SHELF_ITEM = item("kitchen_shelf", KITCHEN_SHELF);

    public static final RegistryObject<BlockEntityType<StorageBlockEntity>> STORAGE_BLOCK_ENTITY = BLOCK_ENTITIES.register("storage", () -> BlockEntityType.Builder.of(StorageBlockEntity::new, BEDSIDE_TABLE.get(), CABINET.get(), BOOKSHELF.get(), KITCHEN_COUNTER.get(), FRIDGE.get(), KITCHEN_ISLAND.get(), WALL_CABINET.get(), DISHWASHER.get(), PLATE_RACK.get(), KITCHEN_SHELF.get()).build(null));
    public static final RegistryObject<EntityType<FurnitureSeatEntity>> SEAT_ENTITY = ENTITY_TYPES.register("seat", () -> EntityType.Builder.of(FurnitureSeatEntity::new, MobCategory.MISC).sized(.01f, .01f).noSave().noSummon().clientTrackingRange(10).updateInterval(1).build(MOD_ID + ":seat"));

    public EverydayFurnitureMod() { IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus(); BLOCKS.register(bus); ITEMS.register(bus); BLOCK_ENTITIES.register(bus); ENTITY_TYPES.register(bus); }
}
