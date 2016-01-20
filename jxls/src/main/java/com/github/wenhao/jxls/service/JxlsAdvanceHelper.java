package com.github.wenhao.jxls.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.jxls.area.Area;
import org.jxls.builder.AreaBuilder;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.formula.FastFormulaProcessor;
import org.jxls.formula.StandardFormulaProcessor;
import org.jxls.transform.poi.PoiTransformer;

public class JxlsAdvanceHelper {

    private AreaBuilder areaBuilder;
    private boolean processFormulas = true;
    private boolean useFastFormulaProcessor = true;

    public JxlsAdvanceHelper() {
        areaBuilder = new XlsCommentAreaBuilder();
    }

    public Workbook processTemplate(InputStream inputStream, Context context) {
        PoiTransformer transformer = createTransformer(inputStream);
        areaBuilder.setTransformer(transformer);
        List<Area> xlsAreaList = areaBuilder.build();
        for (Area xlsArea : xlsAreaList) {
            xlsArea.applyAt(
                    new CellRef(xlsArea.getStartCellRef().getCellName()), context);
            if (processFormulas) {
                setFormulaProcessor(xlsArea);
                xlsArea.processFormulas();
            }
        }
       return transformer.getWorkbook();
    }

    private Area setFormulaProcessor(Area xlsArea) {
        if (useFastFormulaProcessor) {
            xlsArea.setFormulaProcessor(new FastFormulaProcessor());
        } else {
            xlsArea.setFormulaProcessor(new StandardFormulaProcessor());
        }
        return xlsArea;
    }

    private PoiTransformer createTransformer(InputStream inputStream) {
        try {
            return PoiTransformer.createTransformer(inputStream);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return null;
    }
}
