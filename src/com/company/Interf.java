package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;


/**
 * Created by i.riznychenko on 21.04.2017.
 */
public class Interf extends JPanel implements ActionListener {
    static private final String newline = "\n";
    JButton openButton, saveButton;
    JTextArea log;
    JFileChooser fc;

    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(Interf.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                log.append("Opening: " + file.getName() + "." + newline);
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

    /** Returns an ImageIcon, or null if the path was invalid. */
    /*protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Interf.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }*/

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Поиск текста");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new Interf());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


    public Interf() {
        super(Boolean.parseBoolean(String.valueOf(new BorderLayout())));

        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5, 20);
        log.setMargin(new Insets(200, 200, 200, 200));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //Create a file chooser
        fc = new JFileChooser();

        openButton = new JButton("Открыть фаайл");
        openButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);


        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }
}

    /*private  JMenuBar barMenu;
    private JMenu mainMenu;
    private JMenuItem open, go, exit;
    final JFileChooser fc = new JFileChooser();


    public Interf(String title) throws HeadlessException {
        //super(title);
        this.setTitle(title);
        this.setBounds(200,200,500,400);
        this.createMenu();
        JTextArea log;
        JFileChooser fc;
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
                //JOptionPane.showMessageDialog(null,"Error","E R R O R",JOptionPane.ERROR_MESSAGE);
                if (e.getSource() == go) {
                    int returnVal = fc.showOpenDialog(Interf.this);

                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = fc.getSelectedFile();
                        //This is where a real application would open the file.
                        log.append("Opening: " + file.getName() + "." + newline);
                    } else {
                        log.append("Open command cancelled by user." + newline);
                    }
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
*/