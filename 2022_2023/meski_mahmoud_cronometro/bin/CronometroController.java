import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CronometroController {
    private CronometroView view;
    private CronometroModel model;

    public CronometroController(CronometroView view, CronometroModel model) {
        this.view = view;
        this.model = model;

        // Aggiungi qui i listener ai bottoni della vista
        this.view.addStartListener(new StartListener());
        this.view.addPauseListener(new PauseListener());
        this.view.addStopListener(new StopListener());
    }

    // Listener per il pulsante "Start"
    class StartListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.start();
        }
    }

    // Listener per il pulsante "Pause"
    class PauseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.pause();
        }
    }

    // Listener per il pulsante "Stop"
    class StopListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.stop();
            view.reset();
        }
    }
}
