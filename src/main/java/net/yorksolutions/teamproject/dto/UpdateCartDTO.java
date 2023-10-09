package net.yorksolutions.teamproject.dto;

import net.yorksolutions.teamproject.models.Product;

import java.util.List;


public class UpdateCartDTO {
    public Long id;
    public List<Product> products;
    public Long totalCost;
    public Integer quantity;
    public String coupon;

}
