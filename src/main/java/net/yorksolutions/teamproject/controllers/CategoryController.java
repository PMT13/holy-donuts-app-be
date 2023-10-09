package net.yorksolutions.teamproject.controllers;

import net.yorksolutions.teamproject.dto.NewCategoryDTO;
import net.yorksolutions.teamproject.dto.NewProductRequestDTO;
import net.yorksolutions.teamproject.dto.UpdateCategoryDTO;
import net.yorksolutions.teamproject.dto.UpdateProductRequestDTO;
import net.yorksolutions.teamproject.models.Category;
import net.yorksolutions.teamproject.models.Product;
import net.yorksolutions.teamproject.services.CategoryService;
import net.yorksolutions.teamproject.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryController {


    CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping ( produces = "application/json")
    public Category create(@RequestBody NewCategoryDTO requestDTO){
        return this.categoryService.create(requestDTO);
    }

    @GetMapping
    Iterable<Category> get() {
        return this.categoryService.getAllCategories();
    }
    //
    @DeleteMapping("/{categoryId}")
    public void delete(@PathVariable Long categoryId){
        this.categoryService.delete(categoryId);
    }

    @PutMapping
    public Category update(@RequestBody UpdateCategoryDTO requestDTO){
        return this.categoryService.update(requestDTO);
    }

}
