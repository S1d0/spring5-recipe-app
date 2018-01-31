package si.recipe.recipeApp.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import si.recipe.recipeApp.domain.UnitOfMeasure;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UomRepositoryTestIT {

    @Autowired
    UomRepository uomRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByUom() {
        Optional<UnitOfMeasure> uomOptional = uomRepository.findByUom("Teaspoon");
        assertEquals("Teaspoon", uomOptional.get().getUom());
    }
}