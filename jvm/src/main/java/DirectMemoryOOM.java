import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        final Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);
        final Unsafe unsafe = (Unsafe) declaredField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
