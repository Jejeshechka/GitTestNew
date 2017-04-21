package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Dmitriy on 21.04.2017.
 */
public class Alg {

    public static void main(String[] args) throws IOException {
        String searchWord = "ходил";
        FileInputStream fileInputStream = new FileInputStream(new File("D:/1.txt"));
        byte[] content = new byte[fileInputStream.available()];
        fileInputStream.read(content);
        fileInputStream.close();
        String[] lines = new String(content, "UTF-8").split("\n");
        int counter = 0;
        int i = 1;
        for (String line : lines) {
            String[] words = line.split(" ");
            int j = 1;
            for (String word : words) {
                if (word.equalsIgnoreCase(searchWord)) {
                    System.out.println("Найдено в " + i + "-й строке, " + j + "-е слово");

                    counter++;
                }
                j++;
            }
            i++;


        }

        System.out.println("Всего найдено слов: "+ counter);
    }
}


