package net.ale.grapheneextension.block;

import net.ale.grapheneextension.GrapheneExtension;
import net.ale.grapheneextension.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GrapheneExtension.MOD_ID);

    public static final DeferredBlock<Block> GRAPHENE_BLOCK = registerBlock("graphene_block",
            Block::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK));

    public static final DeferredBlock<Block> GRAPHENE_ORE = registerBlock("graphene_ore",
            props -> new DropExperienceBlock(UniformInt.of(3, 6), props),
            () -> BlockBehaviour.Properties.of()
                    .strength(2.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE));

    public static final DeferredBlock<Block> DEEPSLATE_GRAPHENE_ORE = registerBlock("deepslate_graphene_ore",
            props -> new DropExperienceBlock(UniformInt.of(4, 8), props),
            () -> BlockBehaviour.Properties.of()
                    .strength(3.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE));

    public static final DeferredBlock<Block> NETHER_GRAPHENE_ORE = registerBlock("nether_graphene_ore",
            props -> new DropExperienceBlock(UniformInt.of(3, 7), props),
            () -> BlockBehaviour.Properties.of()
                    .strength(1.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERRACK));

    public static final DeferredBlock<Block> END_STONE_GRAPHENE_ORE = registerBlock("end_stone_graphene_ore",
            props -> new DropExperienceBlock(UniformInt.of(5, 10), props),
            () -> BlockBehaviour.Properties.of()
                    .strength(5.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name,
                                                                   Function<BlockBehaviour.Properties, ? extends T> func,
                                                                   Supplier<BlockBehaviour.Properties> properties) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, func, properties);
        registerBlockItem(toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(DeferredBlock<T> block) {
        ModItems.ITEMS.registerSimpleBlockItem(block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
