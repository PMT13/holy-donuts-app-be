package net.yorksolutions.teamproject.controllers;

import net.yorksolutions.teamproject.dto.AddAccountDTO;
import net.yorksolutions.teamproject.models.Account;
import net.yorksolutions.teamproject.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/account")
@CrossOrigin
public class AccountController {
    AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Account> getAccounts(){
        return this.service.getAccounts();
    }

    @GetMapping("/{id}")
    public Optional<Account> getAccountById(@PathVariable Long id){
        return this.service.getAccountById(id);
    }

    @PostMapping
    public Account createAccount(@RequestBody AddAccountDTO request){
        return this.service.create(request);
    }

    @PutMapping
    public Account updateAccount(@RequestBody Account request){
        return this.service.updateAccount(request);
    }

    @DeleteMapping("/{id}")
    public Iterable<Account> deleteAccount(@PathVariable long id){
        return this.service.deleteAccount(id);
    }
}
