package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sausage", 200.0F);
        assertEquals(200.0F, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "sausage", 150.0F);
        assertEquals("sausage", ingredient.getName());
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sausage", 5345.0F);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

}
