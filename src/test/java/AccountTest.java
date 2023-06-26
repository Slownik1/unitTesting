import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void testIsAccountActiveA(){
        //GIVEN+WHEN
        Account testAccount =new Account();
        //THEN
        assertFalse(testAccount.isActive());
    }

    @Test
    public void testIsAcountAcctiveAfterActivation(){

        //GIVEN
        Account testAccount = new Account();
        //WHEN
        testAccount.activate();
        //THEN
        assertTrue(testAccount.isActive());

    }

}
