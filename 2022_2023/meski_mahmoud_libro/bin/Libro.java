public class Libro {
    private String titolo;
    private String autore;
    private int numPagine;
    public Libro() {
        this.titolo = "anonimo";
        this.autore = "anonimo";
        this.numPagine = 0;
    }
    public Libro(String titolo, String autore, int numPagine) {
        if(titolo!=null){
            this.titolo = titolo;  
        }else{
            this.titolo="anonimo";
        }
        if(autore!=null){
            this.autore = autore;
        }else{
            this.autore="anonimo";
        }
        if(numPagine>=0){
            this.numPagine = numPagine;
        }else{
            this.numPagine=0;
        }
    }
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        if(titolo!=null){
           this.titolo = titolo;
        }
    }
    public String getAutore() {
        return this.autore;
    }
    public void setAutore(String autore) {
        if(autore!=null){
            this.autore = autore;
        }
    }
    public int getNumPagine() {
        return numPagine;
    }
    public void setNumPagine(int numPagine) {
        if(numPagine>=0){
           this.numPagine = numPagine;
        }
    }
    @Override
    public String toString() {
        return "Libro {titolo= " + this.titolo + ", autore= " + this.autore+
        ", numPagine= " + this.numPagine + "}";
    }
}