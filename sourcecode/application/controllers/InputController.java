package application.controllers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class InputController {
	   private void generateRandomArray() {
        Random rand = new Random();
        int n = rand.nextInt(10) + 5; // Array size between 5 and 14
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(100); // Random numbers between 0 and 99
        }
        arrayInput.setText(Arrays.toString(array));
        outputArea.setText("Generated Random Array: \n" + Arrays.toString(array));
    }

    // Method to input array manually
    private void inputArray() {
        try {
            String input = arrayInput.getText();
            String[] inputValues = input.replaceAll("[\\[\\] ]", "").split(",");
            array = new int[inputValues.length];
            for (int i = 0; i < inputValues.length; i++) {
                array[i] = Integer.parseInt(inputValues[i].trim());
            }
            outputArea.setText("Input Array: \n" + Arrays.toString(array));
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid input format. Please use a comma-separated list.");
        }
    }
}
