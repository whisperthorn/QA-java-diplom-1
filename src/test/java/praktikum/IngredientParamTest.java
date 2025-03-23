package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientParamTest {

    private final String ingredientName;
    private final float ingredientPrice;
    private Ingredient ingredient;

    public IngredientParamTest(String ingredientName, float ingredientPrice) {
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters(name = "Название ингредиента: {0}; Цена ингредиента: {1};")
    public static Object[][] getPriceData() {
        return new Object[][]{
                {"cutlet", 100.32f},
                {"КЕТЧОНЕЗ", 200},
                {"Огурец", 300.00f}
        };
    }

    @Mock
    private IngredientType mockType;

    @Before
    public void setUp() {
        ingredient = new Ingredient(mockType,ingredientName, ingredientPrice);
    }

    @Test
    public void testGetPrice() {
        assertEquals("Стоимость должна совпадать",ingredientPrice, ingredient.getPrice(), 0.01f);
    }

    @Test
    public void testGetName() {
        assertEquals("Имя должно совпадать", ingredientName, ingredient.getName());
    }

    @Test
    public void testGetType() {
        assertEquals("Тип должен совпадать", mockType,ingredient.getType());
    }

}