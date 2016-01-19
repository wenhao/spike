package com.github.wenhao.jxls.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.omg.CORBA.portable.OutputStream;

import com.github.wenhao.jxls.domain.Employee;

public class ExportExcelServiceTest {
    @Test
    public void should_be_able_to_export_excel() throws IOException {
        // given
        List<Employee> employees = getEmployees();
        ExportExcelService exportExcelService = new ExportExcelService();
        String template = "employee.xls";

        // when
        OutputStream outputStream = exportExcelService.export(employees, template);

        // then
        assertThat(outputStream, notNullValue());
    }

    private List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setName("Jack");
        employee.setBirthDate(new Date());
        employee.setPayment(new BigDecimal(1234.4576));
        employee.setBonus(new BigDecimal(23.123));

        Employee employee2 = new Employee();
        employee2.setName("Eric");
        employee2.setBirthDate(new Date());
        employee2.setPayment(new BigDecimal(987.4576));
        employee2.setBonus(new BigDecimal(423.123));

        employees.add(employee);
        employees.add(employee2);
        return employees;
    }
}
