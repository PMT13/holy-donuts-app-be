package net.yorksolutions.teamproject.repositories;

import net.yorksolutions.teamproject.models.Cart;
import net.yorksolutions.teamproject.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends CrudRepository<Cart, Long> {

}