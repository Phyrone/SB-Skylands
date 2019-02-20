package de.sirati97.sb.skylands.gen.pop;

import de.sirati97.sb.skylands.gen.biome.nms.BiomeJungleFix;
import de.sirati97.sb.skylands.gen.biome.nms.BiomeSwampFix;
import de.sirati97.sb.skylands.gen.biome.nms.BiomeDesertFix;
import net.minecraft.server.v1_13_R2.BiomeBase;
import net.minecraft.server.v1_13_R2.BiomeJungle;
import net.minecraft.server.v1_13_R2.BiomeSwamp;
import net.minecraft.server.v1_13_R2.BiomeDesert;
import net.minecraft.server.v1_13_R2.BlockPosition;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_13_R2.CraftWorld;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;


public class BiomePopulator extends BlockPopulator {
	
	@Override
	public void populate(World world, Random random, Chunk chunk) {
		net.minecraft.server.v1_13_R2.World nmsWorld = ((CraftWorld)world).getHandle();
		BlockPosition position = new BlockPosition(chunk.getX() * 16, 80, chunk.getZ() * 16);
		BiomeBase biomeBase = nmsWorld.getBiome(position);
                
                if(biomeBase instanceof BiomeJungle)
                    biomeBase = BiomeJungleFix.getFix((BiomeJungle) biomeBase);
                else if (biomeBase instanceof BiomeSwamp)
                    biomeBase = BiomeSwampFix.getFix((BiomeSwamp) biomeBase);
                else if (biomeBase instanceof BiomeDesert)
                    biomeBase = BiomeDesertFix.getFix((BiomeDesert) biomeBase);
                
		try {
			biomeBase.a(nmsWorld, random, position);
		}catch (RuntimeException e){
			e.printStackTrace();
			// Decorator was already called on this chunk :/
		}
	}
	
}