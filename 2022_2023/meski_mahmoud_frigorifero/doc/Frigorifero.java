package packageFrigorifero;
public class Frigorifero{
    private String marca;
    private String modello;
    private int litriFrigo;
    private int litriFrizer;
    private double prezzo;
    private boolean acceso;
    private double consumokwat;
    private int temperaturaFrigo;
    private int temperaturaFrizer;
    public Frigorifero(String m, String mod, double p){
        if (m!=null){
            this.marca=m;
        }else{
            this.marca="anonimo";
        }
        if (mod!=null){
            this.modello=mod;
        }else{
            this.modello="anonimo";
        }
        if (p>0){
            this.prezzo=p;
        }else{
            this.prezzo=0.0;
        }
        this.litriFrigo=0;
        this.litriFrizer=0;
        this.acceso=false;
        this.consumokwat=0.0;
        this.temperaturaFrigo=0;
        this.temperaturaFrizer=0;
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
        }else{
            this.marca="anonimo";
        }
    }
    //
    public String getModello(){
        return this.modello;
    }
    public void setModello(String mod){
        if(mod != null){
            this.modello = mod;
        }else{
            this.modello="anonimo";
        }
    }
    //
    public int getLitriFrigo(){
        return this.litriFrigo;
    }
    public void setLitriFrigo(int lFrig){
        if (lFrig < 300 || lFrig > 50){
            this.litriFrigo=lFrig;
        } else{
            this.litriFrigo=0;
        }
    }
    //
    public int getLitriFrizer(){
        return this.litriFrizer;
    }
    public void setLitriFrizer(int lFrizer){
        if (lFrizer < 70 || lFrizer > 5){
            this.litriFrizer=lFrizer;
        } else{
            this.litriFrizer=0;
        }
    }
    //
    public double getPrezzo(){
        return this.prezzo;
    }
    public void setPrezzo(double p){
        if (p > 50 || p < 1000){
            this.prezzo=p;
        }else{
            this.prezzo=0;
        }
    }
    //
    public double getConsumokwat(){
        return this.consumokwat;
    }
    public void setConsumokwat(double c){
        if (c > 100 || c < 600){
           this.consumokwat=c; 
        }else{
            this.consumokwat=0;
        }
    }
    //
    public int getTemperaturaFrigo(){
        return this.temperaturaFrigo;
    }
    public void setTemperaturaFrigo(int tFrig){
        if (tFrig >= 4 && tFrig <= 6){     
            this.temperaturaFrigo=tFrig;
        }else{
            this.temperaturaFrigo=0;
        }
    }
    //
    public int getTemperaturaFrizer(){
        return this.temperaturaFrizer;
    }
    public void setTemperaturaFrizer(int tFrizer){
        if (tFrizer >= -21 && tFrizer <= -18){     
            this.temperaturaFrizer=tFrizer;
        }else{
            this.temperaturaFrizer=0;
        }
    }
    //
    public String toString(){
        String out="";
        out+="la marca è: "+this.marca+"\n";
        out+="il modello è: "+this.modello+"\n";
        out+="i litri del frigo sono: "+this.litriFrigo+"\n";
        out+="i litri del frizer sono: "+this.litriFrizer+"\n";
        out+="il prezzo è: "+this.prezzo+"\n";
        if (this.acceso){
            out+="è accesa\n";
        }else{
            out+="è spenta\n";
        }
        out+="il consumo è: "+this.consumokwat+"\n";
        out+="la temperatura del frigo è: "+this.temperaturaFrigo+"\n";
        out+="la temperatura del frizer è: "+this.temperaturaFrizer+"\n";
        return out;
    }
}
