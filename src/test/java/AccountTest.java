import org.junit.jupiter.api.Test;
import org.hamcrest.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class AccountTest {

    @Test
    void testIsAccountActive(){
        //GIVEN+WHEN
        Account testAccount =new Account();
        //THEN
        assertFalse(testAccount.isActive());
        assertThat(testAccount.isActive(), equalTo(false));
    }

    @Test
    void testIsAcountAcctiveAfterActivation(){

        //GIVEN
        Account testAccount = new Account();
        //WHEN
        testAccount.activate();
        //THEN
        assertTrue(testAccount.isActive());

    }

    @Test
    void newAccountShouldNotHaveAdressSet(){

        //GIVEN
        Account testAccount = new Account();
        //WHEN
        Adress adress = testAccount.getDefaulAdress();
        //THEN
        assertNull(adress);
    }

    @Test
    void defaultAdressShouldNotBeNullAfterSingingOut(){

        //GIVEN
        Adress testAdress = new Adress("Gdansk", "34");
        Account testAcount = new Account();
        testAcount.setDefaulAdress(testAdress);
        //THEN
        assertNotNull(testAcount.getDefaulAdress());

    }

}
