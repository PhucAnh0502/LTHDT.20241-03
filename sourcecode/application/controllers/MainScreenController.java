package application.controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenController {
    private JFrame frame;
    private JButton selectionSortBtn, mergeSortBtn, shellSortBtn, helpBtn, quitBtn;
    private JPanel mainPanel;
    private InputController inputController;

    public MainScreenController() {
        frame = new JFrame("Sorting Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1,5));

        //Button
        selectionSortBtn = new JButton("Selection Sort");
        mergeSortBtn = new JButton("Merge Sort");
        shellSortBtn = new JButton("Shell Sort");
        helpBtn = new JButton("Help");
        quitBtn = new JButton("Quit");

        //Add Button
        mainPanel.add(selectionSortBtn);
        mainPanel.add(mergeSortBtn);
        mainPanel.add(shellSortBtn);
        mainPanel.add(helpBtn);
        mainPanel.add(quitBtn);

        frame.add(mainPanel);
        frame.setVisible(true);

        //handle events
        selectionSortBtn.addActionListener(e -> handleSeclectionSort());
        mergeSortBtn.addActionListener(e -> handleMergeSort());
        shellSortBtn.addActionListener(e -> handleShellSort());
        helpBtn.addActionListener(e -> showHelp());
        quitBtn.addActionListener(e -> confirmQuit());
    }

    private void handleSeclectionSort(){
        inputController = new InputController();
    }

    private void handleMergeSort(){
        inputController = new InputController();
    }

    private void handleShellSort(){
        inputController = new InputController();
    }

    private void showHelp(){
        JOptionPane.showMessageDialog(frame, "This application is using to demonstrate sorting algorithm (Selection Sort, Merge Sort, Shell Sort)");
    }

    private void confirmQuit(){
        int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
