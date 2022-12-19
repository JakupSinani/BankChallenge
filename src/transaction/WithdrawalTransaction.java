package transaction;

public class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction(double amount, Integer fromAccountId, Integer toAccountId, String reason, double transactionFee) {
        super(amount, fromAccountId, toAccountId, reason, transactionFee);
    }

    @Override
    public String getType() {
        return "Withdrawal";
    }
}