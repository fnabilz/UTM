
@FunctionalInterface
interface Calculatori {
    double operate(double a, double b);
}

@FunctionalInterface
interface Pow {
    double operate(double a);
}

@FunctionalInterface
interface AnotherFP {
    void sayHello();
}

class Person {
    private String name;
    private int yob;
    private double weight, height;

    public Person(String name, int yob, double weight, double height) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return 2025 - this.yob;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}

@FunctionalInterface
interface bmi {
    double operate(double weight, double height);
}

@FunctionalInterface
interface age {
    int operate(int yob);
}

class Calculator {

    public double add(double num1, double num2) {return num1 + num2;}
    public double sub(double num1, double num2) {return num1 - num2;}
    public double mul(double num1, double num2) {return num1 * num2;}
    public double div(double num1, double num2) {return num1 / num2;}

}

class BankAccount {

    private String name;
    private double balance;
    private double dividentRate;
    private double dividentAmount;

 

    public BankAccount(String name, double balance) {

        this.name = name;

        this.balance = balance;

    }

    public void setDividentRate(double rate) {
        this.dividentRate = rate;
    }

    public void calcDividentAmt() {
        dividentAmount = balance * dividentRate;
    }
 

    public String getName() { return name; }

    public double getBalance() { return balance; }

    public void displayInfo() {
        System.out.println("\nName: " + this.name + "\nBalance: RM " + this.balance + "\n");
    }

}

@FunctionalInterface
interface DividentCalculator {
    double calculate(double balance, double rate);
}

@FunctionalInterface
interface Empty {
    void operate();
}

@FunctionalInterface
interface ServePrint {
    void doing(String a, int b, double c, String d);
}

public class App {

    //public static double calculateDividentAmount(double balance, double rate) {
     //   return balance * (rate/100);
    //}

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        bmi calcBMI = (weight, height) -> { // a variable that hold a function
            double BMI = weight / (height * height);
            return BMI;
        };

        ServePrint cetak = (name, age, bmi, category) -> {
            System.out.println("\n----[Printing Service]----");
            System.out.println("Name : " + name);
            System.out.println("Age : " + age);
            System.out.println("BMI : " + bmi);
            System.out.println("Category : " + category);
        };

        Person orang = new Person("aidid", 2005, 77.0, 1.67);
        cetak.doing(orang.getName(), orang.getAge(), calcBMI.operate(orang.getWeight(), orang.getHeight()), "normal");

        //Empty x = () -> {System.out.println();};


        //System.out.println("Name : " + orang.name + "\nBMI : " + calcBMI.operate(orang.weight, orang.height));




        /*Calculator c1 = new Calculator();
        System.out.println(c1.add(2.3, 4.2));
        
        Calculatori div = (x, y) -> x / y;
        Calculatori mul = (x, y) -> x * y;
        Calculatori add = (x, y) -> x + y;
        Calculatori sub = (x, y) -> x - y;

        // no parameter syntax: AnotherFP fp1 = () -> {sysout};

        AnotherFP fp1 = () -> System.out.println("helloworld");

        Pow pwr = x -> {
            return x * x;
        };

        System.out.println("2 power of 2 is " + pwr.operate(2));

        DividentCalculator calc = (balance, rate) -> balance * (rate/100);

        BankAccount acc1 = new BankAccount("ali", 200.00);
        System.out.println("\nName: " + acc1.getName() + "\nBalance: RM " + acc1.getBalance() + "\nDivident: RM " + calc.calculate(acc1.getBalance(), 4.0));

        BankAccount acc2 = new BankAccount("siti", 1200.00);
        System.out.println("\nName: " + acc2.getName() + "\nBalance: RM " + acc2.getBalance() + "\nDivident: RM " + calc.calculate(acc1.getBalance(), 4.0));
        */
    }
}
