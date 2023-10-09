package net.yorksolutions.teamproject.services;


import net.yorksolutions.teamproject.models.Cart;
import net.yorksolutions.teamproject.repositories.AccountRepository;
import net.yorksolutions.teamproject.repositories.CartRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CartService {
    CartRepo cartRepo;
    AccountRepository accountRepo;
    public CartService(AccountRepository accountRepository, CartRepo cartRepo) {
        this.cartRepo = cartRepo;
        this.accountRepo = accountRepository;
    }

    public Optional<Cart> getCartById(Long cartId) {
        return cartRepo.findById(cartId);
    }

    public Cart updateCart(Cart cart) {
        return cartRepo.save(cart);
    }
}
