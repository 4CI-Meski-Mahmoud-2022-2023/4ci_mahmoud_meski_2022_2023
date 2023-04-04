import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

 
public class CronometroView extends JFrame {
    private JLabel tempoLabel;
    private JButton startButton;
    private JButton pauseButton;
    private JButton stopButton;
 
    public CronometroView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 100);
 
        tempoLabel = new JLabel("0", JLabel.CENTER);
        tempoLabel.setFont(new Font("Arial", Font.BOLD, 30));
 
        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        stopButton = new JButton("Stop");
 
        JPanel panel = new JPanel();
        panel.add(tempoLabel);
        panel.add(startButton);
        panel.add(pauseButton);
        panel.add(stopButton);
 
        this.add(panel);
        this.setVisible(true);
    }
 
    public void setTempo(int tempo) {
        tempoLabel.setText(Integer.toString(tempo));
    }
 
    public void addStartListener(ActionListener startListener) {
        startButton.addActionListener(startListener);
    }
 
    public void addPauseListener(ActionListener pauseListener) {
        pauseButton.addActionListener(pauseListener);
    }
 
    public void addStopListener(ActionListener stopListener) {
        stopButton.addActionListener(stopListener);
    }

    public void reset() {
        tempoLabel.setText("0");
    }
}
