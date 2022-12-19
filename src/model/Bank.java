package model;

import exception.AccountNotFoundException;
import exception.InsufficientFundsException;
import transaction.DepositTransaction;
import transaction.Transaction;
import transaction.TransferTransaction;
import transaction.WithdrawalTransaction;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private final List<Account> accounts;
    private double totalTransactionFeeAmount;
    private double totalTransferAmount;
    private double transactionFlatFeeAmount;
    private double transactionPercentFeeValue;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTransactionFees(double flatFee, double percentFee) {
        this.transactionFlatFeeAmount = flatFee;
        this.transactionPercentFeeValue = percentFee;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void transfer(Account fromAccount, Account toAccount, double amount, String reason) throws InsufficientFundsException, AccountNotFoundException {
        if (!accounts.contains(fromAccount) || !accounts.contains(toAccount)) {
            throw new AccountNotFoundException("One or both accounts were not found in the bank.");
        }

        if (fromAccount.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds in account " + fromAccount.getId());
        }

        double transactionFee = calculateTransactionFee(amount);
        fromAccount.setBalance(fromAccount.getBalance() - transactionFee);  // subtract transaction fee from originating account
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        totalTransferAmount += amount;
        totalTransactionFeeAmount += transactionFee;
        fromAccount.addTransaction(new TransferTransaction(amount, fromAccount.getId(), toAccount.getId(), reason, transactionFee));
        toAccount.addTransaction(new TransferTransaction(amount, fromAccount.getId(), toAccount.getId(), reason, transactionFee));
    }

    public void withdraw(Account account, double amount, String reason) throws InsufficientFundsException, AccountNotFoundException {
        if (!accounts.contains(account)) {
            throw new AccountNotFoundException("The account was not found in the bank.");
        }

        if (account.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds in account " + account.getId());
        }

        double transactionFee = calculateTransactionFee(amount);
        account.setBalance(account.getBalance() - transactionFee);  // subtract transaction fee from account
        account.withdraw(amount);
        totalTransactionFeeAmount += transactionFee;
        account.addTransaction(new WithdrawalTransaction(amount, account.getId(), null, reason, transactionFee));
    }

    public void deposit(Account account, double amount, String reason) throws AccountNotFoundException {
        if (!accounts.contains(account)) {
            throw new AccountNotFoundException("The account was not found in the bank.");
        }

        double transactionFee = calculateTransactionFee(amount);
        account.setBalance(account.getBalance() - transactionFee);  // subtract transaction fee from account
        account.deposit(amount);
        totalTransactionFeeAmount += transactionFee;
        account.addTransaction(new DepositTransaction(amount, account.getId(), null, reason, transactionFee));
    }

    public List<Transaction> getTransactions(Account account) {
        return account.getTransactions();
    }

    public double getBalance(Account account) {
        return account.getBalance();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public double getTotalTransactionFeeAmount() {
        return totalTransactionFeeAmount;
    }

    public double getTotalTransferAmount() {
        return totalTransferAmount;
    }

    private double calculateTransactionFee(double amount) {
        return transactionFlatFeeAmount + (amount * transactionPercentFeeValue / 100);
    }
}

