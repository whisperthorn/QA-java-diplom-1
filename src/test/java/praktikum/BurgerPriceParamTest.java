package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerPriceParamTest {
    private final float bunPrice;
    private final float ingredientPrice;
    private final int ingredientAmount;
    private final float expectedPrice;
    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient;

    public BurgerPriceParamTest(float bunPrice, float ingredientPrice, int ingredientAmount, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.ingredientAmount = ingredientAmount;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Цена булки: {0}; Цена ингредиента: {1}; Количество ингредиентов: {2};" +
            " Ожидаемая стоимость: {3}")
    public static Object[][] getPriceData() {
        return new Object[][]{
                {100.00f, 100.17f, 1, 300.17f},
                {200.00f, 200.00f, 2, 800},
                {300.00f, 300.00f, 5, 2100.00f}
        };
    }

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient = Mockito.mock(Ingredient.class);
        when(mockBun.getPrice()).thenReturn(bunPrice);
        when(mockIngredient.getPrice()).thenReturn(ingredientPrice);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(mockBun);
        for(int i = 0; i < ingredientAmount; i++){
            burger.addIngredient(mockIngredient);
        }
        assertEquals("Общая стоимость не соответствует ожидаемой.",expectedPrice, burger.getPrice(),0.01f);
    }

}


