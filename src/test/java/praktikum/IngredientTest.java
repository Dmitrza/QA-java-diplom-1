package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    public static Database database = new Database();

    @Parameterized.Parameter
    public IngredientType ingredientType;

    @Parameterized.Parameter(1)
    public String ingredientName;

    @Parameterized.Parameter(2)
    public float ingredientPrice;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {database.availableIngredients().get(0).getType(), database.availableIngredients().get(0).getName(), database.availableIngredients().get(0).getPrice()},
                {database.availableIngredients().get(1).getType(), database.availableIngredients().get(1).getName(), database.availableIngredients().get(1).getPrice()},
                {database.availableIngredients().get(2).getType(), database.availableIngredients().get(2).getName(), database.availableIngredients().get(2).getPrice()},
                {database.availableIngredients().get(3).getType(), database.availableIngredients().get(3).getName(), database.availableIngredients().get(3).getPrice()},
                {database.availableIngredients().get(4).getType(), database.availableIngredients().get(4).getName(), database.availableIngredients().get(4).getPrice()},
                {database.availableIngredients().get(5).getType(), database.availableIngredients().get(5).getName(), database.availableIngredients().get(5).getPrice()}
        };
    }

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals(ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals(ingredientType, ingredient.getType());
    }

}
