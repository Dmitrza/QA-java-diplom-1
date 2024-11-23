package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BunTest {

    public static Database database = new Database();

    @Parameterized.Parameter
    public String bunName;

    @Parameterized.Parameter(1)
    public float bunPrice;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {database.availableBuns().get(0).getName(), database.availableBuns().get(0).getPrice()},
                {database.availableBuns().get(1).getName(), database.availableBuns().get(1).getPrice()},
                {database.availableBuns().get(2).getName(), database.availableBuns().get(2).getPrice()}
        };
    }

    @Test
    public void getName() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        assertThat(bun.getPrice(), is(bunPrice));
    }

}
