import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Meal> meals = new ArrayList<>();

    public void addNewMealToOrder(Meal meal){
        this.meals.add(meal);
    }

    public void removeMealFromOrder(Meal meal){
        this.meals.remove(meal);
    }

    public List<Meal> getMeals() {
        return meals;
    }

    void cancle(){
        this.meals.clear();
    }

}
