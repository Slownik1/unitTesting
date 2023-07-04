import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

class AccountServiceStubTest {

    @Test
    void getAllActiveAccounts() {

        //GIVEN
        AccountRepository accountRepositoryStub = new AccountRepositoryStub();
        AccountService accountService = new AccountService(accountRepositoryStub);

        //WHEN
        List<Account> accountList = accountService.getAllActiveAccounts();

        //THEN
        assertThat(accountList, hasSize(2));

    }
}