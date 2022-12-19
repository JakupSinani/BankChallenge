import exception.AccountNotFoundException;
import exception.InsufficientFundsException;
import model.Account;
import model.Bank;
import transaction.Transaction;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        Bank bank1 = new Bank("STB");
        bank1.setTransactionFees(10, 5);

        Account account1 = new Account(1, "John Doe", 1000);
        Account account2 = new Account(2, "Jane Smith", 500);
        Account account3 = new Account(3, "Bob Johnson", 2000);
        Account account4 = new Account(4, "Alice Williams", 1500);

        bank1.addAccount(account1);
        bank1.addAccount(account2);
        bank1.addAccount(account3);
        bank1.addAccount(account4);

        try {
            bank1.transfer(account1, account2, 100, "Gift");
            bank1.transfer(account3, account4, 250, "Loan");
            bank1.transfer(account2, account1, 50, "Refund");
            bank1.withdraw(account3, 200, "Shopping");
            bank1.withdraw(account4, 100, "Emergency");
            bank1.deposit(account1, 300, "Salary");
            bank1.deposit(account2, 200, "Bonus");
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Bank bank2 = new Bank("NLB");
        bank2.setTransactionFees(15, 10);

        Account account5 = new Account(5, "Mike Thompson", 2500);
        Account account6 = new Account(6, "Sara Anderson", 2000);
        Account account7 = new Account(7, "Jason Brown", 1000);
        Account account8 = new Account(8, "Emily Davis", 500);

        bank2.addAccount(account5);
        bank2.addAccount(account6);
        bank2.addAccount(account7);
        bank2.addAccount(account8);

        try {
            bank2.transfer(account5, account6, 150, "Gift");
            bank2.transfer(account7, account8, 300, "Loan");
            bank2.transfer(account6, account5, 75, "Refund");
            bank2.withdraw(account7, 250, "Shopping");
            bank2.withdraw(account8, 125, "Emergency");
            bank2.deposit(account5, 350, "Salary");
            bank2.deposit(account6, 250, "Bonus");
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }

        List<Bank> banks = List.of(bank1, bank2);
        for (Bank bank : banks) {
            System.out.println("Transactions for bank " + bank.getName() + ":");
            for (Account account : bank.getAccounts()) {
                List<Transaction> transactions = bank.getTransactions(account);
                System.out.println("Transactions for account " + account.getName() + ":");
                for (Transaction transaction : transactions) {
                    System.out.println(transaction.getType() + ": $" + transaction.getAmount() + " (Fee: $" + transaction.getTransactionFee() + ")"+ " Reason: "+transaction.getReason());
                }

                double balance = bank.getBalance(account);
                System.out.println("Balance for account " + account.getId() + ": $" + balance);
                System.out.println();
            }

            List<Account> bankAccounts = bank.getAccounts();
            System.out.println("Accounts in bank " + bank.getName() + ":");
            for (Account account : bankAccounts) {
                System.out.println(account.getId() + ": " + account.getName());
            }

            double totalTransactionFeeAmount = bank.getTotalTransactionFeeAmount();
            System.out.println("Total transaction fee amount for bank " + bank.getName() + ": $" + totalTransactionFeeAmount);

            double totalTransferAmount = bank.getTotalTransferAmount();
            System.out.println("Total transfer amount for bank " + bank.getName() + ": $" + totalTransferAmount);
        }
    }
}

