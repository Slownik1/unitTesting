import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setup() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }

    @Tag("Test")
    @Test
    void backupOrderWithOneMeal() throws IOException {

        //GIVER
        Meal meal = new Meal(7, "Chips");
        Order order = new Order();
        order.addNewMealToOrder(meal);

        //WHEN
        orderBackup.backupOrder(order);

        //THEN
        System.out.println(order.toString());

    }

}