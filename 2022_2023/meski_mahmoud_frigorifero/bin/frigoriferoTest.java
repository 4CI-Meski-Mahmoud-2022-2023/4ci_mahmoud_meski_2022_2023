package packageFrigorifero;
import java.util.*;
public class frigoriferoTest{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        Frigorifero frigo = new Frigorifero("samsung", "f2000", 670.0);
        System.out.print("\n"+frigo.toString());
        //02
        frigo.accendi();
        System.out.print("\n" + frigo.toString());
        frigo.spegni();
        System.out.print("\n" + frigo.toString());
        //03
        frigo.setMarca("samsung");
        System.out.print("\n"+frigo.getMarca());
        //04
        frigo.setModello("D-2022");
        System.out.print("\n" + frigo.getModello());
        //05
        frigo.setLitriFrigo(300);
        System.out.print("\n"+frigo.getLitriFrigo());
        //06
        frigo.setLitriFrizer(50);
        System.out.print("\n"+frigo.getLitriFrizer());
        //07
        frigo.setPrezzo(670);
        System.out.print("\n"+frigo.getPrezzo());
        //08
        frigo.setConsumokwat(450);
        System.out.print("\n"+frigo.getConsumokwat());
        //09
        frigo.setTemperaturaFrigo(5);
        System.out.print("\n"+frigo.getTemperaturaFrigo());
        //10
        frigo.setTemperaturaFrizer(-19);
        System.out.print("\n"+frigo.getTemperaturaFrizer());
        
    }
}

