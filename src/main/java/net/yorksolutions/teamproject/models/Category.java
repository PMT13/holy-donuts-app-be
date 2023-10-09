package net.yorksolutions.teamproject.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)

    //@JoinColumn(name = "catid", referencedColumnName = "id")
    private Long id;

    @ManyToMany
    Set<Product> product;

    private String category;


    public Category(){
    }
    public Category(String category){
        setCategory(category);
    }
//    public Category(Product product, String category){
//        setProduct(product);
//        setCategory(category);
//
//    }

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
