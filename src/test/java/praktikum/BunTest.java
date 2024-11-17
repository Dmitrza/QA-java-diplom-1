package praktikum;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;

public class BunTest {

    @Test
    public void getName() {
        Bun bun = new Bun("black bun", 100.0F);
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun("black bun", 100.0F);
        assertThat(bun.getPrice(), is(100.0F));
    }

}
