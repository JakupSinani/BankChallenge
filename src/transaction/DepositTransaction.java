package transaction;

public class DepositTransaction extends Transaction {
    public DepositTransaction(double amount, Integer fromAccountId, Integer toAccountId, String reason, double transactionFee) {
        super(amount, fromAccountId, toAccountId, reason, transactionFee);
    }

    @Override
    public String getType() {
        return "Deposit";
    }
}