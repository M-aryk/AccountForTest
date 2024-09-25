import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.object.IsCompatibleType.typeCompatibleWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleAccountTests {
    SimpleAccount simpleAccount;

    @BeforeEach
    public void setUp() {
        simpleAccount = new SimpleAccount(123456);
    }

    @AfterEach
    public void tearDown() {
        simpleAccount = null;
    }


    @Test
    public void given2Classes_whenOneInheritsFromOther_thenCorrect() {
        assertThat(SimpleAccount.class, typeCompatibleWith(Account.class));
    }

    @Test
    public void givenSubclass_whenChecked_thenTrue() {
        assertThat(simpleAccount, isA(Account.class));
    }

    @Test
    public void testStartBalanceSimple() {
        long expected = 0;

        long balance = simpleAccount.getBalance();

        assertEquals(expected, balance);
    }

    @Test
    public void testStartBalanceSimpleHamcrest() {
        long expected = 0;

        long balance = simpleAccount.getBalance();

        assertThat(balance, equalTo(expected));
    }

    @Test
    public void testAddSimple() {
        long amount = 5000, expected = 5000;

        simpleAccount.add(amount);
        long balance = simpleAccount.getBalance();

        assertEquals(expected, balance);
    }

    @Test
    public void testAddSimpleHamcrest() {
        long amount = 5000, expected = 5000;

        simpleAccount.add(amount);
        long balance = simpleAccount.getBalance();

        assertThat(balance, equalTo(expected));
    }

    @Test
    public void testPayExceedBalanceSimple() {
        long amount = 5000, expected = 0;

        simpleAccount.pay(amount);
        long balance = simpleAccount.getBalance();

        assertEquals(expected, balance);
    }

    @Test
    public void testPayExceedBalanceSimpleHamcrest() {
        long amount = 5000, expected = 0;

        simpleAccount.pay(amount);
        long balance = simpleAccount.getBalance();

        assertThat(balance, equalTo(expected));
    }

    @Test
    public void testTransferRefundSimple() {
        simpleAccount.add(2000);
        long amount = 1000, expected = 2000;

        simpleAccount.transfer(new CreditAccount(12346, -100000), amount);
        long balance = simpleAccount.getBalance();

        assertEquals(expected, balance);
    }

    @Test
    public void testTransferRefundSimpleHamcrest() {
        simpleAccount.add(2000);
        long amount = 1000, expected = 2000;

        simpleAccount.transfer(new CreditAccount(12346, -100000), amount);
        long balance = simpleAccount.getBalance();

        assertThat(balance, equalTo(expected));
    }
}


