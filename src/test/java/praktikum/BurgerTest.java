package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertEquals("Значения должны совпадать", mockBun, burger.bun);
    }

    @Test
    public void testAddIngredientAmount() {
        burger.addIngredient(mockIngredient1);
        assertEquals("Количество ингредиентов должно совпадать", 1, burger.ingredients.size());
    }

    @Test
    public void testAddIngredientType() {
        burger.addIngredient(mockIngredient1);
        assertSame("Ингридиент должен совпадать", mockIngredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredientAmount() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);
        assertEquals("Количество ингредиентов должно совпадать", 1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredientType() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);
        assertSame("Ингридиент должен совпадать", mockIngredient2,burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(1,0);
        assertSame("Ингридиент должен совпадать", mockIngredient2,burger.ingredients.get(0));
    }

}