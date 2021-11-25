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

    private static void payOut(int withdrawAmount) {

        int originalAmount = withdrawAmount;
        int localBalance = balance;

        int[] localCopyNumberOfEachBillInAccount = {numberOfEachBillInAccount[0], numberOfEachBillInAccount[1], numberOfEachBillInAccount[2]};

        for (int i = 0; i < bankBills.length; i++) {

            //antal sedlar: i=0 kollar antal 1000 lappar, i=1 kollar antal 500 lappar, i=2 kollar antal 100 lappar
            int numberOfBillsToPayOut = withdrawAmount / bankBills[i];

            //om antalet sedlar är större än de vi har och det vi ska dra inte finns i kontot i andra sedlar.
            if (numberOfBillsToPayOut > localCopyNumberOfEachBillInAccount[i] && withdrawAmount > localBalance) {
                System.out.println("Withdrawal declined. \nThere is only " + localCopyNumberOfEachBillInAccount[i] + " " + bankBills[i] + " left in your account.");

                //om antalet sedlar på en nivå är noll, dvs om vi ska betala ut 0 1000 lappar ska vi till början av
                //loopen och gå till i=1 och kolla hur många 500 lappar vi ska betala ut och på samma sätt med 100 lappar.
            } else if (numberOfBillsToPayOut == 0) {
                //om vi inte ska betala ut 1000 lappar och antalet 1000 lappar blir noll ska vi gå till i lika med 1
                //och kolla om vi ska betala ut några 500 lappar och på samma sätt vidare till i lika 2 för att kolla
                //100 lappar. continue hoppar över resten av koden och går upp till loopen som fortsätter till nästa i.

                continue;

            } else {
                //annars om antalet sedlar inte är noll och summan som ska dras inte är mer än det vi har kommer vi hit.
                //När vi kommer hit kan det vara så att antalet sedlar som vi vill ha av en typ är fler än det vi har.
                //Om vi vill dra 3000 är antalet sedlar/1000 lappar 3 men vi har ju 2. så därför gör vi nedan rad.
                // om antalet 1000 lappar är 2 och det vi vill ha är 3 tusenlappar ska 2 betalas ut.
                //så vi väljer minsta talet av 2 och 3 för att bestämma antalet 1000 lappar som ska betalas ut.
                //det gör vi med Math.min(3,2) vilket ger 2 som är antalet vi kan betala ut.

                numberOfBillsToPayOut = Math.min(numberOfBillsToPayOut, localCopyNumberOfEachBillInAccount[i]);

                numberOfEachBillToPayOut[i] = numberOfBillsToPayOut;

                localCopyNumberOfEachBillInAccount[i] = localCopyNumberOfEachBillInAccount[i] - numberOfBillsToPayOut;

                localBalance = localBalance - (numberOfBillsToPayOut * bankBills[i]);

                withdrawAmount = withdrawAmount - (numberOfBillsToPayOut * bankBills[i]);
            }

        }

        int payoutAmount = 0;
        for (int i = 0; i < 3; i++) {
            payoutAmount = payoutAmount + numberOfEachBillToPayOut[i] * bankBills[i];
        }

        if (originalAmount == payoutAmount) {
            reduceBillsInAccount();
            showWithdrawAmount();
            System.out.println("--------------------------------");
            showLeftBanknotes();
            balance = calculateBalance();


        } else {
            System.out.println("Withdrawal declined.");
        }

        //Nollställ utbetalningsarrayen
        numberOfEachBillToPayOut = new int[]{0, 0, 0};
    }

    private static void reduceBillsInAccount() {
        for (int i = 0; i < 3; i++) {
            numberOfEachBillInAccount[i] = numberOfEachBillInAccount[i] - numberOfEachBillToPayOut[i];

        }
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
