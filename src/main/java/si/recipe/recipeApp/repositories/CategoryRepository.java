package si.recipe.recipeApp.repositories;

import org.springframework.data.repository.CrudRepository;
import si.recipe.recipeApp.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
