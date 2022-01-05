package net.heckinember.scoria.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.heckinember.scoria.Scoria;
import net.heckinember.scoria.block.custom.MoltenScoriaBlock;
import net.heckinember.scoria.block.custom.ScoriaBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class ModBlocks {

    public static final Block SCORIA = registerBlock("scoria",
            new ScoriaBlock(FabricBlockSettings.of(Material.STONE).strength(15f).requiresTool()), ItemGroup.BUILDING_BLOCKS);

    public static final Block MOLTEN_SCORIA = registerBlock("molten_scoria",
            new MoltenScoriaBlock(FabricBlockSettings.of(Material.STONE).strength(15f).requiresTool().luminance(3).emissiveLighting(ModBlocks::always)), ItemGroup.BUILDING_BLOCKS);

    private static boolean always(BlockState blockState, BlockView blockView, BlockPos blockPos) {
        return true;
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(Scoria.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(Scoria.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group).fireproof()));
    }

    public static void registerModBlocks () {
        System.out.println("Registering blocks for " + Scoria.MOD_ID);
    }
}
