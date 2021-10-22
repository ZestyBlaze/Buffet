package net.zestyblaze.buffet.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class BrickGrillBlock extends HorizontalFacingBlock {

    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty LIT = Properties.LIT;

    public static final BrickGrillBlock BRICK_GRILL = new BrickGrillBlock(FabricBlockSettings.of(
                    Material.REPAIR_STATION)
            .strength(2.5f, 2.5f)
            .breakByTool(FabricToolTags.AXES)
            .requiresTool()
    );

    protected BrickGrillBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(LIT, false));
    }

    @Override
    protected void appendProperties(StateManager.@NotNull Builder<Block, BlockState> stateManager) {
        stateManager.add(FACING, LIT);
    }

    @Override
    public BlockState getPlacementState(@NotNull ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, @NotNull Entity entity) {
        if(!entity.isFireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
            entity.damage(DamageSource.HOT_FLOOR, 1.0F);
        }
    }
}

