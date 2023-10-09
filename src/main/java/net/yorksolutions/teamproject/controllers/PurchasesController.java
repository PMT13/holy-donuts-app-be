package net.yorksolutions.teamproject.controllers;
import net.yorksolutions.teamproject.models.Purchases;
import net.yorksolutions.teamproject.services.AccountService;
import net.yorksolutions.teamproject.services.PurchasesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchases")
@CrossOrigin
public class PurchasesController {
    PurchasesService purchaseService;
    AccountService accountService;

    public PurchasesController(PurchasesService purchasesService,AccountService accountService) {
        this.purchaseService = purchasesService;
        this.accountService = accountService;
    }

    @GetMapping("/{purchasesId}")
    public Purchases getPurchaseById(@PathVariable Long purchasesId) {
        return purchaseService.getPurchaseById(purchasesId);
    }
    @PutMapping("/{accountId}")
    public Purchases updatePurchases(@PathVariable Long accountId, @RequestBody Purchases purchase) {
        accountService.setNewAccountCart(accountId);
        return purchaseService.updatePurchases(purchase);
    }
}
