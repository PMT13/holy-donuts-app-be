package net.yorksolutions.teamproject.controllers;

import net.yorksolutions.teamproject.dto.NewProductRequestDTO;
import net.yorksolutions.teamproject.dto.UpdateProductRequestDTO;
import net.yorksolutions.teamproject.models.Product;
import net.yorksolutions.teamproject.services.CategoryService;
import net.yorksolutions.teamproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    public ProductController(){//ProductService productService){
       // this.productService = productService;
    }

    @PostMapping
    public Product create(@RequestBody NewProductRequestDTO requestDTO){
        return this.productService.create(requestDTO);
    }

    @GetMapping
    Iterable<Product> get() {
        return this.productService.getAllProducts();
    }
    //
    @DeleteMapping("/{productId}")
    public void delete(@PathVariable Long productId){
        this.productService.delete(productId);
    }

    @PutMapping
    public Product update(@RequestBody UpdateProductRequestDTO requestDTO){
        return this.productService.update(requestDTO);
    }

}
