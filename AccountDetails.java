import java.util.Scanner;

class BankAccount {
    String accountNumber, name;
    double balance;

    public BankAccount(String accNum, String name, double balance) {
        this.accountNumber = accNum;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public double checkBalance() { 
        return balance; 
    }

    public void displayAccount() {
        System.out.println("\n--- Account Summary ---");
        System.out.println("Account: " + accountNumber + " | Holder: " + name + " | Balance: ₹" + balance);
    }
}

public class AccountDetails {
    static void executeDeposit(BankAccount acc, double amt) { 
        acc.deposit(amt); 
    }
    
    static void executeWithdrawal(BankAccount acc, double amt) { 
        acc.withdraw(amt); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String number = sc.next();
        System.out.print("Enter Account Holder Name: ");
        String holder = sc.next();
        System.out.print("Enter Initial Balance: ");
        double initial = sc.nextDouble();

        BankAccount account = new BankAccount(number, holder, initial);
        account.displayAccount();

        System.out.print("\nEnter amount to deposit: ");
        executeDeposit(account, sc.nextDouble());

        System.out.print("Enter amount to withdraw: ");
        executeWithdrawal(account, sc.nextDouble());

        System.out.println("\nFinal Details:");
        account.displayAccount();
        sc.close();
    }
}