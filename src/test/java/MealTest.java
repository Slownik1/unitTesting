import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 19})
    void mealPricesShouldBeLowerThan20(int price){
        assertThat(price, lessThan(20));

    }

    private static Stream<Arguments> createMealWithNameAndPrice(){
        return  Stream.of(
                Arguments.of("Hamburger", 15),
                Arguments.of("Cheeseburger", 18)
        );
    }

    @ParameterizedTest
    @MethodSource("createMealWithNameAndPrice")
    void mealShouldHaveCorectNameAndPrice(String name, int price){
        assertThat(name, containsString("burger"));
        assertThat(price, greaterThan(14));

    }

}