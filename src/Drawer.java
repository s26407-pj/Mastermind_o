public class Drawer {

    public static void intro() {
        System.out.println();
        System.out.println("---- MASTERMIND ----");
        System.out.println();
        System.out.println("Zasady gry: Znajdź ukryty kod składający się z 4 cyfr");
        System.out.println("z zakresu od 1 do 6. Po każdej próbie dostaniesz informację");
        System.out.println("czy cyfra jest trafiona i czy jest na właściwym miejscu.");
        System.out.println("Powodzenia!");
        System.out.println();
    }

    public static void showSecretCode(int[] secretCode) {
        System.out.print("Sekretny kod: ");
        for (int i : secretCode) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void showUserCode(int[] gamerCode) {
        System.out.print("Kod gracza: ");
        for (int i : gamerCode) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void win() {
        System.out.println("Gratulacje! Udało Ci się odkryć sekretny kod!");
    }
/*
    public void hint(Rersult r) {
        System.out.println("Trafione na swoim miejscu: " + r.hitInPlace);
        System.out.println("Trafione nie na swoim miejscu: " + r.hitNotInPlace);
    }
*/
}
