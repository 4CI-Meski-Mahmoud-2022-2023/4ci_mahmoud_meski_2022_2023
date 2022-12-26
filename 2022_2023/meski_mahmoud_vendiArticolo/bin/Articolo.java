public class Articolo{
    private String nome;
    private double prezzo;
    private int quantita;
    
    public Articolo(){
        this.nome ="anonimo ";
        this.prezzo = 0.0;
        this.quantita = 0;
    }
    // 
    
    public void setNome(String n){
        if(n!=null){
            this.nome = n;
        }/*else{
            this.nome = "anonimo";
        }*/
    }
    
    public void setPrezzo(double p){
        if(p>0.0){
            this.prezzo = p;
        }else{
            this.prezzo = 0.0;
        }
    }
    
    public void setQuantita(int q){
        if(q>0){
            this.quantita = q;
        }else{
            this.quantita = 0;
        }
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public double getPrezzo(){
        return this.prezzo;
    }
    
    public int getQuantita(){
        return this.quantita;
    }
}
