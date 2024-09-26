import java.security.SecureRandom;

public class Bank {
  public static void main(String[] args) {
    BankAccount johnBankAccount = new BankAccount("John Doe");
    johnBankAccount.deposit(100);
    johnBankAccount.deposit(1000);

    BankAccount janeBankAccount = new BankAccount("Jane Doe");
    janeBankAccount.withdraw(50);
    janeBankAccount.transfer(johnBankAccount, 10);

    johnBankAccount.transfer(janeBankAccount, 500);

    janeBankAccount.deposit(500);
    johnBankAccount.transfer(janeBankAccount, 3000);
    johnBankAccount.transfer(janeBankAccount, 300);
    janeBankAccount.getBalance();
    johnBankAccount.getBalance();

    johnBankAccount.withdraw(1000);
    johnBankAccount.getBalance();
    janeBankAccount.transfer(johnBankAccount, 400);
    janeBankAccount.getBalance();

    johnBankAccount.closeAccount();
    janeBankAccount.closeAccount();
  }

}

class BankAccount {
  private String accountNumber;
  private String accountHolderName;
  private double balance;
  private boolean isActive;

  public BankAccount(String accountHolderName) {
    SecureRandom secureRandom = new SecureRandom();
    long accountNumberL = 1000000000L + (long) (secureRandom.nextDouble() * 9000000000L);
    this.accountNumber = Long.toString(accountNumberL);
    this.accountHolderName = accountHolderName;
    this.balance = 0;
    this.isActive = false;

    System.out.println("Account created!");
    System.out.println(String.format("Here's your account number: %s", this.accountNumber));
  }

  // deposit
  public void deposit(double amount) {
    System.out.println(String.format("[%s]", this.accountHolderName));
    if (!this.isActive) {
      if (amount < 500) {
        System.out.println("Initial deposit should be at least 500.");
      } else {
        this.balance += amount;
        this.isActive = true;
        System.out.println("Deposit successful! Account activated!");
      }
    } else {
      System.out.println(String.format("Depositing amounting to %,.2f...", amount));
      if (amount > 0) {
        this.balance += amount;

        System.out.println("Deposit successful!");
      } else {
        System.out.println("Invalid amount.");
      }
    }

  }

  // withdraw
  public void withdraw(double amount) {
    System.out.println(String.format("[%s]", this.accountHolderName));
    if (!this.isActive) {
      System.out.println("Deposit at least 500 to activate your account.");
    } else {
      System.out.println(String.format("Withdrawing amounting to %,.2f...", amount));
      if (amount <= this.balance) {
        this.balance -= amount;

        System.out.println("Withdrawal successful!");
      } else {
        System.out.println("Insufficient balance.");
      }
    }
  }

  // getBalance
  public double getBalance() {
    System.out.println(String.format("[%s]", this.accountHolderName));
    System.out.println("Retrieving current balance...");
    return this.balance;
  }

  // transfer
  public void transfer(BankAccount targetAccount, double amount) {
    System.out.println(String.format("[%s]", this.accountHolderName));
    if (!this.isActive) {
      System.out.println("Deposit at least 500 to activate your account.");
    } else {
      System.out.println(String.format("[%s]", this.accountHolderName));
      System.out.println(String.format("Transfering %,.2f to %s...", amount, targetAccount.getAccountName()));
      if (amount <= this.balance) {
        this.balance -= amount;
        targetAccount.receive(this, amount);

        System.out.println("Transfer successful!");
      } else {
        System.out.println("Insufficient balance.");
      }
    }
  }

  public void receive(BankAccount senderAccount, double amount) {
    System.out.println(String.format("[%s]", this.accountHolderName));
    if (!this.isActive) {
      System.out.println("Inactive account.");
    } else {
      this.balance += amount;
      System.out.println(String.format("Received %,.2f", amount));
    }
  }

  public String getAccountName() {
    System.out.println(String.format("[%s]", this.accountHolderName));
    return this.accountHolderName;
  }

  public void closeAccount() {
    System.out.println(String.format("[%s]", this.accountHolderName));
    if (!this.isActive) {
      System.out.println("Inactive account.");
    } else {
      if (this.balance > 0) {
        System.out.println("Please empty your balance before closing your account.");
        System.out.println(String.format("Current Balance: %,.2f", balance));
      }
    }
  }
}
