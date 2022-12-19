#Bank Challenge
This application simulates financial transactions at a bank. It includes a `Bank` class that can be used to create bank objects and perform financial transactions, as well an `Account` class that represents a bank account

##Prerequisites

Before you can build and run the application, you will need to make sure you have the following tools installed:

* Java 8 or later
* A Java development environment (e.g. Eclipse, IntelliJ)

###Building the application

To build the application, follow these steps:

1. Open the project in your Java development environment.
2. Compile the code.

###Running the application

To run the application, follow these steps:

1. Open the `Main` class in your Java development environment.
2. Run the `main` method.

The application will create two `Bank` objects, each with several ` Account` objects. It will then execute a series of financial transactions for each bank and print out a list of transactions and the balance for each account.

###Using the `Bank` and `Account` classes

Here are some examples of how you can use the `Bank` and `Account` classes from the provided code to perform transactions:

####Creating a bank and setting transaction fees
* `Bank bank = new Bank("STB");`
* `bank.setTransactionFees(10, 5);`

####Creating accounts and adding them to the bank
* `Account account = new Account(1,"Jakup Sinani",1000);`

This creates an Account object with the given id, name, and balance.

To add an account to the bank, you can use the following code:
* `bank.addAccount(account);`

You can create and add multiple accounts to the bank in this way.

####Transferring money between accounts
To transfer money from one account to another, you can use the following code:

* `try {`
* `bank.transfer(account1, account2, 100, "Gift");`
* `} catch (InsufficientFundsException e) {`
* `System.out.println(e.getMessage());`
* `} catch (AccountNotFoundException e) {`
* `System.out.println(e.getMessage());`
* `}`

This code transfers 100 units of currency from `account1` to `account2`. If there are insufficient funds in `account1`, an `InsufficientFundsException` will be thrown. If either `account1` or `account2` does not exist in the bank, an `AccountNotFoundException` will be thrown.


####Withdrawing money from an account

To withdraw money from an account, you can use the following code:

* `try {`
* `bank.withdraw(account, 50, "Shopping");`
* `} catch (InsufficientFundsException e) {`
* `System.out.println(e.getMessage());`
* `} catch (AccountNotFoundException e) {`
* `System.out.println(e.getMessage());`
* `}`

This code withdraws 50 units of currency from `account`. If there are insufficient funds in the account, an `InsufficientFundsException` will be thrown. If the account does not exist in the bank, an `AccountNotFoundException` will be thrown.

####Depositing money into an account

To deposit money into an account, you can use the following code:

* `try {`
* `bank.deposit(account, 200, "Salary");`
* `} catch (InsufficientFundsException e) {`
* `System.out.println(e.getMessage());`
* `} catch (AccountNotFoundException e) {`
* `System.out.println(e.getMessage());`
* `}`

This code deposits 200 units of currency into `account`. If there are insufficient funds to cover the deposit, an `InsufficientFundsException` will be thrown. If the account does not exist in the bank, an `AccountNotFoundException` will be thrown.


####Getting the balance of an account

To get the balance of an account, you can use the following code:

* `double balance = bank.getBalance(account);`
* `System.out.println("Balance for account: $" + balance);`

This code calculates and prints out the balance for `account`.

####Getting the list of transactions for an account

To get the list of transactions for an account, you can use the following code:

* `List<Transaction> transactions = bank.getTransactions(account);`
* `for (Transaction transaction : transactions) {`
* `System.out.println(transaction.getType() + ": $" + transaction.getAmount() + " (Fee: $" + transaction.getTransactionFee() + ")" + " Reason: " + transaction.getReason());`
* `}`

This code gets a list of `Transaction` objects associated with `account` and prints out the details of each transaction (type, amount, fee, and reason).

####Getting the list of accounts in a bank

To get the list of accounts in a bank, you can use the following code:

* `List<Account> bankAccounts = bank.getAccounts();`
* `for (Account a : bankAccounts) {`
* `System.out.println(a.getId() + ": " + a.getName());`
* `}`

This code gets a list of `Account` objects associated with the bank and prints out the id and name of each account.

####Getting the total amount of transaction fees collected by a bank

To get the total amount of transaction fees collected by a bank, you can use the following code:

* `double totalTransactionFeeAmount = bank.getTotalTransactionFeeAmount();`
* `System.out.println("Total transaction fee amount: $" + totalTransactionFeeAmount);`

This code calculates and prints out the total amount of transaction fees collected by the bank.


# Package `model`

This package contains the `Account` class, which represents a bank account.

## Class `Account`

The `Account` class has the following properties:

* `int id`: a unique identifier for the account
* `String name`: the name of the account holder
* `double balance`: the current balance of the account
* `List<Transaction>transactions`: a list of transactions associated with the account

The `Account` class has the following methods:

