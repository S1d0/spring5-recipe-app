package si.recipe.recipeApp.repositories;

import org.springframework.data.repository.CrudRepository;
import si.recipe.recipeApp.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
