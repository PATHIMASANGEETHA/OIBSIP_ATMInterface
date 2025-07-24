import java.util.Scanner;

public class ATM {
    private static double balance = 1000.00;
    private static String transactionHistory = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pin = 1234; // Default PIN
        int enteredPin;

        System.out.println("🏧 Welcome to ATM Interface");
        System.out.print("Enter your 4-digit PIN: ");
        enteredPin = sc.nextInt();

        if (enteredPin != pin) {
            System.out.println("❌ Incorrect PIN. Exiting...");
            return;
        }

        int choice;
        do {
            System.out.println("\n========= ATM Menu =========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(sc);
                    break;
                case 3:
                    withdraw(sc);
                    break;
                case 4:
                    showTransactionHistory();
                    break;
                case 5:
                    System.out.println("👋 Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice. Please try again.");
            }

        } while (choice != 5);
        
        sc.close();
    }

    public static void checkBalance() {
        System.out.printf("💰 Current Balance: ₹%.2f\n", balance);
    }

    public static void deposit(Scanner sc) {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("❌ Invalid amount. Try again.");
            return;
        }

        balance += amount;
        transactionHistory += "Deposited: ₹" + amount + "\n";
        System.out.println("✅ Amount deposited successfully.");
    }

    public static void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("❌ Invalid amount.");
        } else if (amount > balance) {
            System.out.println("⚠️ Insufficient balance.");
        } else {
            balance -= amount;
            transactionHistory += "Withdrawn: ₹" + amount + "\n";
            System.out.println("✅ Please collect your cash.");
        }
    }

    public static void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("📄 No transactions yet.");
        } else {
            System.out.println("\n📄 Transaction History:");
            System.out.println(transactionHistory);
        }
    }
}
