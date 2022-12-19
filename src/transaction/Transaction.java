package transaction;

public abstract class Transaction {
    private double amount;
    private Integer fromAccountId;
    private Integer toAccountId;
    private String reason;
    private double transactionFee;

    public Transaction(double amount, Integer fromAccountId, Integer toAccountId, String reason, double transactionFee) {
        this.amount = amount;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.reason = reason;
        this.transactionFee = transactionFee;
    }

    public double getAmount() {
        return amount;
    }

    public Integer getFromAccountId() {
        return fromAccountId;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public String getReason() {
        return reason;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public abstract String getType();
}

