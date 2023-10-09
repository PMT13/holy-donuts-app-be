package net.yorksolutions.teamproject.repositories;

import net.yorksolutions.teamproject.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
