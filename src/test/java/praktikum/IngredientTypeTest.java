package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testValueOfSauce() {
        assertEquals("SAUCE",IngredientType.valueOf("SAUCE").name());
    }

    @Test
    public void testValueOfFilling() {
        assertEquals("FILLING",IngredientType.valueOf("FILLING").name());
    }
}