package com.company;

import javax.swing.*;

import static com.company.Interf.createAndShowGUI;

public class Main {

    public static void main(String[] args) {
	// write your code here
               SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }


    }

