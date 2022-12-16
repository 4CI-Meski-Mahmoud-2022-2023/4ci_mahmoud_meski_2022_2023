import java.util.*;
public class LavatriceTest{
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        Lavatrice lava = new Lavatrice("samsung", "D-2022", 200.0);
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
    }
}
