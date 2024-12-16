package application.controllers;
import javax.swing.*;
import java.awt.*;

public class InputController {
    private JFrame frame;
    private JButton randomArrayButton, inputArrayButton, backButton;
    private int[] arrayInput;

    public InputController() {
        frame = new JFrame("Array Input");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        //Button
        randomArrayButton = new JButton("Create Randomly");
        inputArrayButton = new JButton("Input Array");
        backButton = new JButton("Back");

        //Add Button
        panel.add(randomArrayButton);
        panel.add(inputArrayButton);
        panel.add(backButton);

        frame.add(panel);
        frame.setVisible(true);

        //handle event
        randomArrayButton.addActionListener(e -> generateRandomArray());
        inputArrayButton.addActionListener(e -> inputArray());
        backButton.addActionListener(e -> handleBack());
    }

    // Method to input array manually
    private void inputArray() {
        String input = JOptionPane.showInputDialog("Enter your array, separated by commas: ");
        String[] numbers = input.split(",");
        arrayInput = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            arrayInput[i] = Integer.parseInt(numbers[i].trim());
        }
    }

    private void generateRandomArray() {
        String input = JOptionPane.showInputDialog("Enter size of array: ");
        int size = Integer.parseInt(input);
        for (int i = 0; i < size; i++) {
            arrayInput[i] = (int) (Math.random() * 100);
        }
    }

    private void handleBack(){
        frame.setVisible(false);
        MainScreenController mainFrame = new MainScreenController();
    }
}
