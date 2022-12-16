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
    public String getModello(){
        return this.modello;
    }
    public void setModello(String mod){
        if(mod != null){
            this.modello = mod;
        }
    }
    //
    public int getProgramma(){
        return this.programma;
    }
    public void aumentaProgramma(){
        if(this.programma == 10){
            this.programma = 1;
        }else{
            this.programma++;
        }
    }
    public void diminuisciProgramma(){
        if(this.programma == 1){
            this.programma = 10;
        }else{
            this.programma--;
        }
    }
    public void setProgramma(int p){
        if(p > 0){
            this.programma = p;
        }
    }
    //
    public int getTemperatura(){
        return this.temperatura;
    }
    public void aumentaTemperatura(){
        if(this.temperatura == 120){
            this.temperatura = 30;
        }else{
            this.temperatura++;
        }
    }
    public void diminuisciTemperatura(){
        if(this.temperatura == 30){
            this.temperatura = 120;
        }else{
            this.temperatura--;
        }
    }
    public void setTemperatura(int t){
        if(t > 30 && t < 121){
            this.temperatura = t;
        }
    }
    //
    public double getPrezzo(){
        return this.prezzo;
    }
    public void setPrezzo(double p){
        if(p > -1){
            this.prezzo = p;
        }
    }
    //
    public int getGiri(){
        return this.giriCentrifuga;
    }
    public void aumentaGiri(){
        if(this.giriCentrifuga == 1000){
            this.giriCentrifuga = 200;
        }else{
            this.giriCentrifuga++;
        }
    }
    public void diminuisciGiri(){
        if(this.giriCentrifuga == 200){
            this.giriCentrifuga = 1000;
        }else{
            this.giriCentrifuga--;
        }
    }
    public void setGiri(int g){
        if(g > 199 && g < 1001){
            this.giriCentrifuga = g;
        }
    }
    //
    public int getKg(){
        return this.kg;
    }
    public void setKg(int kg){
        if(kg < 11){
            this.kg = kg;
        }
    }
    //
    public double getTempo(){
        return this.tempo;
    }
    public void aumentaTempo(){
        if(this.tempo == 60){
            this.tempo = 15;
        }else{
            this.tempo++;
        }
    }
    public void diminuisciTempo(){
        if(this.tempo == 15){
            this.tempo = 60;
        }else{
            this.tempo--;
        }
    }
    public void setTempo(double t){
        if(t > 14 && t < 61){
            this.tempo = t;
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