import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private FinanceAdvisor advisor;
    private double balance;
    private ArrayList<Transaction> transactionList = new ArrayList<>();

    public BankAccount(String newAccount) {
        this.accountNumber = newAccount;
    }

    public void hasAdvisor(FinanceAdvisor advisorObj) {
        this.advisor = advisorObj;
    }
    
    public void displayInfo() {
        System.out.println("Account number: " + accountNumber);
        advisor.displayInfo();
    }

    public void deposit(double depositAmount) {
        this.balance = balance + depositAmount;
        Transaction createTransaction = new Transaction("Deposit", depositAmount);
        transactionList.add(createTransaction);
    }

    public void withdraw(double withdrawAmount) {
        this.balance = balance - withdrawAmount;
        Transaction createTransaction = new Transaction("Withdraw", withdrawAmount);
        transactionList.add(createTransaction);
    }

    public double getCurrentBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionList;
    }

    public String getAdvisor() {
        return ""+advisor;
    }

    @Override
    public String toString() {
        return accountNumber;
    }


}

class AccountHolder {
    private String name;
    private BankAccount account;

    public AccountHolder(String holderName) {
        this.name = holderName;
    }

    public void hasAccount(BankAccount accountObj) {
        this.account = accountObj;
    }

    public void deposit(double depositAmount) {
        account.deposit(depositAmount);
    }

    public void withdraw(double withdrawAmount) {
        account.withdraw(withdrawAmount);
    }

    public void printStatement() {
        System.out.println("--------------------Bank Statement--------------------");
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + account);
        System.out.println("Finance Advisor: " + account.getAdvisor());
        System.out.println("Balance: " + account.getCurrentBalance());

        ArrayList<Transaction> transactionHistory = account.getTransactionHistory();
        System.out.println("Transactions History: ");
        for (int i = 0; i < transactionHistory.size(); i++) {
            System.out.println("[" + (i+1) + "] " + transactionHistory.get(i));
        }
        System.out.println("------------------------------------------------");
    }
    
    public void printInfo() {
        System.out.println("Detail Info");
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + account);
        System.out.println("Balance: " + account.getCurrentBalance());
        System.out.println("");
    }
}

class FinanceAdvisor {
    private String name;

    public FinanceAdvisor(String advisorName) {
        this.name = advisorName;
    }

    public void displayInfo() {
        System.out.println("Finance Advisor: " + name);
    }

    @Override
    public String toString() {
        return name;
    }
}

class Transaction {
    private String transactionType;
    private double amount;

    protected Transaction(String newType, double newAmount) {
        this.transactionType = newType;
        this.amount = newAmount;
    }

    @Override
    public String toString() {
        return "Type: " + transactionType + " | Amount: " + amount;
    }

}

class BankOfficer {}
class LoanOfficer {}
class Loan {}

public class MyBankApp {
    public static void main(String[] args) throws Exception {
        
        AccountHolder accountHolder1 = new AccountHolder("Farid");
        BankAccount bankAccount1 =  new BankAccount("201");
        FinanceAdvisor financeAdvisor1 = new FinanceAdvisor("Mui");

        accountHolder1.hasAccount(bankAccount1);
        bankAccount1.hasAdvisor(financeAdvisor1);

        Scanner scan = new Scanner(System.in);
        int choice;
        boolean run = true;
        
        while (run == true) {
            System.out.println("\n_________________________________________________");
            System.out.println("|___________________[BankApp]___________________|");
            System.out.println("[1] Make deposit");
            System.out.println("[2] Make withdrawal");
            System.out.println("[3] Print statement");
            System.out.println("[4] Exit");
            System.out.println("\n Select your choice: ");
            choice = scan.nextInt();
            scan.nextLine();

            if (choice == 1) {
                System.out.println("Enter amount: ");
                double amount = scan.nextDouble();
                scan.nextLine();
                accountHolder1.deposit(amount);
                System.out.println("Success! Press Enter to continue...");
                scan.nextLine();
            }
            else if (choice == 2) {
                System.out.println("Enter amount: ");
                double amount = scan.nextDouble();
                scan.nextLine();
                accountHolder1.withdraw(amount);
                System.out.println("Success! Press Enter to continue...");
                scan.nextLine();
            }
            else if (choice == 3) {
                accountHolder1.printStatement();
                System.out.println("Press Enter to continue...");
                scan.nextLine();
            }
            else if (choice == 4) {
                run = false;
                break;
            }           
        }

        scan.close();
    }
}
