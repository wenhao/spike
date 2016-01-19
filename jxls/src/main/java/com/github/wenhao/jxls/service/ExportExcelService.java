package com.github.wenhao.jxls.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.omg.CORBA.portable.OutputStream;

import com.github.wenhao.jxls.domain.Employee;

public class ExportExcelService {
    public OutputStream export(List<Employee> employees, String template) throws IOException {
        InputStream templateFile = this.getClass().getResourceAsStream("/" + template);
        Context context = new Context();
        context.putVar("employees", employees);
        JxlsHelper.getInstance().processTemplate(templateFile, new FileOutputStream("result.xls"), context);
        return null;
    }
}
