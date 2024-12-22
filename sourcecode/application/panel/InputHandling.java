package application.panel;

import application.algorithm.SortingAlgorithm;

import javax.swing.*;
import java.util.Random;

public class InputHandling {
    private int[] array = null;
    private SortingAlgorithm sortAlgorithm;

    public InputHandling(SortingAlgorithm algorithm) {
        this.sortAlgorithm = algorithm;
    }

    public int[] getArray() {
        return array;
    }

    public void generateRandomArray() {
        Random rand = new Random();
        String input = JOptionPane.showInputDialog("Enter size of array: ");
        try {
            int size = Integer.parseInt(input);
            if (size <= 0) {
                throw new NumberFormatException();
            }
            array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = rand.nextInt(100) + 1;  // 1-100 values
            }
            sortAlgorithm.setArray(array);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a positive integer.");
        }
    }

    public void inputCustomArray() {
        String input = JOptionPane.showInputDialog("Enter array elements (comma-separated):");
        if (input != null && !input.trim().isEmpty()) {
            try {
                String[] strArray = input.split(",");
                array = new int[strArray.length];
                for (int i = 0; i < strArray.length; i++) {
                    array[i] = Integer.parseInt(strArray[i].trim());
                }
                sortAlgorithm.setArray(array);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter numbers.");
                array = null;
            }
        }
    }
}
