package com.github.wenhao.jxls.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
    public String name;
    public Date birthDate;
    public BigDecimal payment;
    public BigDecimal bonus;

    public Employee() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }
}
