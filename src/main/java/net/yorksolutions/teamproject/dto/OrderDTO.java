package net.yorksolutions.teamproject.dto;

import net.yorksolutions.teamproject.models.Product;

import java.util.List;

public class OrderDTO {
    private List<Product> cartItems;
    private String accountEmail;
    private String accountName;

    public OrderDTO(List<Product> cartItems, String accountEmail, String accountName) {
        this.cartItems = cartItems;
        this.accountEmail = accountEmail;
        this.accountName = accountName;
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Product> cartItems) {
        this.cartItems = cartItems;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
