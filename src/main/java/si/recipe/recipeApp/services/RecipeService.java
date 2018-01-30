package si.recipe.recipeApp.services;

import si.recipe.recipeApp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getAll();
}
