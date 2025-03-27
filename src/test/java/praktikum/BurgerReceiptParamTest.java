package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerReceiptParamTest {

    private final String bunName;
    private final float bunPrice;
    private final String ingredientName;
    private final float ingredientPrice;
    private final int ingredientAmount;
    private final IngredientType ingredientType;
    private final String expectedReceipt;
    private Burger burger;
    private Bun mockBun;
    private Ingredient mockIngredient;

    public BurgerReceiptParamTest(String bunName, float bunPrice, String ingredientName, float ingredientPrice,
                                  int ingredientAmount, IngredientType ingredientType, String expectedReceipt) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.ingredientAmount = ingredientAmount;
        this.ingredientType = ingredientType;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameterized.Parameters(name = "Чек с {0} и {4} {2}")
    public static Object[][] getReceiptData() {
        return new Object[][]{
                {"red bun", 300.00f, "ingredient", 200.00f, 1, IngredientType.FILLING, "(==== red bun ====)\r\n" +
                                                                                       "= filling ingredient =\r\n" +
                                                                                       "(==== red bun ====)\r\n" +
                                                                                       "\r\nPrice: 800,000000\r\n"},

                {"white bun", 200.00f, "ingredient", 100.00f, 3, IngredientType.SAUCE, "(==== white bun ====)\r\n" +
                                                                                       "= sauce ingredient =\r\n" +
                                                                                       "= sauce ingredient =\r\n" +
                                                                                       "= sauce ingredient =\r\n" +
                                                                                       "(==== white bun ====)\r\n" +
                                                                                       "\r\nPrice: 700,000000\r\n"},

                {"black bun", 100.00f, "ingredient", 300.00f, 5, IngredientType.FILLING, "(==== black bun ====)\r\n" +
                                                                                         "= filling ingredient =\r\n" +
                                                                                         "= filling ingredient =\r\n" +
                                                                                         "= filling ingredient =\r\n" +
                                                                                         "= filling ingredient =\r\n" +
                                                                                         "= filling ingredient =\r\n" +
                                                                                         "(==== black bun ====)\r\n" +
                                                                                         "\r\nPrice: 1700,000000\r\n"}
        };
    }

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = Mockito.mock(Bun.class);
        mockIngredient = Mockito.mock(Ingredient.class);
        when(mockBun.getName()).thenReturn(bunName);
        when(mockBun.getPrice()).thenReturn(bunPrice);
        when(mockIngredient.getName()).thenReturn(ingredientName);
        when(mockIngredient.getPrice()).thenReturn(ingredientPrice);
        when(mockIngredient.getType()).thenReturn(ingredientType);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(mockBun);
        for(int i = 0; i < ingredientAmount; i++){
            burger.addIngredient(mockIngredient);
        }
        String actualReceipt = burger. getReceipt();
        assertEquals(String.format("Чек неправильно сформирован.\n Ожидалось:\n%S\n Получено:\n%S", expectedReceipt,
                actualReceipt),expectedReceipt, actualReceipt);
    }

}
