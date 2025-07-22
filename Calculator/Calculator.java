import java.util.Scanner;

public class Calculator {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== CONSOLE-BASED CALCULATOR ===");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Power (x^y)");
            System.out.println("7. Temperature Conversion");
            System.out.println("8. Currency Conversion");
            System.out.println("9. Trigonometric Functions");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: basicOperation("add"); break;
                case 2: basicOperation("subtract"); break;
                case 3: basicOperation("multiply"); break;
                case 4: basicOperation("divide"); break;
                case 5: squareRoot(); break;
                case 6: power(); break;
                case 7: temperatureConversion(); break;
                case 8: currencyConversion(); break;
                case 9: trigonometricFunctions(); break;
                case 0: System.out.println("Thank you! Exiting..."); break;
                default: System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);

        sc.close();
    }

    static void basicOperation(String operation) {
        System.out.print("Enter two numbers: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        switch (operation) {
            case "add": System.out.println("Result = " + (a + b)); break;
            case "subtract": System.out.println("Result = " + (a - b)); break;
            case "multiply": System.out.println("Result = " + (a * b)); break;
            case "divide":
                if (b == 0)
                    System.out.println("Error: Division by zero!");
                else
                    System.out.println("Result = " + (a / b));
                break;
        }
    }

    static void squareRoot() {
        System.out.print("Enter a number: ");
        double num = sc.nextDouble();
        if (num < 0) {
            System.out.println("Error: Negative input!");
        } else {
            System.out.println("Square root = " + Math.sqrt(num));
        }
    }

    static void power() {
        System.out.print("Enter base and exponent: ");
        double base = sc.nextDouble();
        double exp = sc.nextDouble();
        System.out.println("Result = " + Math.pow(base, exp));
    }

    static void temperatureConversion() {
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose conversion: ");
        int tempChoice = sc.nextInt();
        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();

        if (tempChoice == 1) {
            System.out.println("Result = " + ((temp * 9 / 5) + 32) + " °F");
        } else if (tempChoice == 2) {
            System.out.println("Result = " + ((temp - 32) * 5 / 9) + " °C");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    static void currencyConversion() {
        double rateINRtoUSD = 0.012; // example rate
        double rateUSDtoINR = 83.0;  // example rate
        System.out.println("1. INR to USD");
        System.out.println("2. USD to INR");
        System.out.print("Choose conversion: ");
        int currChoice = sc.nextInt();
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();

        if (currChoice == 1) {
            System.out.println("Result = $" + (amt * rateINRtoUSD));
        } else if (currChoice == 2) {
            System.out.println("Result = ₹" + (amt * rateUSDtoINR));
        } else {
            System.out.println("Invalid choice.");
        }
    }

    static void trigonometricFunctions() {
        System.out.println("Choose function:");
        System.out.println("1. sin(x)");
        System.out.println("2. cos(x)");
        System.out.println("3. tan(x)");
        System.out.print("Enter your choice: ");
        int trigChoice = sc.nextInt();
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();
        double radians = Math.toRadians(angle); // Convert to radians

        switch (trigChoice) {
            case 1:
                System.out.println("sin(" + angle + ") = " + Math.sin(radians));
                break;
            case 2:
                System.out.println("cos(" + angle + ") = " + Math.cos(radians));
                break;
            case 3:
                if (Math.abs(Math.cos(radians)) < 1e-10)
                    System.out.println("tan(" + angle + ") is undefined (infinite)");
                else
                    System.out.println("tan(" + angle + ") = " + Math.tan(radians));
                break;
            default:
                System.out.println("Invalid trigonometric option!");
        }
    }
}