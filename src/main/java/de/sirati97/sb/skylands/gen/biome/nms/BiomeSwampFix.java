package de.sirati97.sb.skylands.gen.biome.nms;

import net.minecraft.server.v1_13_R2.BiomeBase;
import net.minecraft.server.v1_13_R2.BiomeSwamp;
import net.minecraft.server.v1_13_R2.BlockFlowers;
import net.minecraft.server.v1_13_R2.BlockPosition;
import net.minecraft.server.v1_13_R2.ChunkSnapshot;
import net.minecraft.server.v1_13_R2.EnumCreatureType;
import net.minecraft.server.v1_13_R2.World;
import net.minecraft.server.v1_13_R2.WorldGenDesertWell;
import net.minecraft.server.v1_13_R2.WorldGenerator;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class BiomeSwampFix extends BiomeBase {
    private final static Map<BiomeSwamp, BiomeSwampFix> fixMap = new HashMap<>();
    //    private final static Method aBiomeDecoratorMethod;
    private final static Field[] fields;
    private final static a a = new BiomeBase.a("Swamp");
    private final BiomeSwamp biomeSwamp;

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

    public static BiomeSwampFix getFix(BiomeSwamp biomeSwamp) {
        if (fixMap.containsKey(biomeSwamp)) {
            return fixMap.get(biomeSwamp);
        } else {
            BiomeSwampFix fix = new BiomeSwampFix(biomeSwamp);
            fixMap.put(biomeSwamp, fix);
            return fix;
        }
    }


    public BiomeSwampFix(BiomeSwamp biomeSwamp) {
        super(a);
        try {
            for (Field field : fields) {
                field.set(this, field.get(biomeSwamp));
            }
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
        this.biomeSwamp = biomeSwamp;
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
        return biomeSwamp.a(random, blockPosition);
    }

    @Override
    public void a(World world, Random random, ChunkSnapshot chunkSnapshot, int i, int i1, double v) {
        biomeSwamp.a(world, random, chunkSnapshot, i, i1, v);
    }

    @Override
    public boolean b() {
        return biomeSwamp.b();
    }

    @Override
    public boolean d() {
        return biomeSwamp.d();
    }

    @Override
    public boolean e() {
        return biomeSwamp.e();
    }

    @Override
    public float f() {
        return biomeSwamp.f();
    }

    @Override
    public boolean i() {
        return biomeSwamp.i();
    }

    @Override
    public Class<? extends BiomeBase> g() {
        return biomeSwamp.g();
    }
    

    @Override
    public List<BiomeMeta> getMobs(EnumCreatureType enumCreatureType) {
        return biomeSwamp.getMobs(enumCreatureType);
    }

    @Override
    public EnumTemperature h() {
        return biomeSwamp.h();
    }
    //end


    public void a(World worldIn, Random rand, BlockPosition pos) {
        super.a(worldIn, rand, pos);

         super.a(worldIn, rand, pos);

         //Nope!
//        if (rand.nextInt(64) == 0)
//        {
//            (new WorldGenFossils()).generate(worldIn, rand, pos);
//        }
    }
}
