package com.sdc.dataservice.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.sdc.data.model.BaseEntity;
import com.sdc.data.model.View;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Schema(description = "AbstractProduct")
@JsonView(View.Default.class)
public abstract class AbstractProduct extends BaseEntity {

    @NotEmpty(message = "service.product-name.not-empty")
    private String name;

    @NotEmpty(message = "service.product-description.not-empty")
    private String description;

    @NotNull(message = "service.product-price.not-null")
    private Double price;

    private Boolean stock = true;


    public AbstractProduct() {}

    public AbstractProduct(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double unitPrice) {
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
            "\"price\":\"" + price + "\"," +
            "\"stock\":\"" + stock + "\"" +
            "\"}}";
    }
}
