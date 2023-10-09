package net.yorksolutions.teamproject.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Purchases {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column//(name = "id") //, nullable = false)
    private Long id;

    @OneToMany
    private List<Cart> pastCarts;

    public Purchases() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Cart> getPastCarts() {
        return pastCarts;
    }

    public void setPastCarts(List<Cart> pastCarts) {
        this.pastCarts = pastCarts;
    }
}
