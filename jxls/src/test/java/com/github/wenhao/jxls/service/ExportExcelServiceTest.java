package com.github.wenhao.jxls.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import com.github.wenhao.jxls.domain.Employee;

public class ExportExcelServiceTest {
    @Test
    public void should_be_able_to_export_excel() throws IOException {
        // given
        List<Employee> employees = getEmployees();
        ExportExcelService exportExcelService = new ExportExcelService();
        String template = "employee.xls";

        // when
        Workbook workbook = exportExcelService.export(employees, template);

        // then
        assertThat(workbook, notNullValue());
        FileOutputStream fileOutputStream = new FileOutputStream("result.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    private List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        for(int i=0; i < 100; i++){
            Employee employee = new Employee();
            employee.setName("Jack" + i);
            employee.setBirthDate(new Date());
            employee.setBonus(new BigDecimal(1000.234 + i));
            employee.setPayment(new BigDecimal(1234.4576 + 1));
            employees.add(employee);
        }
        return employees;
    }
}
