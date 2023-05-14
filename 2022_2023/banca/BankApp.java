import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankApp extends JFrame {
    private Banca banca;
    private JTextField nomeField;
    private JTextField cognomeField;
    private JTextField importoField;
    private JComboBox<ContoCorrente> saldoComboBox;
    private static JTextArea saldoTextArea;
    private JComboBox<ContoCorrente> depositoComboBox;
    private JTextField importoDaDepositoField;
    private JComboBox<ContoCorrente> prelievoComboBox;
    private JTextField importoDaPrelievoField;
    private JComboBox<ContoCorrente> contoOrigineComboBox = new JComboBox<ContoCorrente>();
    JComboBox<ContoCorrente> contoDestinazioneComboBox = new JComboBox<ContoCorrente>();
    private JComboBox<ContoCorrente> trasferimentoDaComboBox;
    private JComboBox<ContoCorrente> trasferimentoAComboBox;
    private JTextField importoTrasferimentoField;

    public BankApp() {

        banca = new Banca("Banca di Meski");
        banca.aggiungiContoCorrente(new ContoCorrente("Mario", "Rossi", 1000));
        banca.aggiungiContoCorrente(new ContoCorrente("Luigi", "Bianchi", 2000));
        banca.aggiungiContoCorrente(new ContoCorrente("Carlo", "Verdi", 3000));
        
        setTitle("Gestione Conti Correnti");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);

        JPanel aperturaContoPanel = new JPanel();
        aperturaContoPanel.setLayout(new GridLayout(4, 2));
        aperturaContoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        tabbedPane.addTab("Apertura Conto Corrente", aperturaContoPanel);

        JLabel nomeLabel = new JLabel("Nome");
        aperturaContoPanel.add(nomeLabel);
        nomeField = new JTextField();
        aperturaContoPanel.add(nomeField);

        JLabel cognomeLabel = new JLabel("Cognome");
        aperturaContoPanel.add(cognomeLabel);
        cognomeField = new JTextField();
        aperturaContoPanel.add(cognomeField);

        JLabel importoLabel = new JLabel("Importo iniziale");
        aperturaContoPanel.add(importoLabel);
        importoField = new JTextField();
        aperturaContoPanel.add(importoField);

        JButton apriContoButton = new JButton("Apri Conto");
        apriContoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String cognome = cognomeField.getText();
                double importo = Double.parseDouble(importoField.getText());
                ContoCorrente contoCorrente = new ContoCorrente(nome, cognome, importo);
                banca.aggiungiContoCorrente(contoCorrente);
                saldoComboBox.addItem(contoCorrente);
                depositoComboBox.addItem(contoCorrente);
                prelievoComboBox.addItem(contoCorrente);
                trasferimentoDaComboBox.addItem(contoCorrente);
                trasferimentoAComboBox.addItem(contoCorrente);
                JOptionPane.showMessageDialog(null, "Conto corrente aperto con successo!");
                }
                });
                aperturaContoPanel.add(apriContoButton);
                JPanel saldoPanel = new JPanel();
                saldoPanel.setLayout(new BorderLayout());
                saldoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                tabbedPane.addTab("Visualizza Saldo", saldoPanel);
            
                JPanel saldoComboBoxPanel = new JPanel();
                saldoComboBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                JLabel saldoComboBoxLabel = new JLabel("Seleziona il conto corrente:");
                saldoComboBoxPanel.add(saldoComboBoxLabel);
                saldoComboBox = new JComboBox<ContoCorrente>();
                for (ContoCorrente conto : banca.getContiCorrenti()) {
                    saldoComboBox.addItem(conto);
                }
                saldoComboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ContoCorrente contoCorrente = (ContoCorrente) saldoComboBox.getSelectedItem();
                        saldoTextArea.setText("Il saldo del conto corrente di " + contoCorrente.getNomeTitolare() + " " + contoCorrente.getCognomeTitolare() + " è di " + contoCorrente.getSaldo() + " euro.");
                    }
                });
            saldoComboBoxPanel.add(saldoComboBox);
            saldoPanel.add(saldoComboBoxPanel, BorderLayout.NORTH);
        
            JPanel saldoTextAreaPanel = new JPanel();
            saldoTextAreaPanel.setLayout(new BorderLayout());
            saldoTextAreaPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            saldoTextArea = new JTextArea();
            saldoTextArea.setEditable(false);
            saldoTextAreaPanel.add(saldoTextArea, BorderLayout.CENTER);
            saldoPanel.add(saldoTextAreaPanel, BorderLayout.CENTER);
            
            JPanel depositoPanel = new JPanel();
            depositoPanel.setLayout(new BorderLayout());
                depositoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                tabbedPane.addTab("Effettua Deposito", depositoPanel);
            
                JPanel depositoComboBoxPanel = new JPanel();
                depositoComboBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                JLabel depositoComboBoxLabel = new JLabel("Seleziona il conto corrente:");
                depositoComboBoxPanel.add(depositoComboBoxLabel);
                depositoComboBox = new JComboBox<ContoCorrente>();
                for (ContoCorrente conto : banca.getContiCorrenti()) {
                    depositoComboBox.addItem(conto);
                }
                depositoComboBoxPanel.add(depositoComboBox);
                depositoPanel.add(depositoComboBoxPanel, BorderLayout.NORTH);
            
                JPanel importoDaDepositoPanel = new JPanel();
                importoDaDepositoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                JLabel importoDaDepositoLabel = new JLabel("Importo da depositare:");
                importoDaDepositoPanel.add(importoDaDepositoLabel);
                importoDaDepositoField = new JTextField(10);
                importoDaDepositoPanel.add(importoDaDepositoField);
                depositoPanel.add(importoDaDepositoPanel, BorderLayout.CENTER);
                JButton effettuaDepositoButton = new JButton("Effettua Deposito");
        effettuaDepositoButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        ContoCorrente contoCorrente = (ContoCorrente) depositoComboBox.getSelectedItem();
        double importoDaDeposito = Double.parseDouble(importoDaDepositoField.getText());
        contoCorrente.deposita(importoDaDeposito);
        saldoTextArea.setText("Il saldo del conto corrente di " + contoCorrente.getNomeTitolare() + " " + contoCorrente.getCognomeTitolare() + " è di " + contoCorrente.getSaldo() + " euro.");
        importoDaDepositoField.setText("");
    }
});
    JPanel effettuaDepositoButtonPanel = new JPanel();
    effettuaDepositoButtonPanel.add(effettuaDepositoButton);
    depositoPanel.add(effettuaDepositoButtonPanel, BorderLayout.SOUTH);

    JPanel prelievoPanel = new JPanel();
    prelievoPanel.setLayout(new BorderLayout());
    prelievoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    tabbedPane.addTab("Effettua Prelievo", prelievoPanel);

    JPanel prelievoComboBoxPanel = new JPanel();
    prelievoComboBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    JLabel prelievoComboBoxLabel = new JLabel("Seleziona il conto corrente:");
    prelievoComboBoxPanel.add(prelievoComboBoxLabel);
    prelievoComboBox = new JComboBox<ContoCorrente>();
    for (ContoCorrente conto : banca.getContiCorrenti()) {
        prelievoComboBox.addItem(conto);
    }
    prelievoComboBoxPanel.add(prelievoComboBox);
    prelievoPanel.add(prelievoComboBoxPanel, BorderLayout.NORTH);

    JPanel importoDaPrelievoPanel = new JPanel();
    importoDaPrelievoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    JLabel importoDaPrelievoLabel = new JLabel("Importo da prelevare:");
    importoDaPrelievoPanel.add(importoDaPrelievoLabel);
    importoDaPrelievoField = new JTextField(10);
    importoDaPrelievoPanel.add(importoDaPrelievoField);
    prelievoPanel.add(importoDaPrelievoPanel, BorderLayout.CENTER);

    JButton effettuaPrelievoButton = new JButton("Effettua Prelievo");
    effettuaPrelievoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
            ContoCorrente contoCorrente = (ContoCorrente) prelievoComboBox.getSelectedItem();
            double importoDaPrelievo = Double.parseDouble(importoDaPrelievoField.getText());
            try {
                contoCorrente.preleva(importoDaPrelievo);
                saldoTextArea.setText("Il saldo del conto corrente di " + contoCorrente.getNomeTitolare() + " " + contoCorrente.getCognomeTitolare() + " è di " + contoCorrente.getSaldo() + " euro.");
                importoDaPrelievoField.setText("");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
    JPanel effettuaPrelievoButtonPanel = new JPanel();
    effettuaPrelievoButtonPanel.add(effettuaPrelievoButton);
    prelievoPanel.add(effettuaPrelievoButtonPanel, BorderLayout.SOUTH);

    JPanel trasferimentoPanel = new JPanel();
    trasferimentoPanel.setLayout(new BorderLayout());
    trasferimentoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    tabbedPane.addTab("Effettua Trasferimento", trasferimentoPanel);

    JPanel contoOriginePanel = new JPanel();
    contoOriginePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    JLabel contoOrigineLabel = new JLabel("Seleziona il conto corrente di origine:");
    contoOriginePanel.add(contoOrigineLabel);
    contoOrigineComboBox = new JComboBox<ContoCorrente>();
    for (ContoCorrente conto : banca.getContiCorrenti()) {
    contoOrigineComboBox.addItem(conto);
    }
    contoOriginePanel.add(contoOrigineComboBox);
    trasferimentoPanel.add(contoOriginePanel, BorderLayout.NORTH);

    JPanel contoDestinazionePanel = new JPanel();
    contoDestinazionePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    JLabel contoDestinazioneLabel = new JLabel("Seleziona il conto corrente di destinazione:");
    contoDestinazionePanel.add(contoDestinazioneLabel);
    contoDestinazioneComboBox = new JComboBox<ContoCorrente>();
    for (ContoCorrente conto : banca.getContiCorrenti()) {
    contoDestinazioneComboBox.addItem(conto);
    }
    contoDestinazionePanel.add(contoDestinazioneComboBox);
    trasferimentoPanel.add(contoDestinazionePanel, BorderLayout.CENTER);

    JPanel importoTrasferimentoPanel = new JPanel();
    importoTrasferimentoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    JLabel importoTrasferimentoLabel = new JLabel("Importo da trasferire:");
    importoTrasferimentoPanel.add(importoTrasferimentoLabel);
    importoTrasferimentoField = new JTextField(10);
    importoTrasferimentoPanel.add(importoTrasferimentoField);
    trasferimentoPanel.add(importoTrasferimentoPanel, BorderLayout.SOUTH);

    JButton effettuaTrasferimentoButton = new JButton("Effettua Trasferimento");
    effettuaTrasferimentoButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
        ContoCorrente contoOrigine = (ContoCorrente) contoOrigineComboBox.getSelectedItem();
        ContoCorrente contoDestinazione = (ContoCorrente) contoDestinazioneComboBox.getSelectedItem();
        double importoTrasferimento = Double.parseDouble(importoTrasferimentoField.getText());
    try {
        contoOrigine.trasferisci(importoTrasferimento, contoDestinazione);
        saldoTextArea.setText("Il saldo del conto corrente di " + contoOrigine.getNomeTitolare() + " " + contoOrigine.getCognomeTitolare() + " è di " + contoOrigine.getSaldo() + " euro.");
        importoTrasferimentoField.setText("");
    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
    });
        JPanel effettuaTrasferimentoButtonPanel = new JPanel();
        effettuaTrasferimentoButtonPanel.add(effettuaTrasferimentoButton);
        trasferimentoPanel.add(effettuaTrasferimentoButtonPanel, BorderLayout.PAGE_END);
}
}
        