package com.primary.model.searchItems;

public class ItemResponse {

    private String id;
    private String title;
    private String currency_id;
    private Double price;
    private Boolean accepts_mercadopago;
    private Shipping shipping;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getAccepts_mercadopago() {
        return accepts_mercadopago;
    }

    public void setAccepts_mercadopago(Boolean accepts_mercadopago) {
        this.accepts_mercadopago = accepts_mercadopago;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }
}

