package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * Created by i.riznychenko on 21.04.2017.
 */
public class Interf extends JFrame {
    private  JMenuBar barMenu;
    private JMenu mainMenu;
    private JMenuItem open, go, exit;
    public Interf(String title) throws HeadlessException {
        //super(title);
        this.setTitle(title);
        this.setBounds(200,200,500,400);
        this.createMenu();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
    }
    public void createMenu()
    {
        this.barMenu=new JMenuBar();
        this.setJMenuBar(barMenu);
        this.mainMenu=new JMenu("Меню");


        this.open=new JMenuItem("test");
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Interf.super.dispose();
            }
        });


        this.go=new JMenuItem("Открыть файл");
        go.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //JOptionPane.showMessageDialog(null,"My application");
                JOptionPane.showMessageDialog(null,"Error","E R R O R",JOptionPane.ERROR_MESSAGE);
            }
        }));
        mainMenu.add(go);
        mainMenu.addSeparator();
        this.exit=new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainMenu.add(exit);

        barMenu.add(mainMenu);

    }
}
