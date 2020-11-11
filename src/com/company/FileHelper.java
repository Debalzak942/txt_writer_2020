package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHelper {
    private final File file;
    private static final String DIVIDER = " ";

    public FileHelper(String fileName) {
        this.file = new File(fileName);
    }

    /**
     * Write and save data into file
     *
     * @param data entered data from console
     */
    public void enterData(List<String> data) {
        List<String> formattedData = formatData(data);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String item : formattedData) {
                bufferedWriter.write(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read data from file
     *
     * @return read out data from file
     */
    public List<String> readData() {
        List<String> readedData = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] dividedData = line.split(DIVIDER);      //separate data and add to array of strings
                readedData = Arrays.asList(dividedData);         //assign separated array to list readedData
            }
        } catch (IOException e) {
            System.out.println("Файл не найден");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return readedData;
    }

    /**
     * Added divider to elements of list
     *
     * @param data entered data without divider
     * @return formatted data with divider
     */
    private List<String> formatData(List<String> data) {
        List<String> formattedData = new ArrayList<>();
        for (int i = 0; i <= data.size() - 1; i++) {
            String formattedString = data.get(i).concat(DIVIDER);
            formattedData.add(formattedString);
        }
        return formattedData;
    }
}
