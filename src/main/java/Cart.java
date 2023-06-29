import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    void addToCard(Order order){
        this.orders.add(order);
    }

    void clearCart(){
        this.orders.clear();
    }

    void simulateLargeOrder(){

        for(int i=0; i<1000; i++){
            Meal meal = new Meal(i%10, "Food nr:" + 1);
            Order order = new Order();
            order.addNewMealToOrder(meal);
            addToCard(order);
        }
        clearCart();

    }

}
