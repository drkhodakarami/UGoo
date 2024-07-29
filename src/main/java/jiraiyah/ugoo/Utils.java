package jiraiyah.ugoo;

import net.minecraft.util.math.BlockPos;

public class Utils
{
    public Utils() {
    }

    public static float getChance(int value)
    {
        return (100 - value) / 100.0f;
    }

    public static BlockPos getPositionDirectionTo(BlockPos position, int i)
    {
        if(i == 0)
            return position.up();
        if(i == 1)
            return position.down();
        if(i == 2)
            return position.east();
        if(i == 3)
            return position.west();
        if(i == 4)
            return position.north();
        if(i == 5)
            return position.south();
        return position;
    }

    public static BlockPos[] getPositionNextTo(BlockPos position)
    {
        return new BlockPos[]{position.up(), position.down(), position.east(), position.west(), position.north(), position.south()};
    }

    public static BlockPos[] getPositionSideTo(BlockPos position)
    {
        return new BlockPos[]{position.east(), position.west(), position.north(), position.south()};
    }

    public static BlockPos[] getPositionSideBottomTo(BlockPos position)
    {
        return new BlockPos[]{position.down(), position.east(), position.west(), position.north(), position.south()};
    }
}