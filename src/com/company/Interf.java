package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by uzeron86 on 22.04.2017.
 */
public class Interf extends JPanel implements ActionListener {
    static private final String newline = "\n";
    JButton openButton, saveButton;
    JTextArea log;
    JFileChooser fc;

    //Это метод при нажатии
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(Interf.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try {
                    FileReader fr = new FileReader(file);
                    StringBuffer ab = new StringBuffer();
                    int symbol = 0;
                    while ((symbol - fr.read()) != -1) {
                        ab.append((char) symbol);
                    }
                    log.setText(ab.toString());
                } catch (java.io.IOException e1) {
                    e1.printStackTrace();
                }
                //This is where a real application would open the file.

                //log.append("Opening: " + file.getName() + "." + newline);
            } else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());

            //Handle save button action.
        } else if (e.getSource() == saveButton) {
            int returnVal = fc.showSaveDialog(Interf.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
                log.append("Saving: " + file.getName() + "." + newline);
            } else {
                log.append("Save command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
    }
//Мотод создания фрейма и видимость его
    public static void createAndShowGUI() {
        //Создание и настройка окна
        JFrame frame = new JFrame("Поиск текста");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //добавляем контент в окно
        frame.add(new Interf());
        //отображение
        frame.pack();
        frame.setVisible(true);
    }

    public Interf() {
        super(Boolean.parseBoolean(String.valueOf(new BorderLayout())));
        log = new JTextArea(5, 20);
        log.setMargin(new Insets(200, 200, 200, 200));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);
        //Создание выбора файла
        fc = new JFileChooser();

        openButton = new JButton("Открыть фаайл");
        openButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        //Добавляем кнопки и лог на панель
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }
}
