package com.primary.model.searchItems;

public class FEItem {

    private String title;
    private Double price;
    private String idItem;

    public FEItem(String title, Double price, String idItem) {
        this.title = title;
        this.price = price;
        this.idItem = idItem;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public String getIdItem() {
        return idItem;
    }
}
