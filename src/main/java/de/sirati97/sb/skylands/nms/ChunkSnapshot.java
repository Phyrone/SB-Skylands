package de.sirati97.sb.skylands.nms;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import net.minecraft.server.v1_13_R2.Block;
import net.minecraft.server.v1_13_R2.Blocks;
import net.minecraft.server.v1_13_R2.IBlockData;

public class ChunkSnapshot {
    private static final IBlockData a;
    private final char[] b = new char[65536];

    public ChunkSnapshot() {
    }

    public IBlockData a(int var1, int var2, int var3) {
        IBlockData var4 = (IBlockData) Block.REGISTRY_ID.fromId(this.b[b(var1, var2, var3)]);
        return var4 == null ? a : var4;
    }

    public void a(int var1, int var2, int var3, IBlockData var4) {
        this.b[b(var1, var2, var3)] = (char)Block.REGISTRY_ID.getId(var4);
    }

    private static int b(int var0, int var1, int var2) {
        return var0 << 12 | var2 << 8 | var1;
    }

    public int a(int var1, int var2) {
        int var3 = (var1 << 12 | var2 << 8) + 256 - 1;

        for(int var4 = 255; var4 >= 0; --var4) {
            IBlockData var5 = (IBlockData)Block.REGISTRY_ID.fromId(this.b[var3 + var4]);
            if (var5 != null && var5 != a) {
                return var4;
            }
        }

        return 0;
    }

    static {
        a = Blocks.AIR.getBlockData();
    }
}

