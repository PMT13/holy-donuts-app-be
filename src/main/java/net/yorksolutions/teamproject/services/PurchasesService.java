package net.yorksolutions.teamproject.services;
import net.yorksolutions.teamproject.models.Purchases;
import net.yorksolutions.teamproject.repositories.PurchasesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchasesService {
    PurchasesRepository purchasesRepository;

    public PurchasesService(PurchasesRepository purchasesRepository) {
        this.purchasesRepository = purchasesRepository;
    }

    public Purchases updatePurchases(Purchases purchase) {
        this.purchasesRepository.save(purchase);
        return purchase;
    }

    public Purchases getPurchaseById(Long purchaseId) {
        Optional<Purchases> purchase = this.purchasesRepository.findById(purchaseId);
        return purchase.orElse(null);
    }
}
