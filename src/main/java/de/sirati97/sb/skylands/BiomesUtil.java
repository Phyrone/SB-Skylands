package de.sirati97.sb.skylands;

import org.bukkit.block.Biome;

/**
 * Created by sirati97 on 12.06.2016.
 */
public final class BiomesUtil {
    private BiomesUtil() {
        throw new UnsupportedOperationException();
    }

    public static boolean isPlains(Biome biome) {
        return Biome.PLAINS.equals(biome) || Biome.SUNFLOWER_PLAINS.equals(biome);
    }

    public static boolean isDesert(Biome biome) {
        return Biome.DESERT.equals(biome) || Biome.DESERT_HILLS.equals(biome) || Biome.DESERT_LAKES.equals(biome);
    }

    public static boolean isTaiga(Biome biome, boolean snowy) {
        return (Biome.TAIGA.equals(biome) || Biome.TAIGA_HILLS.equals(biome) || Biome.TAIGA_MOUNTAINS.equals(biome) ||
                Biome.GIANT_TREE_TAIGA.equals(biome) || Biome.GIANT_TREE_TAIGA_HILLS.equals(biome) || Biome.GIANT_SPRUCE_TAIGA.equals(biome) || Biome.GIANT_SPRUCE_TAIGA_HILLS.equals(biome)) ||
                (snowy && (
                            Biome.SNOWY_TAIGA.equals(biome) || Biome.SNOWY_TAIGA_HILLS.equals(biome) || Biome.SNOWY_TAIGA_MOUNTAINS.equals(biome)
                        ));
    }

    public static boolean isForest(Biome biome) {
        return Biome.FOREST.equals(biome) || Biome.WOODED_HILLS.equals(biome) || Biome.FLOWER_FOREST.equals(biome) ||
                Biome.BIRCH_FOREST.equals(biome) || Biome.TALL_BIRCH_FOREST.equals(biome) || Biome.TALL_BIRCH_HILLS.equals(biome) ||
                Biome.DARK_FOREST.equals(biome) || Biome.DARK_FOREST_HILLS.equals(biome);
    }

    public static boolean isMushroom(Biome biome) {
        return Biome.MUSHROOM_FIELDS.equals(biome) || Biome.MUSHROOM_FIELD_SHORE.equals(biome);
    }

    public static boolean isMesa(Biome biome) {
        return Biome.BADLANDS.equals(biome) || Biome.BADLANDS_PLATEAU.equals(biome) || Biome.WOODED_BADLANDS_PLATEAU.equals(biome) || Biome.ERODED_BADLANDS.equals(biome) || Biome.MODIFIED_BADLANDS_PLATEAU.equals(biome) || Biome.MODIFIED_WOODED_BADLANDS_PLATEAU.equals(biome);
    }

    public static boolean isOcean(Biome biome) {
        return Biome.OCEAN.equals(biome) || Biome.DEEP_OCEAN.equals(biome) || Biome.FROZEN_OCEAN.equals(biome) || Biome.BEACH.equals(biome) || Biome.STONE_SHORE.equals(biome) || Biome.SNOWY_BEACH.equals(biome);
    }

    public static boolean isSwampland(Biome biome) {
        return Biome.SWAMP.equals(biome) || Biome.SWAMP_HILLS.equals(biome);
    }

    public static boolean isSavanna(Biome biome) {
        return Biome.SAVANNA.equals(biome) || Biome.SAVANNA_PLATEAU.equals(biome) || Biome.SHATTERED_SAVANNA.equals(biome) || Biome.SHATTERED_SAVANNA_PLATEAU.equals(biome);
    }

    public static boolean isExtremeHills(Biome biome) {
        return Biome.MOUNTAINS.equals(biome) || Biome.WOODED_MOUNTAINS.equals(biome) || Biome.GRAVELLY_MOUNTAINS.equals(biome) || Biome.MOUNTAIN_EDGE.equals(biome) || Biome.MODIFIED_GRAVELLY_MOUNTAINS.equals(biome);
    }

    public static boolean isHell(Biome biome) {
        return Biome.NETHER.equals(biome);
    }

    public static boolean isTheEnd(Biome biome) {
        return Biome.THE_END.equals(biome);
    }

    public static boolean isIcy(Biome biome) {
        return Biome.SNOWY_TUNDRA.equals(biome) || Biome.SNOWY_MOUNTAINS.equals(biome) || Biome.ICE_SPIKES.equals(biome) ||
                Biome.FROZEN_OCEAN.equals(biome) || Biome.FROZEN_RIVER.equals(biome) || Biome.SNOWY_BEACH.equals(biome) ||
                Biome.SNOWY_TAIGA.equals(biome) || Biome.SNOWY_TAIGA_HILLS.equals(biome) || Biome.SNOWY_TAIGA_MOUNTAINS.equals(biome);
    }

    public static boolean isJungle(Biome biome) {
        return Biome.JUNGLE.equals(biome) || Biome.JUNGLE_EDGE.equals(biome) || Biome.JUNGLE_HILLS.equals(biome) || Biome.JUNGLE_EDGE.equals(biome) || Biome.MODIFIED_JUNGLE.equals(biome) || Biome.MODIFIED_JUNGLE_EDGE.equals(biome);
    }
}
