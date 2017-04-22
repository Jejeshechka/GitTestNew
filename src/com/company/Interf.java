package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;

/**
 * Created by uzeron86 on 22.04.2017.
 */
public class Interf extends JPanel implements ActionListener {
    static private final String newline = "\n";
    JButton openButton;
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
                    StringBuilder sb = new StringBuilder();
                    char[] cbuf = new char[1024];
                    int r;
                    while ((r = fr.read(cbuf, 0, 1024)) != -1) {
                        sb.append(cbuf, 0, r);
                    }
                    String s = sb.toString();

                    for (int i = 0; i < s.length(); ) {
                        int cp = s.codePointAt(i); // Unicode code point
                        i += Character.charCount(cp);
                    }
                    log.setText(s);
                } catch (java.io.IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());

        } else {
            log.append("Save command cancelled by user." + newline);
        }
        log.setCaretPosition(log.getDocument().getLength());
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
