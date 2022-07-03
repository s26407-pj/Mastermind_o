public class Main {
    public static void main(String[] args) {

        Engine game = new Engine();
        Drawer draw = new Drawer();
        Result r = new Result();

        draw.intro();
        draw.showSecretCode(game.secretCode);

        do {
            game.getUserCode(r);
            //draw.showUserCode(game.gamerCode);
            if(r.theEnd) draw.showhint(r);
        } while (r.theEnd);

        draw.win();
    }
}
