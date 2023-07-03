import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

@Tag("Test")
class AdressTest {

    @ParameterizedTest
    @CsvSource({"Main, 10", "South street, 55/1", "Gold street, 100"})
    void givenAdressesShouldNotBemptyAndHaveProperNames(String street, String number){
        assertThat(street, notNullValue());
        assertThat(number, notNullValue());

    }

}