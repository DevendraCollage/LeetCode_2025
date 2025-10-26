class Bank {
    private long[] balance;
    private int n;

    public Bank(long[] balance) {
        this.balance = balance;
        this.n = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (isValidAccount(account1) && isValidAccount(account2)) {
            if (balance[account1 - 1] >= money) {
                balance[account1 - 1] -= money;
                balance[account2 - 1] += money;
                return true;
            }
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (isValidAccount(account)) {
            balance[account - 1] += money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if (isValidAccount(account)) {
            if (balance[account - 1] >= money) {
                balance[account - 1] -= money;
                return true;
            }
        }
        return false;
    }

    private boolean isValidAccount(int account) {
        return account >= 1 && account <= n;
    }
}