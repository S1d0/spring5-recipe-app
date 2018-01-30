package si.recipe.recipeApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import si.recipe.recipeApp.domain.Recipe;
import si.recipe.recipeApp.repositories.RecipeRepository;
import si.recipe.recipeApp.services.RecipeService;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final RecipeService recipeService;

    @Autowired
    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","home"})
    public String home(Model model) {
        model.addAttribute("recipes", recipeService.getAll());
        return "index";
    }

}
