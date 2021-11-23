import java.util.Scanner;

public class ATMMenu {

    static Scanner sc = new Scanner(System.in);

    public static void main(String [] args){
        while(true){
            System.out.println("=================================");
            System.out.println("1. Withdraw");
            System.out.println("2. Check total balance");
            System.out.println("3. Check available banknotes");
            System.out.println("4. Show left banknotes");
            System.out.println("0. Exit");
            System.out.println("=================================");
            System.out.print("Please make a choice: ");

            int choice = sc.nextInt();
            if(choice == 1){
                System.out.println("=================================");
                System.out.print("How much do you need to withdraw: ");
                int chooseWithdrawAmount = sc.nextInt();
                AtmServiceFunction.withdraw(chooseWithdrawAmount);

            }else if(choice == 2){
                System.out.println("=================================");
                AtmServiceFunction.showTotalBalance();

            }else if(choice == 3){
                System.out.println("=================================");
                System.out.println("This are the bills available in this ATM.");
                AtmServiceFunction.checkBanknotes();

            }else if(choice == 4){
                System.out.println("=================================");
                AtmServiceFunction.showLeftBanknotes();

            }else if(choice == 0){
                System.out.println("=================================");
                System.out.println("Good Bye! See you soon.");
                System.exit(0);

            }else{
                System.out.println("Wrong choice! Choose again.");
            }

        }
    }
}
