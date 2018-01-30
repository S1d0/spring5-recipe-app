package si.recipe.recipeApp.bootsrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import si.recipe.recipeApp.domain.*;
import si.recipe.recipeApp.domain.enums.Difficulty;
import si.recipe.recipeApp.repositories.CategoryRepository;
import si.recipe.recipeApp.repositories.RecipeRepository;
import si.recipe.recipeApp.repositories.SimpleRepository;
import si.recipe.recipeApp.repositories.UomRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UomRepository uomRepository;

    @Autowired
    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UomRepository uomRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.uomRepository = uomRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        Simple simple = new Simple("AGH");
        List<Recipe> recipes = getRecipes();
        recipeRepository.save(recipes);
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        UnitOfMeasure eachUom = getUom("Each");
        UnitOfMeasure tableSpoonUom = getUom("Tablespoon");

        Category americanCategory = getCategory("American");
        Category mexicanCategory = getCategory("Mexican");

        Recipe guacamoleRecipe = new Recipe();


        guacamoleRecipe.getCategories().add(americanCategory);
        guacamoleRecipe.setCookTime(0);
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setDescription("Perfect Guacamole");
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
//        guacamoleRecipe.getIngredients().add(new Ingredient("Avocado", new BigDecimal(2), guacamoleRecipe, eachUom));
//        guacamoleRecipe.getIngredients().add(new Ingredient("Lime juice", new BigDecimal(.5), guacamoleRecipe, tableSpoonUom));

        guacamoleRecipe.addIngredients(new Ingredient("Lime juice", new BigDecimal(.5), tableSpoonUom));
        guacamoleRecipe.addIngredients(new Ingredient("Avocado", new BigDecimal(2), eachUom));

        guacNotes.setRecipe(guacamoleRecipe);
        guacamoleRecipe.setNotes(guacNotes);


        recipes.add(guacamoleRecipe);


        Recipe taco = new Recipe();

        taco.setDescription("Spicy Grilled Chicken Taco");
        taco.setPrepTime(20);
        taco.setCookTime(9);
        taco.setDifficulty(Difficulty.MODERATE);

        taco.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");
        tacoNotes.setRecipe(taco);
        taco.setNotes(tacoNotes);

        taco.getCategories().add(mexicanCategory);
        taco.getCategories().add(americanCategory);

//        taco.getIngredients().add(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), taco, eachUom));
//        taco.getIngredients().add(new Ingredient("Medium ripe avocados", new BigDecimal(2), taco, eachUom));
//        taco.getIngredients().add(new Ingredient("Radishes, thinly sliced", new BigDecimal(4), taco, eachUom));
//        taco.getIngredients().add(new Ingredient("finely grated orange zestr", new BigDecimal(1), taco, tableSpoonUom));
//        taco.getIngredients().add(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), taco, tableSpoonUom));

        taco.addIngredients(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), eachUom));
        taco.addIngredients(new Ingredient("Medium ripe avocados", new BigDecimal(2), eachUom));
        taco.addIngredients(new Ingredient("finely grated orange zestr", new BigDecimal(1), tableSpoonUom));
        taco.addIngredients(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tableSpoonUom));

        recipes.add(taco);
        return recipes;
    }

    private UnitOfMeasure getUom(String uom) {
        Optional<UnitOfMeasure> unitOfMeasure = uomRepository.findByUom(uom);
        if (!unitOfMeasure.isPresent()) {
            throw new RuntimeException("Expected " + uom + " Not Found");
        }
        return unitOfMeasure.get();
    }

    private Category getCategory(String description) {
        Optional<Category> categoryOptional = categoryRepository.findByDescription(description);
        if (!categoryOptional.isPresent()) {
            throw new RuntimeException("Expected category with description " + description + " Not found");
        }
        return categoryOptional.get();
    }
}
