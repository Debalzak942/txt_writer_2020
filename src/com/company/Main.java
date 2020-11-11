package com.company;

public class Main {

    private static final String FILENAME = "data.txt";

    public static void main(String[] args) {
        FileHelper fileHelper = new FileHelper(FILENAME);
        fileHelper.enterData(InputOutputHelper.inputData());        //add data to a file by reading from the console
        InputOutputHelper.outputData(fileHelper.readData());        //read data from file and output to the console
    }
}
