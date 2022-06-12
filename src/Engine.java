import java.util.Random;
import java.util.Scanner;

public class Engine {
    int[] secretCode;
    int score; int BOARD_SIZE;
    public Engine() {

        //secretCode
    }

    private static void intro() {
        System.out.println();
        System.out.println("---- MASTERMIND ----");
        System.out.println();
        System.out.println("Zasady gry: Znajdź ukryty kod składający się z 4 cyfr");
        System.out.println("z zakresu od 1 do 6. Po każdej próbie dostaniesz informację");
        System.out.println("czy cyfra jest trafiona i czy jest na właściwym miejscu.");
        System.out.println("Powodzenia!");
        System.out.println();
    }

    private void engine( int[] gamerCode) {

        int win = 0;
        int[] secretCodeState = new int[BOARD_SIZE];
        int[] gamerCodeState = new int[BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            if (secretCode[i] == gamerCode[i]) {
                win++;
                secretCodeState[i] = 2;
                gamerCodeState[i] = 2;
            } else {
                secretCodeState[i] = 0;
                gamerCodeState[i] = 0;
            }
        }

        if (win == BOARD_SIZE) {
            System.out.println("Gratulacje! Udało Ci się odkryć sekretny kod!");
            //showGamerCode(gamerCode, BOARD_SIZE);
            System.out.println("Liczba kroków: " + score);
            return;
        } else {

            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (secretCodeState[i] != 2) {
                        if (secretCode[i] == gamerCode[j]) {
                            if (gamerCodeState[j] == 0 && secretCodeState[i] == 0) {
                                secretCodeState[i] = 1;
                                gamerCodeState[j] = 1;
                            }
                        }
                    }
                }
            }
            showHint(gamerCodeState, BOARD_SIZE);
         //   getCode(secretCode, gamerCode, BOARD_SIZE, score);
        }

        // TODO napisać skrypt, który oblicza trafione cyfry nie na swoim miejscu

        // TODO skrypt nie może brać pod uwagę tych cyfr, które są na swoim miejscu
        // TODO ale powtarzają się w innym
        // TODO na przykład: właściwy kod 1212 - kod gracza 1333 - skrypt powinien
        // TODO pokazać 1 trafienie na właściwym miejscu i 0 na niewłaściwych miejscach

        // TODO tak samo jeśli gracz poda kilka takich samych cyfr
        // TODO skrypt powinien pokazywać jako jedno trafienie
        // TODO na przykład: właściwy kod 1234 - kod gracza 5511 - skrypt powinien
        // TODO pokazać 0 trafień na właściwym miejscu i 1 na niewłaściwym miejscu
    }

    private static void showHint(int[] gamerCodeState, int BOARD_SIZE) {

        int hitInPlace = 0;
        int hitNotInPlace = 0;

        for (int i = 0; i < BOARD_SIZE; i++) {
            if (gamerCodeState[i] == 2) {
                hitInPlace++;
            } else if (gamerCodeState[i] == 1) {
                hitNotInPlace++;
            }
        }

        System.out.println("Trafione na swoim miejscu: " + hitInPlace);
        System.out.println("Trafione nie na swoim miejscu: " + hitNotInPlace);

    }

    private static void fillCode(int[] secretCode) {
        Random rand = new Random();

        for (int i = 0; i < secretCode.length; i++) {
            secretCode[i] = rand.nextInt(6) + 1;
        }

        System.out.print("Sekretny kod: ");
        for (int j : secretCode) {
            System.out.print(j);
        }
        System.out.println();
    }

    public  int getInt() {
        return new Scanner(System.in).nextInt();
    }

    private void getCode(int code) {
        int[] gamerCode= new int[BOARD_SIZE];
        score++;

       // System.out.println("Podaj kod:");
       // int code = getInt();
        //System.out.println("code: " + code);

        boolean validCode = validation(code);
        String codeToString = String.valueOf(validCode);

        //System.out.println("codeToString: " + codeToString);

        for (int i = 0; i < BOARD_SIZE; i++) {
            char number = codeToString.charAt(i);
            gamerCode[i] = Character.getNumericValue(number);
        }

        //showGamerCode(gamerCode, BOARD_SIZE);

        engine(gamerCode);
    }

    private  boolean validation(int code) {
        String codeToString = String.valueOf(code);
        if (codeToString.length() < BOARD_SIZE) {
            System.out.println("Podałeś za krótki kod! Spróbuj jeszcze raz.");
            //getCode(secretCode, gamerCode, BOARD_SIZE, score);
            return false;
        } else if (codeToString.length() > BOARD_SIZE) {
            System.out.println("Podałeś za długi kod! Spróbuj jeszcze raz.");
            //getCode(secretCode, gamerCode, BOARD_SIZE, score);
            return false;
        }
        return true;

    }

    private void showGamerCode(int[] gamerCode, int BOARD_SIZE) {
        System.out.println("Kod gracza: ");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(gamerCode[i]);
        }
        System.out.println();
    }

    public Rersult validate(int i) {
        Rersult r = new Rersult();
        getCode(i);
        r.theEnd=..;
        return r;
    }
}
