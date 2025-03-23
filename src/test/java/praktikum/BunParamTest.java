package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunParamTest {

    private final String bunName;
    private final float bunPrice;
    private Bun bun;

    public BunParamTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name = "Название булки: {0}; Стоимость булки: {1};")
    public static Object[][] getPriceData() {
        return new Object[][]{
                {"Красная булка", 100.00f },
                {"Black bun", 200 },
                {"Галактика-15", 300.25f}
        };
    }

    @Before
    public void setUp(){
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void testGetName() {
       assertEquals(bunName, bun.getName());
    }

    @Test
    public void testGetPrice() {
       assertEquals(bunPrice, bun.getPrice(),0.01f);
    }

}