* `Account(int id, String name, double balance)`: constructs a new `Account` object with the given id, name, and balance
* `int getId()`: return the id of the account
* `String getName()`: returns the name of the account holder
* `double getBalance()`: returns the current balance of the account
* `void setName(String name)`: sets the name of the account holder
* `void setBalance(double balance)`: sets the current balance of the account
* `void withdraw(double amount)`: withdraws the given amount from the account
* `void deposit(double amount)`: deposits the given amount into the account
* `void addTransaction(Transaction transaction)`: adds the given transaction to the list of transactions associated with the account
* `List<Transaction> getTransactions()`: returns the list of transactions associated with the account

## Class `Bank`

The `Bank` class represents a bank and has the following properties:

* `String name`: the name of the bank
* `List<Account> accounts`: a list of accounts in the bank
* `double totalTransactionFeeAmount`: the total amount of transaction fees collected by the bank
* `double totalTransferAmount`: the total amount transferred between accounts in the bank
* `double transactionFlatFeeAmount`: the flat fee charged by the bank for each transaction
* `double transactionPercentFeeValue`: the percentage of the transaction amount that is charged as a fee by the bank

The `Bank` class has the following methods:

* `Bank(String name)`: constructs a new Bank object with the given name
* `String getName()`: returns the name of the bank
* `void setName(String name)`: sets the name of the bank
* `void setTransactionFees(double flatFee, double percentFee)`: sets the flat fee and percentage fee for transactions in the bank
* `void addAccount(Account account)`: adds the given account to the list of accounts in the bank
* `void transfer(Account fromAccount, Account toAccount, double amount, String reason)`: transfers the given amount from the `fromAccount` to the `toAccount`, with the given reason. Throws an `InsufficientFundsException` if the `fromAccount` has insufficient funds, and throws an `AccountNotFoundException` if either the `fromAccount` or the `toAccount` are not found in the bank.
* `void withdraw(Account account, double amount, String reason)`: withdraws the given amount from the given account, with the given reason. Throws an `InsufficientFundsException` if the `account` has insufficient funds, and throws an `AccountNotFoundException` if the `account` is not found in the bank.
* `void deposit(Account account, double amount, String reason)`: deposits the given `amount` into the given `account`, with the given `reason`. Throws an `AccountNotFoundException` if the `account` is not found in the bank.
* `List<Transaction> getTransactions(Account account)`: returns the list of transactions associated with the given `account`
* `double getBalance(Account account)`: returns the current balance of the given `account`
* `List<Account> getAccounts()`: returns the list of accounts in the bank
* `double getTotalTransactionFeeAmount()`: returns the total amount of transaction fees collected by the bank
* `double getTotalTransferAmount()`: returns the total amount transferred between accounts in the bank
* `double calculateTransactionFee(double amount)`: calculates the transaction fee for a transaction of the given amount based on the bank's flat fee and percentage fee

The `Bank` class also has inner classes representing different types of transactions:

* `Transaction`: the base class for all transactions
* `DepositTransaction`: represents a deposit transaction
* `WithdrawalTransaction`: represents a withdrawal transaction
* `TransferTransaction`: represents a transfer between two accounts

Each of these inner classes has properties and methods specific to the type of transaction it represents.


#Package `transaction`

This package contains classes for representing transactions in a banking system.

##Class `Transaction`

The `Transaction` class is an abstract class that represents a financial transaction. It has the following fields:

* `amount`: a `double` representing the amount of the transaction
* `fromAccountId`: an `Integer` representing the account the transaction is coming from
* `toAccountId`: an `Integer` representing the account the transaction is going to
* `reason`: a `String` representing the reason for the transaction
* `transactionFee`: a `double` representing the fee charged for the transaction

The `Transaction` class has the following methods:

* `getAmount()`: returns the amount of the transaction as a `double`
* `getFromAccountId()`: returns the account the transaction is coming from as an `Integer`
* `getToAccountId()`: returns the account the transaction is going to as an `Integer`
* `getReason()`: returns the reason for the transaction as a `String`
* `getTransactionFee()`: returns the fee charged for the transaction as a `double`
* `getType()`: returns the type of the transaction as a `String`. This is an abstract method that must be implemented by subclasses.

##Class `DepositTransaction`

The `DepositTransaction` class is a subclass of `Transaction` that represents a deposit transaction. It has the following methods:

* `getType()`: returns "Deposit" as a `String`

##Class `TransferTransaction`
The `TransferTransaction` class is a subclass of `Transaction` that represents a transfer transaction. It has the following methods:

* `getType()`: returns "Transfer" as a `String`

##Class `WithdrawalTransaction`
The `WithdrawalTransaction` class is a subclass of `Transaction` that represents a withdrawal transaction. It has the following methods:

* `getType()`: returns "Withdrawal" as a `String`

#Package `exception`

This package contains two custom exceptions: `InsufficientFundsException` and `AccountNotFoundException`.

##Class `InsufficientFundsException`

The `InsufficientFundsException` class is a custom exception that is thrown when an operation attempts to withdraw more money from an account than is currently available in the account balance.

##Class `AccountNotFoundException`

The `AccountNotFoundException` class is a custom exception that is thrown when an operation attempts to access an account that does not exists.~~

