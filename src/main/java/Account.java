public abstract class Account {
    protected long numberOfAccount;
    protected long balance;


    public Account(long numberOfAccount) {
        this.numberOfAccount = numberOfAccount;
    }

    public long getNumberOfAccount() {
        return numberOfAccount;
    }

    public long getBalance() {
        return balance;
    }

    public abstract boolean add(long amount);

    public abstract boolean pay(long amount);

    public boolean transfer(Account account, long amount) {

        if (pay(amount)) {
            if (account.add(amount)) {
                return true;
            }
            add(amount);
        }
        return false;
    }
}


