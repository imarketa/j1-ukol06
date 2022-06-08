package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JLabel husyLabel;
    private JSpinner husyField;
    private JLabel kraliciLabel;
    private JSpinner kraliciField;

    private SpinnerNumberModel kraliciSpinnerModel;
    private SpinnerNumberModel husySpinnerModel;

    private JLabel pocetHlavLabel;
    private JTextField pocetHlavField;
    private JLabel pocetNohouLabel;
    private JTextField pocetNohouField;

    private JButton vypocitatButton;
    private Object actionEvent;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(270, 220));

        //TODO implementovat formulář podle zadání

        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        husySpinnerModel = new SpinnerNumberModel(0, 0, null, 1);
        husyField = new JSpinner(husySpinnerModel);
        add(husyLabel);
        add(husyField);

        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        kraliciSpinnerModel = new SpinnerNumberModel(0, 0, null, 1);
        kraliciField = new JSpinner(kraliciSpinnerModel);
        add(kraliciLabel);
        add(kraliciField);

        vypocitatButton = new JButton("Vypocitat");
        vypocitatButton.setMnemonic('V');
        add(vypocitatButton,"center, span");
        vypocitatButton.addActionListener(this::vypocitatButton);

        add(createButtonBar(), "span");

        pocetHlavField = new JTextField();
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEditable(false);
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavLabel);
        add(pocetHlavField);

        pocetNohouField = new JTextField();
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEditable(false);
        pocetHlavField.isEnabled();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setLabelFor(pocetNohouField);
        add(pocetNohouLabel);
        add(pocetNohouField);


        pack();
    }

    private void vypocitatButton(ActionEvent actionEvent) {
        int pocetHlavKraliku = (Integer) kraliciField.getValue();
        int pocetHlavHus = (Integer) husyField.getValue();

        int pocetHlav = pocetHlavHus + pocetHlavKraliku;
        int pocetNohou = pocetHlavHus * 2 + pocetHlavKraliku * 4;

        pocetHlavField.setText(Integer.toString(pocetHlav));
        pocetNohouField.setText(Integer.toString(pocetNohou));
    }

    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");
        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(vypocitatButton);
        return buttonBar;
    }
    }
