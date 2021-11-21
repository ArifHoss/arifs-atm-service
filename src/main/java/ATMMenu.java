import java.util.Scanner;

public class ATMMenu {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String [] args){
        while(true){
            System.out.println("=================================");
            System.out.println("\n1. Withdraw");
            System.out.println("2. Unset");
            System.out.println("3. Check banknotes");
            System.out.println("4. Check Balance");
            System.out.println("0. Exit");
            System.out.println("=================================");
            System.out.print("Please make a choice: ");

            int choice = sc.nextInt();
            if(choice == 1){
                System.out.println("=================================");
                System.out.print("How much do you need to withdraw: ");
                int chooseWithdrawAmount = sc.nextInt();
//                new AtmServiceFunction().withdraw(chooseWithdrawAmount);
                AtmServiceFunction.withdraw1(chooseWithdrawAmount);
            }else if(choice == 2){
                System.out.println("=================================");
                System.out.println("This function is currently unavailable");
            }else if(choice == 3){
                System.out.println("=================================");
                System.out.println("Banknotes left.");
                AtmServiceFunction.checkBanknotes();
            }else if(choice == 4){
                System.out.println("=================================");
                AtmServiceFunction.calculateBalance();
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
