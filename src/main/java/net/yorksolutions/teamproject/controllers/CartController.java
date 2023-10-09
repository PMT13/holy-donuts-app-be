package net.yorksolutions.teamproject.controllers;

import net.yorksolutions.teamproject.models.Cart;
import net.yorksolutions.teamproject.services.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {

    CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }



    @GetMapping("/{cartId}")
    public Optional<Cart> getCartById (@PathVariable Long cartId) {
        return cartService.getCartById(cartId);
    }

    @PutMapping()
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }


}

