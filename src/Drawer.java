public class Drawer {
    public void draw(Rersult r) {

        System.out.println("Trafione na swoim miejscu: " + r.hitInPlace);
        System.out.println("Trafione nie na swoim miejscu: " + hitNotInPlace);
    }

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
}
