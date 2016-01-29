package com.github.wenhao.jxls.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Good
{
    public String name;
    public Date productionDate;
    public BigDecimal price;
    private String brand;
    private String promotion;
    private String model;
    private String color;
    private String screenSize;
    private String resolution;
    private String power;

    public Good() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProductionDate(Date birthDate) {
        this.productionDate = birthDate;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setPromotion(String promotion)
    {
        this.promotion = promotion;
    }

    public String getPromotion()
    {
        return promotion;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getModel()
    {
        return model;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getColor()
    {
        return color;
    }

    public void setScreenSize(String screenSize)
    {
        this.screenSize = screenSize;
    }

    public String getScreenSize()
    {
        return screenSize;
    }

    public void setResolution(String resolution)
    {
        this.resolution = resolution;
    }

    public String getResolution()
    {
        return resolution;
    }

    public void setPower(String power)
    {
        this.power = power;
    }

    public String getPower()
    {
        return power;
    }
}
