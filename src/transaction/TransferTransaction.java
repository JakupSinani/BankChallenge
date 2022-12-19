package transaction;

public class TransferTransaction extends Transaction {
    public TransferTransaction(double amount, Integer fromAccountId, Integer toAccountId, String reason, double transactionFee) {
        super(amount, fromAccountId, toAccountId, reason, transactionFee);
    }

    @Override
    public String getType() {
        return "Transfer";
    }
}