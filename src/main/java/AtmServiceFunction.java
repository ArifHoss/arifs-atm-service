public class AtmServiceFunction {

    /*
    Banknotes available in ATM
    Amount of each banknote
    The Counter
    */

    static final int [] banknotes = {1000, 500, 100};
    static int [] amountOfEachNotes = {2, 3, 5};
    static int [] counter = {0, 0, 0};
    static int balance;

    public static void checkBanknotes(){
        for (int i = 0; i < banknotes.length; i++) {
            System.out.println(banknotes[i]+" * "+amountOfEachNotes[i]+ " = "+banknotes[i]*amountOfEachNotes[i]);
        }
    }

    public static void calculateBalance(){
        for (int i = 0; i < banknotes.length; i++) {
            balance = balance + (banknotes[i]*amountOfEachNotes[i]);
//            System.out.println(banknotes[i]+" * "+amountOfEachNotes[i] +" = "+ banknotes[i]*amountOfEachNotes[i] );
        }
            System.out.println("Total balance = "+balance);
    }


}
