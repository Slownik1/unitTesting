import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

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

    @TestFactory
    Collection<DynamicTest> dynamicTestCollection(){

        return Arrays.asList(
                dynamicTest("Test 1", ()->assertThat(5, lessThan(6))),
                dynamicTest("test 2", ()->assertEquals(4,2*2)));
    }

    @Tag("Test")
    @TestFactory
    Collection<DynamicTest> calculateMealPricec(){
        Order order = new Order();
        order.addNewMealToOrder(new Meal(22, "Soup", 2));
        order.addNewMealToOrder(new Meal(35, "Spagetti", 1));
        order.addNewMealToOrder(new Meal(8, "Water", 5));

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for(int i=0; i<order.getMeals().size(); i++){

            int price = order.getMeals().get(i).getPrice();
            int qty = order.getMeals().get(i).getQty();

            Executable executable=()->{
                assertThat(calculatePrice(price, qty), lessThan(67));
            };

            String name = "Test:" + i;
            DynamicTest dynamicTest = DynamicTest.dynamicTest(name, executable);
            dynamicTests.add(dynamicTest);

        }
        return dynamicTests;
    }

    private int calculatePrice(int price, int quantity){
        return price*quantity;
    }

}