package com.github.wenhao.jxls.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import com.github.wenhao.jxls.domain.Good;

public class ExportExcelServiceTest {
    @Test
    public void should_be_able_to_export_excel() throws IOException {
        // given
        List<Good> goods = getEmployees();
        ExportExcelService exportExcelService = new ExportExcelService();
        String template = "employee.xls";

        // when
        Workbook workbook = exportExcelService.export(goods, template);

        // then
        assertThat(workbook, notNullValue());

        FileOutputStream fileOutputStream = new FileOutputStream("result.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    private List<Good> getEmployees() {
        List<Good> goods = new ArrayList<>();
        for(int i=0; i < 100; i++){
            Good good = new Good();
            good.setName("三星（SAMSUNG）S27D590C 27英寸曲面屏LED背光液晶显示器" + i);
            good.setProductionDate(new Date());
            good.setPrice(new BigDecimal(2299.00 + 1));
            good.setBrand("三星 SAMSUNG");
            good.setPromotion("【三重礼包】28-31日购买该产品享受：1.下单直降100 2.送雷柏游戏装备（数量有限送完即止）3.用白条分期付款免息免手续费（1-12个月）");
            good.setModel("LS27D590CS");
            good.setColor("黑色");
            good.setScreenSize("27英寸");
            good.setResolution("1920 x 1080");
            good.setPower("100-240V (50/60hz)");
            goods.add(good);
        }
        return goods;
    }
}
