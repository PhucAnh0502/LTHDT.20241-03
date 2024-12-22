package application.panel;

import application.algorithm.MergeSort;
import application.algorithm.SelectionSort;
import application.algorithm.ShellSort;

import javax.swing.*;
import java.awt.*;

public class MainScreenPanel extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private SortingPanel currentSortingPanel;

    public MainScreenPanel() {
        setTitle("Sorting Algorithm Visualization");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createMainMenuPanel(), "MAIN_MENU");

        currentSortingPanel = new SortingPanel(this, new SelectionSort());
        mainPanel.add(currentSortingPanel, "SELECTION_SORT");

        SortingPanel mergeSortPanel = new SortingPanel(this, new MergeSort());
        mainPanel.add(mergeSortPanel, "MERGE_SORT");

        SortingPanel shellSortPanel = new SortingPanel(this, new ShellSort());
        mainPanel.add(shellSortPanel, "SHELL_SORT");

        add(mainPanel);
        setLocationRelativeTo(null);
    }

    private JPanel createMainMenuPanel() {
        JPanel menuPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(
                        0, 0, new Color(135, 206, 235),
                        getWidth(), getHeight(), new Color(25, 25, 112)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel titleLabel = new JLabel("Sorting Algorithm Visualization", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        menuPanel.add(titleLabel, gbc);

        String[] sortTypes = {"Selection Sort", "Merge Sort", "Shell Sort"};
        gbc.gridwidth = 1;
        for (int i = 0; i < sortTypes.length; i++) {
            JButton sortButton = createRoundedButton(sortTypes[i], new Dimension(200, 50));
            final String sortType = sortTypes[i];
            sortButton.addActionListener(e -> {
                switch (sortType) {
                    case "Selection Sort":
                        cardLayout.show(mainPanel, "SELECTION_SORT");
                        break;
                    case "Merge Sort":
                        cardLayout.show(mainPanel, "MERGE_SORT");
                        break;
                    case "Shell Sort":
                        cardLayout.show(mainPanel, "SHELL_SORT");
                        break;
                }
            });
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            gbc.gridwidth = 2;
            menuPanel.add(sortButton, gbc);
        }

        JButton helpButton = createRoundedButton("Help", new Dimension(200, 50));
        helpButton.setBackground(new Color(30, 144, 255));
        helpButton.setForeground(Color.WHITE);
        helpButton.addActionListener(e -> showHelpDialog());
        gbc.gridy = sortTypes.length + 1;
        menuPanel.add(helpButton, gbc);

        JButton quitButton = createRoundedButton("Quit", new Dimension(200, 50));
        quitButton.setBackground(new Color(178, 34, 34));
        quitButton.setForeground(Color.WHITE);
        quitButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to quit?",
                    "Confirm Quit",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        gbc.gridy = sortTypes.length + 2;
        menuPanel.add(quitButton, gbc);

        return menuPanel;
    }

    private JButton createRoundedButton(String text, Dimension size) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2.setColor(getForeground());
                g2.dispose();
                g2.setFont(new Font("Arial", Font.BOLD, 12));
                super.paintComponent(g);
            }

            @Override
            protected void paintBorder(Graphics g) {
                g.setColor(getForeground());
                ((Graphics2D) g).drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            }
        };
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setPreferredSize(size);
        return button;
    }

    private void showHelpDialog() {
        JOptionPane.showMessageDialog(this,
                "Sorting Algorithm Visualization\n\n" +
                        "Application Features:\n" +
                        "1. Choose between three sorting algorithms\n" +
                        "2. Create random or custom arrays\n" +
                        "3. Visualize sorting steps\n\n" +
                        "How to Use:\n" +
                        "- Select a sorting algorithm\n" +
                        "- Click 'Random Array' or 'Input Array'\n" +
                        "- Press 'Start Sorting' to begin\n" +
                        "- Watch the sorting process step by step",
                "Help",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void returnToMainMenu() {
        cardLayout.show(mainPanel, "MAIN_MENU");
    }
}
