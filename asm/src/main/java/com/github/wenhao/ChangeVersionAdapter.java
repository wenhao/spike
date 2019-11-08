package com.github.wenhao;

import org.objectweb.asm.ClassVisitor;
import static org.objectweb.asm.Opcodes.ASM7;
import static org.objectweb.asm.Opcodes.V1_5;

public class ChangeVersionAdapter extends ClassVisitor {
    public ChangeVersionAdapter(final ClassVisitor classVisitor) {
        super(ASM7, classVisitor);
    }

    @Override
    public void visit(final int version, final int access, final String name, final String signature, final String superName, final String[] interfaces) {
        cv.visit(V1_5, access, name, signature, superName, interfaces);
    }
}
