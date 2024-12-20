package com.sdc.dataservice.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.sdc.data.model.BaseEntity;
import com.sdc.data.model.View;
import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@ApiModel(value = "AbstractProduct")
@JsonView(View.Default.class)
public abstract class AbstractProduct extends BaseEntity {

    @NotEmpty(message = "{data-service.name.not-empty}")
    private String name;

    @NotEmpty(message = "{data-service.description.not-empty}")
    private String description;

    @NotNull(message = "{data-service.price.not-null}")
    private Double price;

    private Boolean stock = true;


    public AbstractProduct() {}

    public AbstractProduct(String name, String description, Double unitPrice) {
        this.name = name;
        this.description = description;
        this.price = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitPrice() {
        return price;
    }

    public void setUnitPrice(Double unitPrice) {
        this.price = unitPrice;
    }

    public Boolean hasStock() {
        return stock;
    }

    public void setStock(Boolean stock) {
        this.stock = stock;
    }

    public String toString() {
        return "{\"AbstractProduct\":{ " +
            "\"name\":\"" + name + "\"," +
            "\"description\":\"" + description + "\"," +
            "\"unitPrice\":\"" + price + "\"," +
            "\"stock\":\"" + stock + "\"" +
            "\"}}";
    }
}
