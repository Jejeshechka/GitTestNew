package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello!");
        System.out.println("Git");
        System.out.println("Hello!");
        System.out.println("Dmitriy");
        System.out.println("Second attempt by Dmitriy");
        System.out.println(123);

        Interf inerf = new Interf("Поиск");
        inerf.createMenu();
        inerf.setVisible(true);
        inerf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}
