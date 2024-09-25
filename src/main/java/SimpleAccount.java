public class SimpleAccount extends Account {

    public SimpleAccount(long numberOfAccount) {
        super(numberOfAccount);
    }

    @Override
    public boolean add(long amount) {
        balance += amount;
        return true;
    }

    @Override
    public boolean pay(long amount) {
        if (balance < amount) {
            return false;
        } else {
            balance -= amount;
        }
        return true;
    }
}


