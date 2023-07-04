import java.util.Arrays;
import java.util.List;

public class AccountRepositoryStub implements AccountRepository {

    @Override
    public List<Account> getAllAcount() {

        Account account1 = new Account(new Adress("Warszawa", "22"));
        Account account2 = new Account(new Adress("Katowice", "12b"));
        Account account3 = new Account();

        return Arrays.asList(account1, account2, account3);

    }
}
