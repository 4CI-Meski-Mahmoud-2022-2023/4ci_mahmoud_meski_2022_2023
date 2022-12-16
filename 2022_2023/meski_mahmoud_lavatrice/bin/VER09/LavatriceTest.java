import java.util.*;
public class LavatriceTest{
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        Lavatrice lava = new Lavatrice("samsung", "D-2022", 2.0);
        System.out.print(lava.toString());
        //
        lava.accendi();
        System.out.print("\n" + lava.toString());
        lava.spegni();
        System.out.print("\n" + lava.toString());
        //
        lava.setMarca("samsung");
        System.out.print("\n" + lava.getMarca());
        //
        lava.setModello("D-2022");
        System.out.print("\n" + lava.getModello());
        //
        lava.setProgramma(2);
        System.out.print("\n" + lava.getProgramma());
        lava.aumentaProgramma();
        System.out.print("\n" + lava.getProgramma());
        lava.diminuisciProgramma();
        System.out.print("\n" + lava.getProgramma());
        //
        lava.setTemperatura(56);
        System.out.print("\n" + lava.getTemperatura());
        lava.aumentaTemperatura();
        System.out.print("\n" + lava.getTemperatura());
        lava.diminuisciTemperatura();
        System.out.print("\n" + lava.getTemperatura());
        //
        lava.setPrezzo(200.0);
        System.out.print("\n" + lava.getPrezzo());
        //
        lava.setGiri(500);
        System.out.print("\n" + lava.getGiri());
        lava.aumentaGiri();
        System.out.print("\n" + lava.getGiri());
        lava.diminuisciGiri();
        System.out.print("\n" + lava.getGiri());
        //
        lava.setKg(6);
        System.out.print("\n" + lava.getKg());
    }
}
