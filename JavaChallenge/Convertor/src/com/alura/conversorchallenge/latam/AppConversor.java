package com.alura.conversorchallenge.latam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppConversor extends JFrame{
    private JPanel panelMain;
    private JLabel panelHead;
    private JLabel panelConversor;
    private JButton btnExit;
    private JLabel labelNameCreator;
    private JButton btnCurrency;
    private JButton btnTemperature;

    public AppConversor() {
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnExit) {
                    System.exit(0);
                }
            }
        });
        btnCurrency.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnCurrency){
                    ExWindow exWindowApp = new ExWindow();

                }
            }
        });
        btnTemperature.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnTemperature){
                    TempWindow tempWindow = new TempWindow();
                }
            }
        });
    }

    public static void main (String[]args) {
        AppConversor appConversor = new AppConversor();
        appConversor.setContentPane(appConversor.panelMain);
        appConversor.setTitle("Oracle One Next Education");
        appConversor.setBounds(0, 0, 550, 350);
        appConversor.setIconImage(new ImageIcon("C:\\Users\\joseg\\Documents\\WorkSpace - Software Developer\\Conversor\\Images\\ExAppIcon.png").getImage());
        appConversor.setVisible(true);
        //appConversor.setLocationRelativeTo(null);
        appConversor.setResizable(false);
        appConversor.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

