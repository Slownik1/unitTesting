import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(BeforeAfterExtension.class)
class OrderTest {

    private Order order;

    @BeforeEach
    void initializeOrder(){
        order = new Order();
    }

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
        initializeOrder();

        //THEN
        assertThat(order.getMeals(), empty());
        assertThat(order.getMeals().size(), equalTo(0));
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), emptyCollectionOf(Meal.class));
    }
    @Test
    void addingMealToOrderShouldIncreseOrderSize() {

        //GIVEN
        Order order = new Order();
        Meal testMeal = new Meal(23, "Pizza");

        //WHEN
        order.addNewMealToOrder(testMeal);

        //THEN
        assertThat(order.getMeals().size(), equalTo(1));
        assertThat(order.getMeals(), hasSize(1));
        assertThat(order.getMeals(), contains(testMeal));
        assertThat(order.getMeals(), hasItem(testMeal));

    }

    @Test
    void removingMealToOrderShouldDecreseOrderSize() {

        //GIVEN
        Order order = new Order();
        Meal testMeal = new Meal(23, "Pizza");

        //WHEN
        order.addNewMealToOrder(testMeal);
        order.removeMealFromOrder(testMeal);


        //THEN
        assertThat(order.getMeals().size(), equalTo(0));
        assertThat(order.getMeals(), not(contains(testMeal)));
    }

    @Test
    void mealShouldBeInCorrectOrderAfterAdding() {

        //GIVEN
        Order order = new Order();
        Meal testMeal1 = new Meal(23, "Pizza");
        Meal testMeal2 = new Meal(3, "Cola");

        //WHEN
        order.addNewMealToOrder(testMeal1);
        order.addNewMealToOrder(testMeal2);

        //THEN
        assertThat(order.getMeals(), contains(testMeal1, testMeal2));
        assertThat(order.getMeals(), containsInAnyOrder(testMeal1, testMeal2));

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