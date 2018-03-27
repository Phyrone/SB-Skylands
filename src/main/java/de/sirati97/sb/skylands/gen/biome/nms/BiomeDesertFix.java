package de.sirati97.sb.skylands.gen.biome.nms;

import net.minecraft.server.v1_12_R1.BiomeBase;
import net.minecraft.server.v1_12_R1.BiomeDesert;
import net.minecraft.server.v1_12_R1.BlockFlowers;
import net.minecraft.server.v1_12_R1.BlockPosition;
import net.minecraft.server.v1_12_R1.ChunkSnapshot;
import net.minecraft.server.v1_12_R1.EnumCreatureType;
import net.minecraft.server.v1_12_R1.World;
import net.minecraft.server.v1_12_R1.WorldGenDesertWell;
import net.minecraft.server.v1_12_R1.WorldGenerator;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BiomeDesertFix extends BiomeBase {
    private final static Map<BiomeDesert, BiomeDesertFix> fixMap = new HashMap<>();
    //    private final static Method aBiomeDecoratorMethod;
    private final static Field[] fields;
    private final static a a = new BiomeBase.a("Desert");
    private final BiomeDesert biomeDesert;

    static {
        Class biomeBase = BiomeBase.class;
        Field[] decFields = biomeBase.getDeclaredFields();
        List<Field> fieldsList = new ArrayList<>();
        for (int i = 0; i < decFields.length; i++) {
            int modifier = decFields[i].getModifiers();
            if (Modifier.isStatic(modifier) || Modifier.isFinal(modifier)) {
                continue;
            }
            decFields[i].setAccessible(true);
            fieldsList.add(decFields[i]);
        }
        fields = fieldsList.toArray(new Field[fieldsList.size()]);
    }

    public static BiomeDesertFix getFix(BiomeDesert biomeDesert) {
        if (fixMap.containsKey(biomeDesert)) {
            return fixMap.get(biomeDesert);
        } else {
            BiomeDesertFix fix = new BiomeDesertFix(biomeDesert);
            fixMap.put(biomeDesert, fix);
            return fix;
        }
    }


    public BiomeDesertFix(BiomeDesert biomeDesert) {
        super(a);
        try {
            for (Field field : fields) {
                field.set(this, field.get(biomeDesert));
            }
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
        this.biomeDesert = biomeDesert;
    }

//
//    @Override
//    protected BiomeDecorator a() {
//        try {
//            return (BiomeDecorator) aBiomeDecoratorMethod.invoke(biomeDesert);
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            throw new IllegalStateException(e);
//        }
//    }

    @Override
    public BlockFlowers.EnumFlowerVarient a(Random random, BlockPosition blockPosition) {
        return biomeDesert.a(random, blockPosition);
    }

    @Override
    public void a(World world, Random random, ChunkSnapshot chunkSnapshot, int i, int i1, double v) {
        biomeDesert.a(world, random, chunkSnapshot, i, i1, v);
    }

    @Override
    public boolean b() {
        return biomeDesert.b();
    }

    @Override
    public boolean d() {
        return biomeDesert.d();
    }

    @Override
    public boolean e() {
        return biomeDesert.e();
    }

    @Override
    public float f() {
        return biomeDesert.f();
    }

    @Override
    public boolean i() {
        return biomeDesert.i();
    }

    @Override
    public Class<? extends BiomeBase> g() {
        return biomeDesert.g();
    }
    

    @Override
    public List<BiomeMeta> getMobs(EnumCreatureType enumCreatureType) {
        return biomeDesert.getMobs(enumCreatureType);
    }

    @Override
    public EnumTemperature h() {
        return biomeDesert.h();
    }
    //end


    public void a(World worldIn, Random rand, BlockPosition pos) {
        super.a(worldIn, rand, pos);

        if (rand.nextInt(1000) == 0)
        {
            int i = rand.nextInt(16) + 8;
            int j = rand.nextInt(16) + 8;
            BlockPosition blockpos = worldIn.getHighestBlockYAt(pos.a(i, 0, j)).up();
            (new WorldGenDesertWell()).generate(worldIn, rand, blockpos);
        }

        //No thanks!
//        if (rand.nextInt(64) == 0)
//        {
//            (new WorldGenFossils()).generate(worldIn, rand, pos);
//        }
    }
}
