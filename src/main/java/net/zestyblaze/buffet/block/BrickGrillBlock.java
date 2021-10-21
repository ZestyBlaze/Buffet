package net.zestyblaze.buffet.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;

public class BrickGrillBlock extends HorizontalFacingBlock {

    public static final BrickGrillBlock BRICK_GRILL = new BrickGrillBlock(FabricBlockSettings.of(
                    Material.REPAIR_STATION)
            .strength(2.5f, 2.5f)
            .breakByTool(FabricToolTags.AXES)
            .requiresTool()
    );

    protected BrickGrillBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.@NotNull Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getPlacementState(@NotNull ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }
}
