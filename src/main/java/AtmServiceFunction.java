public class AtmServiceFunction {
    static final int[] bankBills = {1000, 500, 100};
    static int[] numberOfEachBillInAccount = {2, 3, 5};
    static int[] numberOfEachBillToPayOut = {0, 0, 0};
    static int balance = calculateBalance();

    private static int calculateBalance() {

        int balance = 0;

        for (int i = 0; i < bankBills.length; i++) {
            balance = balance + (bankBills[i] * numberOfEachBillInAccount[i]);
        }

        AtmServiceFunction.balance = balance;

        return balance;
    }


    public static void checkBanknotes() {


        for (int i = 0; i < bankBills.length; i++) {
            System.out.println(bankBills[i] + " * " + numberOfEachBillInAccount[i] + " = " + bankBills[i] * numberOfEachBillInAccount[i]);
        }

        System.out.println("Total balance = " + balance);
    }

    public static void showTotalBalance() {

        System.out.println("Total balance: " + balance);
    }


    public static void withdraw(int chooseWithdrawAmount) {

        if (chooseWithdrawAmount > balance || chooseWithdrawAmount % 100 != 0) {
            System.out.println("This amount is not available! Try again!");

        } else {
            payOut(chooseWithdrawAmount);
        }
    }

    private static void payOut(int chooseWithdrawAmount) {
        boolean pay = true;

        for (int i = 0; i < bankBills.length; i++) {
            int numberOfBillsToPayOut = chooseWithdrawAmount / bankBills[i];


            if (numberOfBillsToPayOut > numberOfEachBillInAccount[i]) {
                pay = false;
                System.out.println("Withdrawal declined. \nThere is only " + numberOfEachBillInAccount[i] + " " + bankBills[i] + " left in your account.");

            } else if (numberOfBillsToPayOut == 0) {
                continue;
            } else {
                pay = true;
                numberOfEachBillToPayOut[i] = numberOfBillsToPayOut;
                numberOfEachBillInAccount[i] = numberOfEachBillInAccount[i] - numberOfBillsToPayOut;
            }

            balance = calculateBalance();
            chooseWithdrawAmount = chooseWithdrawAmount - (numberOfBillsToPayOut * bankBills[i]);
        }
        if (pay)
            showWithdrawAmount();
        System.out.println("--------------------------------");
        showLeftBanknotes();
    }

    private static void showWithdrawAmount() {
        for (int i = 0; i < numberOfEachBillToPayOut.length; i++) {
            if (numberOfEachBillToPayOut[i] != 0) {
                System.out.println(bankBills[i] + " * " + numberOfEachBillToPayOut[i] + " = " + (bankBills[i] * numberOfEachBillToPayOut[i]));
            }
        }
    }

    public static void showLeftBanknotes() {
        for (int i = 0; i < bankBills.length; i++) {
            System.out.println("Notes of " + bankBills[i] + " left are " + numberOfEachBillInAccount[i]);

        }
    }
}
