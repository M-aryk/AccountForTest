public class CreditAccount extends Account {

    private final long limitOfCreditAccount;


    public CreditAccount(long numberOfAccount, long limitOfCreditAccount) {
        super(numberOfAccount);
        this.limitOfCreditAccount = limitOfCreditAccount;
    }

    @Override
    public boolean add(long amount) {
        if ((balance + amount) > 0) {
            return false;
        } else {
            balance += amount;
        }
        return true;
    }

    @Override
    public boolean pay(long amount) {
        if (balance - amount < limitOfCreditAccount) {
            return false;
        } else {
            balance -= amount;
        }
        return true;
    }

}

