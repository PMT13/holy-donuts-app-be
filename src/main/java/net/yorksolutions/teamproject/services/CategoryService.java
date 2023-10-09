package net.yorksolutions.teamproject.services;

import net.yorksolutions.teamproject.dto.NewCategoryDTO;
import net.yorksolutions.teamproject.dto.NewProductRequestDTO;
import net.yorksolutions.teamproject.dto.UpdateCategoryDTO;
import net.yorksolutions.teamproject.models.Category;
import net.yorksolutions.teamproject.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(NewCategoryDTO requestDTO){
        try {
            System.out.println(requestDTO.category);
            return this.categoryRepository.save(
                    new Category(requestDTO.category)
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void delete(Long productId){
        this.categoryRepository.deleteById(productId);
    }

    public Category update(UpdateCategoryDTO requestDTO){
        Optional<Category> categoryOpt = this.categoryRepository.findById(requestDTO.id);
        if(categoryOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Category category = categoryOpt.get();
        category.setCategory(requestDTO.category);

        return this.categoryRepository.save(category);
    }
}
