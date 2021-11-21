public class AtmServiceFunction {
    static final int[] banknotes = {1000, 500, 100};
    static int[] amountOfEachNotes = {2, 3, 5};
    static int[] counter = {0, 0, 0};
    static int balance;

    static {
        calculateBalance();
    }

    public AtmServiceFunction() {

    }

    public static void calculateBalance() {
        for (int i = 0; i < banknotes.length; i++) {
            balance = balance + (banknotes[i] * amountOfEachNotes[i]);
        }
    }


    public static void checkBanknotes() {
        for (int i = 0; i < banknotes.length; i++) {
            System.out.println(banknotes[i] + " * " + amountOfEachNotes[i] + " = " + banknotes[i] * amountOfEachNotes[i]);
        }
        System.out.println("Total balance = " + balance);
    }


    public synchronized void withdraw(int chooseWithdrawAmount) {
        if (chooseWithdrawAmount > balance) {
            System.out.println("This amount is not available! Try again!");

        } else {
            for (int i = 0; i < banknotes.length; i++) {
                if (banknotes[i] < chooseWithdrawAmount || chooseWithdrawAmount % 100 != 0) {
                    int countNotes = chooseWithdrawAmount / banknotes[i];
                    if (amountOfEachNotes[i] > 0) {
                        counter[i] = countNotes >= amountOfEachNotes[i] ? amountOfEachNotes[i] : countNotes;
                        amountOfEachNotes[i] = countNotes >= amountOfEachNotes[i] ? 0 : amountOfEachNotes[i] - countNotes;
                        balance = balance - (counter[i] * banknotes[i]);
                        chooseWithdrawAmount = chooseWithdrawAmount - (counter[i] * banknotes[i]);
                    }
                }

            }
            showWithdrawAmount();
            showLeftBanknotes();


        }

    }

    public static void withdraw1(int chooseWithdrawAmount) {
        if (chooseWithdrawAmount <= balance) {
            for (int i = 0; i < banknotes.length; i++) {
                if (banknotes[i] <= chooseWithdrawAmount) {
                    int addNotes = chooseWithdrawAmount / banknotes[i];
                    if (amountOfEachNotes[i] > 0) {
                        counter[i] = addNotes >= amountOfEachNotes[i] ? amountOfEachNotes[i] : addNotes;
                        amountOfEachNotes[i] = addNotes >= amountOfEachNotes[i] ? 0 : amountOfEachNotes[i] - addNotes;
                        balance = balance - (counter[i] * banknotes[i]);
                        chooseWithdrawAmount = chooseWithdrawAmount - (counter[i] * banknotes[i]);
                    }
                }
            }
            showWithdrawAmount();

            showLeftBanknotes();
        }

    }


    private static void showLeftBanknotes() {
        for (int i = 0; i < banknotes.length; i++) {
            System.out.println("Notes of " + banknotes[i] + " left are " + amountOfEachNotes[i]);

        }
    }

    private static void showWithdrawAmount() {
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                System.out.println(banknotes[i] + " * " + counter[i] + " = " + (banknotes[i] * counter[i]));
            }

        }
    }

}
