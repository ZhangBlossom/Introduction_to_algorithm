package com.itheima.other;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class ObjectLayoutExample {
    private int x;
    private boolean y;
    private String z;

    public ObjectLayoutExample(int x, boolean y, String z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // 压缩指针需要*8+堆内存起始地址
    public static void main(String[] args) {
        ObjectLayoutExample obj = new ObjectLayoutExample(1, true, "test");
        long address = getAddress(obj);
        System.out.println("对象在内存中的地址为：" + Long.toHexString((int)address));
        System.out.println(Long.toHexString(VM.current().addressOf(obj)));
        System.out.println();
    }

    private static long getAddress(Object obj) {
        Object[] array = new Object[] {obj};
        // 计算对象的起始地址
        Unsafe unsafe = getUnsafe();
        long baseOffset = unsafe.ARRAY_OBJECT_BASE_OFFSET;
        long address = unsafe.getInt(array, baseOffset);
        return address;
    }

    private static Unsafe getUnsafe() {
        final Field theUnsafe;
        try {
            theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe unsafe  = (Unsafe) theUnsafe.get(null);
            return unsafe;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
