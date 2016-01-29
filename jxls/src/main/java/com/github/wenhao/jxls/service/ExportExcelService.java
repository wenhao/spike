package com.github.wenhao.jxls.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.jxls.common.Context;

import com.github.wenhao.jxls.domain.Good;

public class ExportExcelService {
    public Workbook export(List<Good> goods, String template) throws IOException {
        InputStream templateFile = this.getClass().getResourceAsStream("/" + template);
        Context context = new Context();
        context.putVar("goods", goods);
        JxlsAdvanceHelper jxlsAdvanceHelper = new JxlsAdvanceHelper();
        return jxlsAdvanceHelper.processTemplate(templateFile, context);
    }
}
