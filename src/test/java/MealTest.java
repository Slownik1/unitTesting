import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {

        //GIVEN
        Meal meal = new Meal(10);

        //WHEN
        int priceAfterDiscount = meal.getDiscountedPrice(5);

        //THEN
        assertEquals(5, priceAfterDiscount);

    }

    @Test
    void referanceToTheSameObjectShouldBeEqual(){

        //GIVEN
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;

        //THEN
        assertSame(meal1, meal2);

    }

    @Test
    void referanceToTheSameObjectShouldNotBeEqual(){

        //GIVEN
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(10);

        //THEN
        assertNotSame(meal1, meal2);

    }
    @Test
    void twoMealsShouldBeEqualWhenAllParametersAreTheSame(){

        //GIVEN
        Meal pizza = new Meal(10, "pizza");
        Meal pizzaTwo = new Meal(10, "pizza");

        //WHEN
        //THEN

        assertEquals(pizza, pizzaTwo);


    }
    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanPrice(){

        //GIVEN
        Meal meal = new Meal(10, "Soup");

        //THEN
        assertThrows(IllegalArgumentException.class, ()->meal.getDiscountedPrice(20));
    }
}