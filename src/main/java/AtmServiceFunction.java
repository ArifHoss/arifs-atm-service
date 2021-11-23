public class AtmServiceFunction {
    static final int[] bankBills = {1000, 500, 100};
    static int[] amountOfEachBill = {2, 3, 5};
    static int[] billCounter = {0, 0, 0};
    static int balance;

    static {
        calculateBalance();
    }

    private static void calculateBalance() {
        for (int i = 0; i < bankBills.length; i++) {
            balance = balance + (bankBills[i] * amountOfEachBill[i]);
        }
    }


    public static void checkBanknotes() {
        for (int i = 0; i < bankBills.length; i++) {
            System.out.println(bankBills[i] + " * " + amountOfEachBill[i] + " = " + bankBills[i] * amountOfEachBill[i]);
        }
        System.out.println("Total balance = " + balance);
    }

    public static void showTotalBalance() {
        System.out.println("Total balance: " + balance);
    }


    public static void withdraw(int chooseWithdrawAmount) {

        if (chooseWithdrawAmount > balance || chooseWithdrawAmount % 100 != 0){
            System.out.println("This amount is not available! Try again!");

        } else {
            for (int i = 0; i < bankBills.length; i++) {
                    int countNotes = chooseWithdrawAmount / bankBills[i];
                        billCounter[i] = Math.min(countNotes, amountOfEachBill[i]);
                        amountOfEachBill[i] = countNotes >= amountOfEachBill[i] ? 0 : amountOfEachBill[i] - countNotes;
                        balance = balance - (billCounter[i] * bankBills[i]);
                        chooseWithdrawAmount = chooseWithdrawAmount - (billCounter[i] * bankBills[i]);
            }
            showWithdrawAmount();
            System.out.println("**********");
            showLeftBanknotes();
        }
    }

    private static void showWithdrawAmount() {
        for (int i = 0; i < billCounter.length; i++) {
            if (billCounter[i] != 0) {
                System.out.println(bankBills[i] + " * " + billCounter[i] + " = " + (bankBills[i] * billCounter[i]));
            }
        }
    }

    public static void showLeftBanknotes() {
        for (int i = 0; i < bankBills.length; i++) {
            System.out.println("Notes of " + bankBills[i] + " left are " + amountOfEachBill[i]);

        }
    }
}
