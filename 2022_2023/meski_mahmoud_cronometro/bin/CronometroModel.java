public class CronometroModel {
    private int tempo = 0;
    private boolean inEsecuzione = false;
 
    public void start() {
        inEsecuzione = true;
    }
 
    public void stop() {
        inEsecuzione = false;
        tempo = 0;
    }
 
    public void pause() {
        inEsecuzione = false;
    }
 
    public void increment() {
        if (inEsecuzione) {
            tempo++;
        }
    }
 
    public int getTempo() {
        return tempo;
    }
}
