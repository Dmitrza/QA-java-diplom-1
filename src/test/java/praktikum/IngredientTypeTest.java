package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameter
    public IngredientType type;
    @Parameterized.Parameter(1)
    public String expectedResult;

    @Parameterized.Parameters
public static Object[][] data() {
        return new Object[][] {
                {SAUCE, "SAUCE"},
                {FILLING, "FILLING"}
        };
    }

    @Test
    public void typeTest() {
        assertEquals(expectedResult, type.name());
    }

}
