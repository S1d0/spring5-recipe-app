package si.recipe.recipeApp.repositories;

import org.springframework.data.repository.CrudRepository;
import si.recipe.recipeApp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
}
