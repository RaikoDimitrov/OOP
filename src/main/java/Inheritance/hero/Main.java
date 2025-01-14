package Inheritance.hero;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("freddy123", 58);
        Elf elf = new Elf("elf123", 45);
        System.out.println(hero);
        System.out.println(elf);

        SoulMaster sm = new SoulMaster("sm123", 156);
        System.out.println(sm);
    }
}
