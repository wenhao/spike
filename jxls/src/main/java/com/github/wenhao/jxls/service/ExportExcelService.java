package com.github.wenhao.jxls.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.jxls.common.Context;

import com.github.wenhao.jxls.domain.Employee;

public class ExportExcelService {
    public Workbook export(List<Employee> employees, String template) throws IOException {
        InputStream templateFile = this.getClass().getResourceAsStream("/" + template);
        Context context = new Context();
        context.putVar("employees", employees);
        JxlsAdvanceHelper jxlsAdvanceHelper = new JxlsAdvanceHelper();
        return jxlsAdvanceHelper.processTemplate(templateFile, context);
    }
}
