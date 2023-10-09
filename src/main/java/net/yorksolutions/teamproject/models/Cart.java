package net.yorksolutions.teamproject.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column//(name = "id")
            //nullable = false)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products;
    private Double totalCost;
    private Integer quantity;

    public Cart() {
        totalCost = 0D;
        quantity = 0;
        products = new ArrayList<Product>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
