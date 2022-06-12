import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Engine e = new Engine();
        Drawer d = new Drawer();
        Rersult r;

        d.intro();

        do {
            int getCode = new Scanner(System.in).nextInt();
            r = e.validate(getCode);
            d.draw(r);
        }while (r.theEnd);
    }
}
