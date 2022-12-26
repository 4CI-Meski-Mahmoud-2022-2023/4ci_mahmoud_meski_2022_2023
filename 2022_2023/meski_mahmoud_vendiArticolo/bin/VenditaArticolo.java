import java.util.*;
public class VenditaArticolo{
    private Articolo articolo;
    public VenditaArticolo(){
        this.articolo = new Articolo();
    }
    
    public void start(){
        this.describeProgram();
        this.getInput();
        this.displayOutput();
    }
    
    public void describeProgram(){
        System.out.println("Il pogramma viene utilizzato per vendere un articolo");
    }
    
    public void getInput(){
        System.out.println("Inserire i dati dell'articolo");
        Scanner input = new Scanner(System.in);
        System.out.println("Inserire il nome dell'articolo");
        articolo.setNome(input.next());
        System.out.println("Inserire il prezzo dell'articolo");
        articolo.setPrezzo(input.nextDouble());
        System.out.println("Inserire il numero degli articoli");
        articolo.setQuantita(input.nextInt());
    }
    
    public void displayOutput(){
        System.out.println(articolo.getNome() + ", " + articolo.getPrezzo() + ", " + articolo.getQuantita());
    }
}//una vendita se non calcoli il prezzo a cosa serve?
