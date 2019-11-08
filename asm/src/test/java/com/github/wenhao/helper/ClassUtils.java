package com.github.wenhao.helper;

import org.objectweb.asm.ClassReader;

public class ClassUtils {

    public static int getMajorVersion(final byte[] b) {
        return ((b[6] & 0xFF) << 8) | (b[7] & 0xFF);
    }

    public static int getMajorVersion(final ClassReader reader) {
        // relative to the beginning of constant pool because ASM provides API
        // to construct ClassReader which reads from the middle of array
        final int firstConstantPoolEntryOffset = reader.getItem(1) - 1;
        return reader.readUnsignedShort(firstConstantPoolEntryOffset - 4);
    }
}
