import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Engine game = new Engine();
        Drawer draw = new Drawer();

        draw.intro();
        draw.showSecretCode(game.secretCode);

        do {
            game.getUserCode(r);
            //draw.showUserCode(game.gamerCode);
        } while (r.theEnd);

        if (r.theEnd) draw.win();
    }
}
