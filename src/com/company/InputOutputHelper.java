package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputOutputHelper {

    private static final String STOPPER = "exit";

    /**
     * Add data in console
     *
     * @return entered data from console
     */
    public static List<String> inputData() {
        System.out.println("Для прекращения ввода напишите 'exit'");
        System.out.println("Введите текст:");
        List<String> enteredData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while (!(line = reader.readLine()).equals(STOPPER)) {
                enteredData.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return enteredData;
    }

    public static void outputData(List<String> data) {
        for (String item : data) {
            System.out.printf("%s ", item);
        }
    }
}
