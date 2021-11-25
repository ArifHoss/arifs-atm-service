import java.util.Scanner;

public class ATMMenu {

    static Scanner sc = new Scanner(System.in);

    public static void main(String [] args){

        while(true){
            System.out.println("""
                \n=================================
                           ATM Services
                =================================
                1. Withdraw
                2. Check total balance
                3. Check available banknotes
                4. Show left banknotes
                0. Exit
                =================================
                """);

            System.out.print("Please make a choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> initiateWithdraw();
                case 2 -> {
                    System.out.println("=================================");
                    AtmServiceFunction.showTotalBalance();
                }
                case 3 -> {
                    System.out.println("=================================");
                    System.out.println("This are the bills available in this ATM.");
                    AtmServiceFunction.checkBanknotes();
                }
                case 4 -> {
                    System.out.println("=================================");
                    AtmServiceFunction.showLeftBanknotes();
                }
                case 0 -> {
                    System.out.println("=================================");
                    System.out.println("Good Bye! See you soon.");
                    System.exit(0);
                }
                default -> System.out.println("Wrong choice! Choose again.");
            }

        }
    }

    private static void initiateWithdraw() {
        System.out.println("=================================");
        System.out.print("How much do you want to withdraw: ");
        int chooseWithdrawAmount = sc.nextInt();
        AtmServiceFunction.withdraw(chooseWithdrawAmount);
    }
}
