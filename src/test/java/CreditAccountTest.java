
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.object.IsCompatibleType.typeCompatibleWith;
import static org.junit.jupiter.api.Assertions.*;

class CreditAccountTest {
    CreditAccount creditAccount;

    @BeforeEach
    public void setUp() {
        creditAccount = new CreditAccount(123456, -100000);
    }

    @AfterEach
    public void tearDown() {
        creditAccount = null;
    }

    @Test
    public void given2Classes_whenOneInheritsFromOther_thenCorrect() {
        assertThat(CreditAccount.class, typeCompatibleWith(Account.class));
    }

    @Test
    public void givenSubclass_whenChecked_thenTrue() {
        assertThat(creditAccount, isA(Account.class));
    }

    @Test
    void testAddExceedLimitCredit() {
        long amount = 500000, expected = 0;

        creditAccount.add(amount);
        long balance = creditAccount.getBalance();

        assertEquals(expected, balance);
    }

    @Test
    void testAddExceedLimitCreditHamcrest() {
        long amount = 500000, expected = 0;

        creditAccount.add(amount);
        long balance = creditAccount.getBalance();

        assertThat(balance, equalTo(expected));
    }

    @Test
    void testPayExceedLimitCredit() {
        long amount = 120000, expected = 0;

        creditAccount.pay(amount);
        long balance = creditAccount.getBalance();

        assertEquals(expected, balance);
    }

    @Test
    void testPayExceedLimitCreditHamcrest() {
        long amount = 120000, expected = 0;

        creditAccount.pay(amount);
        long balance = creditAccount.getBalance();

        assertThat(balance, equalTo(expected));
    }

    @Test
    public void testTransferExceedLimitCredit() {
        long amount = 110000, expected = 0;

        creditAccount.transfer(new SimpleAccount(12346), amount);
        long balance = creditAccount.getBalance();

        assertEquals(expected, balance);
    }

    @Test
    public void testTransferExceedLimitCreditHamcrest() {
        long amount = 110000, expected = 0;

        creditAccount.transfer(new SimpleAccount(12346), amount);
        long balance = creditAccount.getBalance();

        assertThat(balance, equalTo(expected));
    }
}