package net.yorksolutions.teamproject.models;

import net.yorksolutions.teamproject.controllers.CategoryController;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

//
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column //(nullable = false)
    private Long id;

    private String name;
    private String description;
    private String imgUrl;
    private Double price;
    private Double sale;

    private Double discount;

   @ManyToMany
    @JoinTable(name="categories_products")
    //@OneToMany //(targetEntity = Category.class, cascade = CascadeType.ALL)//(mappedBy="product")
    //@JoinColumn(name = "prodid", referencedColumnName = "id")
    private Set<Category> category;


    private boolean discontinued;






    public Product(){
        this.name = "";
        this.description = "";
        this.imgUrl = "";
        this.price = 0.0;
        this.sale = 0.0;
        this.category = null;
        this.discontinued = false;
        this.discount= 0.0;
    }

    public Product(String name, String description, String imgUrl, Double price, Double sale, Set<Category> category, boolean discontinued, Double discount){
        setName(name);
        setDescription(description);
        setImgUrl(imgUrl);
        setPrice(price);
        setSale(sale);
        setCategory(category);
        setDiscontinued(discontinued);
        setDiscount(discount);
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public void setDiscount(Double discount) {
        this.price = price - ( price * (discount/100));
        this.discount = discount;
    }

    public Double getDiscount() {return discount;
    }
}
