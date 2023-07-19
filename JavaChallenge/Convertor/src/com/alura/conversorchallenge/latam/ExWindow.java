package com.alura.conversorchallenge.latam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.Objects;

public class ExWindow extends JFrame implements ActionListener, ItemListener {

    JFrame frameEx = new JFrame();
    private JButton buttonConvert;
    private JButton buttonBack;
    private JComboBox<String> comboExchange;
    private JLabel jLabelResult;
    private JTextField textFieldAmount;

    private static final double USD_RATE = 0.28;
    private static final double EUR_RATE = 0.25;
    private static final double GBP_RATE = 0.21;
    private static final double JPY_RATE = 38.90;
    private static final double KRW_RATE = 356.00;

    public ExWindow() {
        initComponents();
        frameEx.setTitle("Alura Conversor Challenge");
        frameEx.setIconImage(new ImageIcon("C:\\Users\\joseg\\Documents\\WorkSpace - Software Developer\\Conversor\\Images\\ExAppIcon.png").getImage());
        frameEx.setLocationRelativeTo(null);
        frameEx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameEx.setBounds(0,0,550,350);
        frameEx.setLayout(null);
        frameEx.setResizable(false);
        frameEx.setVisible(true);
    }

    private void initComponents() {
        JLabel labelTitle = new JLabel("Currency Exchange");
        labelTitle.setBounds(200, 40, 150, 20);
        frameEx.add(labelTitle);

        JLabel labelAmount = new JLabel("Amount");
        labelAmount.setBounds(235, 80, 150, 20);
        frameEx.add(labelAmount);

        textFieldAmount = new JTextField();
        textFieldAmount.setBounds(210, 100, 100, 20);
        frameEx.add(textFieldAmount);


        JLabel labelCurrency = new JLabel("Currency");
        labelCurrency.setBounds(230, 120, 150, 20);
        frameEx.add(labelCurrency);

        String[] currencies = {"PEN to USD - US Dollar", "PEN to EUR - Euro"
                , "PEN to GBP - British Pound", "PEN to JPY - Japanese Yen"
                , "PEN to KRW - South Korean Won", "USD to PEN - Nuevos Soles",
                "EUR to PEN - Nuevos Soles", "GBP - to PEN - Nuevos Soles",
                "JPY to to PEN - Nuevos Soles"};
        comboExchange = new JComboBox<>(currencies);
        comboExchange.setBounds(160, 140, 210, 20);
        frameEx.add(comboExchange);

        buttonConvert = new JButton("Convert");
        buttonConvert.setBounds(220, 170, 80, 25);
        frameEx.add(buttonConvert);
        buttonConvert.addActionListener((ActionListener) this);

        jLabelResult = new JLabel();
        jLabelResult.setBounds(245, 190, 80, 20);
        frameEx.add(jLabelResult);

        buttonBack = new JButton("Back");
        buttonBack.setBounds(220, 220, 80, 25);
        frameEx.add(buttonBack);
        buttonBack.addActionListener((ActionListener) this);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboExchange && e.getStateChange() == ItemEvent.SELECTED) {
            String selection = Objects.requireNonNull(comboExchange.getSelectedItem()).toString();
            setTitle(selection);
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonBack) {
            frameEx.setVisible(false);
        }
        if (e.getSource() == buttonConvert) {
            String inputText = textFieldAmount.getText();
            if (inputText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter an amount to convert.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            try {
                double amount = Double.parseDouble(inputText);
                double result = switch (comboExchange.getSelectedIndex()) {
                    case 0 -> amount * USD_RATE;
                    case 1 -> amount * EUR_RATE;
                    case 2 -> amount * GBP_RATE;
                    case 3 -> amount * JPY_RATE;
                    case 4 -> amount * KRW_RATE;
                    case 5 -> amount / USD_RATE;
                    case 6 -> amount / EUR_RATE;
                    case 7 -> amount / GBP_RATE;
                    case 8 -> amount /JPY_RATE;
                    case 9 -> amount / KRW_RATE;
                    default -> 0.0;
                };
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                jLabelResult.setText(decimalFormat.format(result));
                JOptionPane.showMessageDialog(this,"Current cash: " + decimalFormat.format(result), "Confirmation", JOptionPane.INFORMATION_MESSAGE  );
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount entered", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

