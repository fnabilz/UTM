class User {
    String username;
    String password;
    String role;

    public User(String uName, String pWord, String role) {
        this.username = uName;
        this.password = pWord;
        this.role = role;
    }

    public void displayInfo() {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Role: " + role);
    }
}

class FinanceAdvisor extends User {
    String id;
    double rating;

    public FinanceAdvisor(String uName, String pWord, String role, double rate, String ID) {
        super(uName, pWord, role);
        this.rating = rate;
        this.id = ID;
    }

   public void displayInfo() {
        System.out.println("\n-----------[Finance Advisor]-----------");
        super.displayInfo();
        System.out.println("Rating: " + rating);
        System.out.println("ID: " + id);
    }
}

class AccountHolder extends User {
    String accNumber;
    double accBalance;

    public AccountHolder(String uName, String pWord, String role, String accNum, double balance) {
        super(uName, pWord, role);
        this.accNumber = accNum;
        this.accBalance = balance;
    }

    public void deposit(double amount) {
        this.accBalance = this.accBalance + amount;
    }

    public void withdraw(double amount) {
        this.accBalance = this.accBalance - amount;
    }
    
    public void displayInfo() {
        System.out.println("\n-----------[Account Holder]-----------");
        super.displayInfo();
        System.out.println("Account Number: " + accNumber);
        System.out.println("Balance: " + accBalance);
    }

}

// class LoanOfficer extends User {}

class BankOfficer extends User {
    String branchId;
    String email;

    public BankOfficer(String uName, String pWord, String role, String branch, String email) {
        super(uName, pWord, role);
        this.branchId = branch;
        this.email = email;
    }

    public void displayInfo() {
        System.out.println("\n-----------[Bank Advisor]-----------");
        super.displayInfo();
        System.out.println("Branch ID: " + branchId);
        System.out.println("Email: " + email);
    }
}

// class Admin extends User {}
 

public class App {
    public static void main(String[] args) throws Exception {
        
        /* 
        *    Rahman is a financial advisor,
        *    Username = rahman
        *    Password = abc123
        *    Role = Finance Advisor
        *    Rating = 5
        *    ID = id101
        */
        FinanceAdvisor finAdvisor1 = new FinanceAdvisor("rahman", "abc123", "Finance Advisor", 5.0, "id101");
        finAdvisor1.displayInfo();

        /*
         * Ali is an account holder,
         * Usename = ali
         * Password = pass123
         * Role = Account Holder
         * Account Number = sa202
         * Balance = RM 0.0
         */
        AccountHolder account1 = new AccountHolder("ali", "pass123", "Account Holder", "sa202", 0.0);
        account1.deposit(500);
        account1.withdraw(20);
        account1.withdraw(50);
        account1.displayInfo();

        /*
         * May is a bank officer,
         * Username = may
         * Password = officer123
         * Role = Bank Officer
         * Branch ID = tmnU2
         * Email = may@gmail.com
         */
        BankOfficer bOfficer1 = new BankOfficer("may", "officer123", "Bank Officer", "tmnU2", "may@gmail.com");       
        bOfficer1.displayInfo();

        System.out.println("");
    }
}
