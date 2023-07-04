import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Test
    void getAllActiveAccounts() {

        //GIVEN
        List<Account> accounts = prepareAccountData();
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);
        when(accountRepository.getAllAcount()).thenReturn(accounts);

        //WHEN
        List<Account> accountList = accountService.getAllActiveAccounts();

        //THEN
        assertThat(accountList, hasSize(2));

    }

    private List<Account> prepareAccountData(){
        Account account1 = new Account(new Adress("Warszawa", "22"));
        Account account2 = new Account(new Adress("Katowice", "12b"));
        Account account3 = new Account();

        return Arrays.asList(account1, account2, account3);
    }

}