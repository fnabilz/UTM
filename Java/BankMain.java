
public class BankMain {
    public static void main(String[] args){

        System.out.println("\nHello ...");
        BankAccount acc1 = new BankAccount("Fikri Nabil",2000);
        acc1.displayAccInfo();

        //acc1.withdraw(500);
        //acc1.deposit(2000);
        //acc1.displayAccInfo();

        acc1.setDividend(0.01);
        acc1.calcDividend(2,1);
        acc1.displayAccInfo();
    }
}

class BankAccount {
    // properties
    private String accountHolderName;
    private double balance;
    private int accountNumber;
    // private String accountType;
    // private String branchCode;
    private double dividendRate;

   public BankAccount () {}
   
    // constructor 2
    public BankAccount (String ahn, double initDepo) {
        this.accountHolderName = ahn;
        this.balance = initDepo;
    }

    // constructor 3
    public BankAccount (String ahn, double initDepo, int accNum) {
        this.accountHolderName = ahn;
        this.balance = initDepo;
        this.accountNumber = accNum;
    }


    //methods
    public void displayAccInfo(){
        System.out.println("ACCOUNT INFO:");
        System.out.println("Acc Hol Name : " + accountHolderName);
        System.out.println("Current Balance : " + balance + "\n");
        
    }

    private boolean isBalSufficient(double amount) {
        if (this.balance > amount) {
            return true;
        }
        else {
           return false; 
        }  
    }

    public void withdraw(double amount) {
        if (isBalSufficient(amount)) {
            balance = balance - amount;
            System.out.println("Withdraw : " + amount);
        }
        else 
            System.out.println("Error!");
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposit : " + amount);
        }
        else {
            System.out.println("Deposit amount must be positive number");
        }
    }

    public void setDividend(double rate) {
        this.dividendRate = rate;
    }

    public void calcDividend(int numPeriod, int year) {
        double bonus = balance * Math.pow((1 + (dividendRate/numPeriod)), numPeriod*year);
        balance = balance + bonus;
    }

    public double getBalance() {
        return balance;
    }
}