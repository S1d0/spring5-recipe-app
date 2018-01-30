package si.recipe.recipeApp.repositories;

import org.springframework.data.repository.CrudRepository;
import si.recipe.recipeApp.domain.Simple;

public interface SimpleRepository extends CrudRepository<Simple, Long> {
}
