package com.github.wenhao;

import com.github.wenhao.helper.ClassUtils;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

public class ChangeVersionAdapterTest {
    @Test
    public void should_change_class_version() throws IOException {
        // given

        // when
        ClassReader classReader = new ClassReader("com.github.wenhao.helper.ClassVisitorModel");
        int majorVersion = ClassUtils.getMajorVersion(classReader);

        ClassWriter classWriter = new ClassWriter(classReader, 0);
        ChangeVersionAdapter changeVersionAdapter = new ChangeVersionAdapter(classWriter);
        classReader.accept(changeVersionAdapter, 0);
        byte[] bytes = classWriter.toByteArray();

        int latestVersion = ClassUtils.getMajorVersion(bytes);

        // then
        assertThat(latestVersion).isNotEqualTo(majorVersion);
    }

}
