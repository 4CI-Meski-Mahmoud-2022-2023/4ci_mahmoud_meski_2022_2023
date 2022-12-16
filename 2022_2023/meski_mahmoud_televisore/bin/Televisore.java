
/**
 * Aggiungi qui una descrizione della classe Televisore
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
import java.util.*;
public class Televisore{
    private int pollici;
    private String schermo;
    private String colore;
    private int canale;
    private int volume;
    private int luminosità;
    private boolean acceso;
    public Televisore(int pollici, String schermo, String colore){
        if(pollici>3){
            this.pollici=pollici;
        }
        if(schermo!=null){
            this.schermo=schermo;
        }
        if(colore!=null){
            this.colore=colore;
        }
    }
    public void accendi(){
        this.acceso=true;
    }
    public void spegni(){
        this.acceso=false;
    }
    public int getPollici(){
        return this.pollici;
    }
    private void setPollici(int p){
        if(p>0){
            this.pollici=pollici;
        }
    }
    public String getSchermo(){
        return this.schermo;
    }
    private void setSchermo(String s){
        if(s!=null){
            this.schermo=s;
        }
    }
    public String getColore(){
        return this.colore;
    }
    private void setColore(String color){
        if(color!=null){
            this.colore=colore;
        }
    }
    public int getCanale(){
        return this.canale;
    }
    public void setCanale(int c){
        if(c>0 || c<200){
            this.canale=c;
        }
    }
    public void aumentaCanale(){
        this.canale++;
    }
    public void diminuisciCanale(){
        this.canale--;
    }
    public void aumentaVolume(){
        this.volume++;
    }
    public void diminuisciVolume(){
        this.volume--;
    }
    public int getLuminos(){
        return this.luminosità;
    }
    public void aumentaLuminos(){
        this.luminosità++;
    }
    public void diminuisciLuminos(){
        this.luminosità--;
    }
    public String toString(){
        String out="";
        
        return out;
    }
}
