package si.recipe.recipeApp.repositories;

import org.springframework.data.repository.CrudRepository;
import si.recipe.recipeApp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
