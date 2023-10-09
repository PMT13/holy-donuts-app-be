package net.yorksolutions.teamproject.services;

import net.yorksolutions.teamproject.dto.AddAccountDTO;
import net.yorksolutions.teamproject.models.Account;
import net.yorksolutions.teamproject.models.Cart;
import net.yorksolutions.teamproject.models.Purchases;
import net.yorksolutions.teamproject.repositories.AccountRepository;
import net.yorksolutions.teamproject.repositories.CartRepo;
import net.yorksolutions.teamproject.repositories.PurchasesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    AccountRepository repo;
    CartRepo cartRepo;
    PurchasesRepository purchasesRepository;
    public AccountService(AccountRepository repo, CartRepo cartRepo, PurchasesRepository purchasesRepository) {
        this.repo = repo;
        this.cartRepo = cartRepo;
        this.purchasesRepository = purchasesRepository;
    }

    public Iterable<Account> getAccounts() {
        return this.repo.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return this.repo.findById(id);
    }

    public Account create(AddAccountDTO request) {
        Account newAccount = new Account(request.getUsername(),request.getPassword(), request.getEmail());
        Cart newCart = new Cart();
        Purchases newPurchases = new Purchases();

        this.cartRepo.save(newCart);
        this.purchasesRepository.save(newPurchases);
        newAccount.setCartId(newCart.getId());
        newAccount.setPurchasesId(newPurchases.getId());

        this.repo.save(newAccount);
        return newAccount;
    }

    public Account updateAccount(Account request) {
        this.repo.save(request);
        return request;
    }

    public Iterable<Account> deleteAccount(Long id) {
        this.repo.deleteById(id);
        return this.repo.findAll();
    }

    public Account setNewAccountCart(Long id){
        Optional<Account> account = this.repo.findById(id);
        Cart newCart = new Cart();
        this.cartRepo.save(newCart);
        account.orElseThrow().setCartId(newCart.getId());
        this.repo.save(account.orElseThrow());
        return account.orElseThrow();
    }
}
