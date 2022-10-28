package com.example.abanobfinalorangeproject.model;

public class CartItemModel {
    String cartImage;
    String cartName;
    double cartItemPrice;

    public String getCartImage() {
        return cartImage;
    }

    public String getCartName() {
        return cartName;
    }

    public double getCartItemPrice() {
        return cartItemPrice;
    }

    public void setCartImage(String cartImage) {
        this.cartImage = cartImage;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    public void setCartItemPrice(double cartItemPrice) {
        this.cartItemPrice = cartItemPrice;
    }
}
