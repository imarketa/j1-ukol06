package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JTextField husyField;
    private JLabel husyLabel;
    private JTextField kraliciField;
    private JLabel kraliciLabel;
    private JTextField pocetNohouField;
    private JLabel pocetNohouLabel;
    private JTextField pocetHlavField;
    private JLabel pocetHlavLabel;

    private JButton vypocitatButton;

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
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání

        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciLabel);
        add(kraliciField);


        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');
        getRootPane().setDefaultButton(vypocitatButton);
        vypocitatButton.addActionListener(this::vypocitejButton);
        add(vypocitatButton, "span, center");


        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavField = new JTextField();
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEditable(false);
        pocetHlavField.setEnabled(true);
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavLabel);
        add(pocetHlavField);


        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouField = new JTextField();
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEditable(false);
        pocetNohouField.setEnabled(true);
        pocetNohouLabel.setLabelFor(pocetNohouField);
        add(pocetNohouLabel);
        add(pocetNohouField);


        pack();
    }

    private void vypocitejButton(ActionEvent actionEvent) {

        int pocetHlavKraliku = Integer.parseInt(kraliciField.getText());
        int pocetHlavHus = Integer.parseInt(husyField.getText());
        int pocetHlav = pocetHlavHus + pocetHlavKraliku;
        int pocetNohou = pocetHlavHus * 2 + pocetHlavKraliku * 4;

        pocetHlavField.setText(Integer.toString(pocetHlav));
        pocetNohouField.setText(Integer.toString(pocetNohou));
    }

}
