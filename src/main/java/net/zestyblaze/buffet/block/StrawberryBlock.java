package net.zestyblaze.buffet.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.zestyblaze.buffet.item.BuffetFruits;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StrawberryBlock extends CropBlock {

    public static final Block STRAWBERRY_PLANT = new StrawberryBlock(FabricBlockSettings.of(Material.PLANT)
            .ticksRandomly()
            .collidable(false)
            .breakInstantly()
            .jumpVelocityMultiplier(-0.99f)
            .nonOpaque()
    );

    private static final Map<String, BlockPos> NEARBY_STRAWBERRIES = new HashMap<>();

    public StrawberryBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        NEARBY_STRAWBERRIES.put("north", pos.north());
        NEARBY_STRAWBERRIES.put("east", pos.east());
        NEARBY_STRAWBERRIES.put("south", pos.south());
        NEARBY_STRAWBERRIES.put("west", pos.west());


        NEARBY_STRAWBERRIES.forEach((str, nearbyPos) -> {
            if (world.getBlockState(nearbyPos).isOf(STRAWBERRY_PLANT) && ((Integer) world.getBlockState(nearbyPos).get(AGE)) < 3) {
                if (random.nextInt(20) == 0) {
                    ((StrawberryBlock) world.getBlockState(nearbyPos).getBlock()).applyGrowth(world, nearbyPos, world.getBlockState(nearbyPos));
                }
            }
        });
    }
    @Override
    protected ItemConvertible getSeedsItem() {
        return BuffetFruits.STRAWBERRIES;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.MOSS_BLOCK) || floor.isOf(Blocks.FARMLAND);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return BuffetFruits.STRAWBERRIES.getDefaultStack();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        float random = new Random().nextFloat();
        if (this.isMature(world.getBlockState(pos))) {
            world.setBlockState(pos, this.getDefaultState().with(AGE, 0));
            ItemScatterer.spawn(world, pos.getX() + random, pos.getY() + random, pos.getZ() + random, BuffetFruits.STRAWBERRIES.getDefaultStack());
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    protected int getGrowthAmount(World world) {
        return 1;
    }

    @Override
    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getGrowthAmount(world);
        int j = this.getMaxAge();
        if (i > j) {
            i++;
        }
        world.setBlockState(pos, this.withAge(i), 2);
    }
}
