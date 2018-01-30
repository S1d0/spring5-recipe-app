package si.recipe.recipeApp.repositories;

import org.springframework.data.repository.CrudRepository;
import si.recipe.recipeApp.domain.UnitOfMeasure;

import java.util.Optional;

public interface UomRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByUom(String uom);
}
