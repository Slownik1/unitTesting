import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testAssertArrayEquals(){

        //GIVEN
        int[] testInt1 = {1,2,3};
        int[] testInt2 = {1,2,3};
        //THEN
        assertArrayEquals(testInt1, testInt2);
    }

    @Test
    void mealListShouldBeEmptyAfterCreation(){

        //GIVEN
        Order testOrder = new Order();

        //THEN
        assertThat(testOrder.getMeals(), empty());
        assertThat(testOrder.getMeals().size(), equalTo(0));
        assertThat(testOrder.getMeals(), hasSize(0));
        assertThat(testOrder.getMeals(), emptyCollectionOf(Meal.class));
    }
    @Test
    void addingMealToOrderShouldIncreseOrderSize() {

        //GIVEN
        Order testOrder = new Order();
        Meal testMeal = new Meal(23, "Pizza");

        //WHEN
        testOrder.addNewMealToOrder(testMeal);

        //THEN
        assertThat(testOrder.getMeals().size(), equalTo(1));
        assertThat(testOrder.getMeals(), hasSize(1));
        assertThat(testOrder.getMeals(), contains(testMeal));
        assertThat(testOrder.getMeals(), hasItem(testMeal));

    }

    @Test
    void removingMealToOrderShouldDecreseOrderSize() {

        //GIVEN
        Order testOrder = new Order();
        Meal testMeal = new Meal(23, "Pizza");

        //WHEN
        testOrder.addNewMealToOrder(testMeal);
        testOrder.removeMealFromOrder(testMeal);


        //THEN
        assertThat(testOrder.getMeals().size(), equalTo(0));
        assertThat(testOrder.getMeals(), not(contains(testMeal)));
    }

    @Test
    void mealShouldBeInCorrectOrderAfterAdding() {

        //GIVEN
        Order testOrder = new Order();
        Meal testMeal1 = new Meal(23, "Pizza");
        Meal testMeal2 = new Meal(3, "Cola");

        //WHEN
        testOrder.addNewMealToOrder(testMeal1);
        testOrder.addNewMealToOrder(testMeal2);

        //THEN
        assertThat(testOrder.getMeals(), contains(testMeal1, testMeal2));
        assertThat(testOrder.getMeals(), containsInAnyOrder(testMeal1, testMeal2));

    }

    @Test
    void twoListMealsShouldBeInTheSameOrders() {

        //GIVEN
        Meal testMeal1 = new Meal(23, "Pizza");
        Meal testMeal2 = new Meal(3, "Cola");
        Meal testMeal3 = new Meal(3, "Pepsi");

        List<Meal> testList1 = Arrays.asList(testMeal1, testMeal2, testMeal3);
        List<Meal> testList2 = Arrays.asList(testMeal1, testMeal2, testMeal3);

        //THEN
        assertThat(testList1, is(testList2));

    }
}