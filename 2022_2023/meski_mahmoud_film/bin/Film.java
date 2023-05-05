public class Film {

    private String titolo;
    private String regista;
    private String durata;

    public Film(String titolo, String regista, String durata) {
        this.titolo = titolo;
        this.regista = regista;
        this.durata = durata;
    }

    public Film() {
        this.titolo = "anonimo";
        this.regista = "anonimo";
        this.durata = "anonimo";
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        if(titolo!=null) this.titolo = titolo;
    }

    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        if(regista!=null) this.regista = regista;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        if(durata!=null) this.durata = durata;
    }

    @Override
    public String toString() {
        return "Film {" + "titolo=" + titolo + ", regista=" + regista + ", durata=" + durata + '}';
    }

}