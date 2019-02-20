package uk.co.jacekk.bukkit.skylandsplus.generation;

import de.sirati97.sb.skylands.BiomesUtil;
import net.minecraft.server.v1_13_R2.BlockPosition;
import net.minecraft.server.v1_13_R2.Blocks;
import net.minecraft.server.v1_13_R2.WorldGenLakes;
import net.minecraft.server.v1_13_R2.WorldGenReed;
import org.bukkit.Chunk;
import org.bukkit.craftbukkit.v1_13_R2.CraftWorld;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class LakePopulator
        extends BlockPopulator {
    private Random random;
    private final int offset;

    public LakePopulator(org.bukkit.World world, int offset) {
        this.random = new Random(world.getSeed());
        this.offset = offset;
    }

    public void populate(org.bukkit.World world, Random random, Chunk chunk) {
        net.minecraft.server.v1_13_R2.World mcWorld = ((CraftWorld) world).getHandle();

        int worldChunkX = chunk.getX() * 16;
        int worldChunkZ = chunk.getZ() * 16;
        if (this.random.nextInt(4) == 0) {
            int x = worldChunkX + this.random.nextInt(16) + 8;
            int z = worldChunkZ + this.random.nextInt(16) + 8;
            if (BiomesUtil.isJungle(world.getBiome(x, z))) {
                int y = world.getHighestBlockYAt(x, z) + 2;
                BlockPosition pos = new BlockPosition(x, y, z);
                if (this.random.nextInt(100) < 85 + offset) {
                    WorldGenLakes wgl = new WorldGenLakes(Blocks.WATER);
                    wgl.generate(mcWorld, this.random, pos);
                    WorldGenReed wgr = new WorldGenReed();
                    wgr.generate(mcWorld, this.random, pos);
                } else {
                    WorldGenLakes wgl = new WorldGenLakes(Blocks.LAVA);
                    wgl.generate(mcWorld, this.random, pos);
                }
            }
        }
    }
}
