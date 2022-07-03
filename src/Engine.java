import java.util.Random;
import java.util.Scanner;

public class Engine {

    int BOARD_SIZE = 4;
    int[] secretCode = new int[BOARD_SIZE];
    int[] gamerCode = new int[BOARD_SIZE];
    int[] secretCodeState = new int[BOARD_SIZE];
    int[] gamerCodeState = new int[BOARD_SIZE];
    int score;

    public Engine() {

        Random rand = new Random();

        for (int i = 0; i < secretCode.length; i++) {
            secretCode[i] = rand.nextInt(6) + 1;
        }
    }

    public static int getInt() {
        return new Scanner(System.in).nextInt();
    }

    public void getUserCode(Result r) {
        System.out.println("Podaj kod:");
        int code = getInt();

        String codeToString = String.valueOf(code);

        for (int i = 0; i < BOARD_SIZE; i++) {
            char number = codeToString.charAt(i);
            gamerCode[i] = Character.getNumericValue(number);
        }

        engine(r);
    }

    private void engine(Result r) {

        int win = 0;

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
            r.theEnd = false;
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
            r.theEnd = true;

            hint(r);
        }
    }

    private void hint(Result r) {

        r.hitInPlace = 0;
        r.hitNotInPlace = 0;

        for (int i = 0; i < BOARD_SIZE; i++) {
            if (gamerCodeState[i] == 2) {
                r.hitInPlace++;
            } else if (gamerCodeState[i] == 1) {
                r.hitNotInPlace++;
            }
        }
    }
}
