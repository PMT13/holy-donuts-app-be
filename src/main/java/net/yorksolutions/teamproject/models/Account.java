package net.yorksolutions.teamproject.models;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column//(name = "id")
            //nullable = false)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String role;
    private Long cartId;
    private Long purchasesId;

    // Normal registering where the role cannot be selected (customer register)
    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = "customer";
    }

    // Creating a new account through the administrator (admin can select and give a role to the new account)
    public Account(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getPurchasesId() {
        return purchasesId;
    }

    public void setPurchasesId(Long purchasesId) {
        this.purchasesId = purchasesId;
    }
}
