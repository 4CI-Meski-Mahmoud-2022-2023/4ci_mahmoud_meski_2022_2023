import java.util.*;
public class Lavatrice{
    private String marca;
    private String modello;
    private int programma;
    private int temperatura;
    private double prezzo;
    private int giriCentrifuga;
    private int kg;
    private boolean acceso;
    private double tempo;
    
    public Lavatrice (String m, String mod, double p){
        if (m!=null){
            this.marca = m;
        }else{
            this.marca = "anonimo";
        }
        if (mod!=null){
            this.modello = mod;
        }else{
            this.modello = "anonimo";
        }
        if (p < 0.0){
            this.prezzo = 0.0;
        }else{
            this.prezzo = p;
        }
        this.programma = 0;
        this.temperatura = 0;
        this.giriCentrifuga = 0;
        this.kg = 0;
        this.acceso = false;
        this.tempo = 0.0;
    }
    //
    public void accendi(){
        this.acceso = true;
    }
    public void spegni(){
        this.acceso = false;
    }
    //
      public String getMarca(){
        return this.marca;
    }
    public void setMarca(String m){
        if(m != null){
            this.marca = m;
        }
    }
    //
    public String toString(){
        String out = "Marca: " + this.marca + "\n";
        out += "Modello: " + this.modello + "\n";
        out += "Programma: " + this.programma + "\n";
        out += "Temperatura: " + this.temperatura + "\n";
        out += "Prezzo: " + this.prezzo + "\n";
        out += "Giri centrifuga: " + this.giriCentrifuga + "\n";
        out += "Kg: " + this.kg + "\n";
        if(acceso){
            out += "è accesa" + "\n";
        }else{
            out += "è spenta" + "\n";
        }
        out += "Tempo: " + this.tempo + "\n";
        return out;
    }
}