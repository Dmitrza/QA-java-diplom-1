package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient ingredient2;

    @Before
        public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
    }

    @Test
    public void addIngredients() {
        burger.addIngredient(ingredient);
        assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredients() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        System.out.println(burger.ingredients);
        burger.moveIngredient(0,1);
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getPrice()).thenReturn(100.0F);
        Mockito.when(ingredient.getPrice()).thenReturn(250.0F);
        Mockito.when(ingredient2.getPrice()).thenReturn(150.0F);
        float actualResult = burger.getPrice();
        assertThat(actualResult, is(600.0F));
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("sausage");
        Mockito.when(bun.getPrice()).thenReturn(100.0F);
        Mockito.when(ingredient.getPrice()).thenReturn(250.0F);
        Mockito.when(ingredient2.getPrice()).thenReturn(150.0F);
        String actualResult = burger.getReceipt();
        String expectedResult = String.format(
                "(==== black bun ====)" +
                "%n" +
                "= sauce hot sauce =" +
                "%n" +
                "= filling sausage =" +
                "%n" +
                "(==== black bun ====)" +
                "%n" +
                "%n" +
                "Price: 600,000000" +
                "%n");
        assertEquals(expectedResult, actualResult);
    }

}
