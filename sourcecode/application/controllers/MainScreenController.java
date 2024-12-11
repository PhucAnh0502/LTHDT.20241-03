import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainScreenController extends JFrame {

    // Buttons for interaction
    private JButton randomArrayButton;
    private JButton inputArrayButton;
    private JTextField arrayInput;
    private JTextArea outputArea;
    private int[] array;

    public MainScreenController() {
        // Frame setup
        setTitle("Sorting Algorithms Demonstration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize components
        randomArrayButton = new JButton("Generate Random Array");
        inputArrayButton = new JButton("Input Array");
        arrayInput = new JTextField(20);
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        // Add components to the frame
        add(randomArrayButton);
        add(inputArrayButton);
        add(arrayInput);
        add(new JScrollPane(outputArea));
