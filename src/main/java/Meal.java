import java.util.Objects;

public class Meal {

    private int price;
    private String name;
    private int qty;

    @Override
    public String toString() {
        return "Meal{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return price == meal.price && Objects.equals(name, meal.name);
    }

    public Meal(int price, String name, int qty) {
        this.price = price;
        this.name = name;
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    public Meal(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Meal(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountedPrice(int discount){

        if(discount > this.price) {
            throw new IllegalArgumentException("Discount can not be greater than price");
        }

        return price - discount;
    }



}
