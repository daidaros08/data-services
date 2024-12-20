package com.sdc.dataservice.model;

public class Empanada extends AbstractProduct {

    private Double halfDozenPrice;
    private Double fullDozenPrice;

    public Double getHalfDozenPrice() {
        return halfDozenPrice;
    }

    public void setHalfDozenPrice(Double halfDozenPrice) {
        this.halfDozenPrice = halfDozenPrice;
    }

    public Double getFullDozenPrice() {
        return fullDozenPrice;
    }

    public void setFullDozenPrice(Double fullDozenPrice) {
        this.fullDozenPrice = fullDozenPrice;
    }



}
