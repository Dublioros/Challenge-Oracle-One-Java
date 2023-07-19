package com.alura.conversorchallenge.latam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.Objects;

public class TempWindow extends JFrame implements ActionListener, ItemListener{
        JFrame frameTemp = new JFrame();
        private JButton buttonConvertTemp;
        private JButton buttonExit;
        private JComboBox<String> comboTemp;
        private JLabel jLabelResultTemp;
        private JTextField textFieldDegrees;

        public TempWindow() {
            initComponents();
            frameTemp.setTitle("Alura Conversor Challenge");
            frameTemp.setIconImage(new ImageIcon("C:\\Users\\joseg\\Documents\\WorkSpace - Software Developer\\Conversor\\Images\\ExAppIcon.png").getImage());
            frameTemp.setBounds(0,0,550,350);
            frameTemp.setLayout(null);
            frameTemp.setResizable(false);
            frameTemp.setVisible(true);
            this.setLocationRelativeTo(null);
            frameTemp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        private void initComponents() {
            JLabel labelConvertTemp = new JLabel("Temperature Convert");
            labelConvertTemp.setBounds(200, 40, 150, 20);
            frameTemp.add(labelConvertTemp);

            JLabel labelDegrees = new JLabel("Degrees");
            labelDegrees.setBounds(235, 80, 150, 20);
            frameTemp.add(labelDegrees);

            textFieldDegrees = new JTextField();
            textFieldDegrees.setBounds(210, 100, 100, 20);
            frameTemp.add(textFieldDegrees);

            JLabel labelTemp = new JLabel("Temperature");
            labelTemp.setBounds(230, 120, 150, 20);
            frameTemp.add(labelTemp);

            String[] temperature = {"Celsius to Fahrenheit", "Fahrenheit to Celsius"};
            comboTemp = new JComboBox<>(temperature);
            comboTemp.setBounds(160, 140, 210, 20);
            frameTemp.add(comboTemp);

            buttonConvertTemp = new JButton("Convert");
            buttonConvertTemp.setBounds(220, 170, 80, 25);
            frameTemp.add(buttonConvertTemp);
            buttonConvertTemp.addActionListener((ActionListener) this);

            jLabelResultTemp = new JLabel();
            jLabelResultTemp.setBounds(245, 190, 80, 20);
            frameTemp.add(jLabelResultTemp);

            buttonExit = new JButton("Back");
            buttonExit.setBounds(220, 220, 80, 25);
            frameTemp.add(buttonExit);
            buttonExit.addActionListener((ActionListener) this);
        }

        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == comboTemp && e.getStateChange() == ItemEvent.SELECTED) {
                String selection = Objects.requireNonNull(comboTemp.getSelectedItem()).toString();
                setTitle(selection);
            }
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonExit) {
                frameTemp.setVisible(false);
            }

            if (e.getSource() == buttonConvertTemp){
                String inputTextD = textFieldDegrees.getText();
                if (inputTextD.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter a temperature to convert.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    double temperature = Double.parseDouble(inputTextD);
                    String convert = Objects.requireNonNull(comboTemp.getSelectedItem()).toString();
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    double resultTemp = 0;
                    switch (convert) {
                        case "Celsius to Fahrenheit" -> {
                            resultTemp = temperature * 9 / 5 + 32;
                            jLabelResultTemp.setText(decimalFormat.format(resultTemp) + " °F");
                        }
                        case "Fahrenheit to Celsius" -> {
                            resultTemp = (temperature - 32) * 5 / 9;
                            jLabelResultTemp.setText(decimalFormat.format(resultTemp) + " °C");
                        }
                        default -> jLabelResultTemp.setText("");
                    };

                    jLabelResultTemp.setText(decimalFormat.format(resultTemp));
                    JOptionPane.showMessageDialog(this,"Temperature: " + decimalFormat.format(resultTemp), "Confirmation", JOptionPane.INFORMATION_MESSAGE  );
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid amount entered", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
}
