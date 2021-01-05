package pers.cabin.java.thread;

import pers.cabin.java.StdOut;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class CasDemo {

    private static Unsafe unsafe;
    private static long stateOffset;

    private static class Target {
        private volatile int state = 0;

    }

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            Field stateField = Target.class.getDeclaredField("state");
            stateField.setAccessible(true);
            stateOffset = unsafe.objectFieldOffset(stateField);
        } catch (NoSuchFieldException| IllegalAccessException e) {
            throw new Error("cas demo init failed. For ", e);
        }

    }


    public static void main(String[] args) {
        Target target = new Target();
        StdOut.println("compareAndSwapInt: "+  unsafe.compareAndSwapInt(target, stateOffset, 0, 1));
        StdOut.println("compareAndSwapInt: "+  unsafe.compareAndSwapInt(target, stateOffset, 0, 1));
        StdOut.println("compareAndSwapInt: "+  unsafe.compareAndSwapInt(target, stateOffset, 1, 11));


    }
}
