package application.panel;

import application.algorithm.SortingAlgorithm;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SortingPanel extends JPanel {
    private int[] array;
    private SortingAlgorithm sortAlgorithm;
    private MainScreenPanel parentFrame;
    private boolean isSorting = false;

    // Visualization variables
    private int currentCompareIndex1 = -1;
    private int currentCompareIndex2 = -1;
    private int swapIndex1 = -1;
    private int swapIndex2 = -1;

    // Sorting statistics
    private long startTime;
    private long endTime;
    private int comparisonCount = 0;
    private int swapCount = 0;

    // UI Components
    private JLabel statusLabel;
    private JLabel statsLabel;

    public SortingPanel(MainScreenPanel parent, SortingAlgorithm algorithm) {
        this.parentFrame = parent;
        this.sortAlgorithm = algorithm;

        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240));

        // Create status panel
        JPanel statusPanel = createStatusPanel();
        add(statusPanel, BorderLayout.NORTH);

        // Create control panel
        JPanel controlPanel = createControlPanel();
        add(controlPanel, BorderLayout.SOUTH);
    }

    public void setSwapIndices(int index1, int index2) {
        swapIndex1 = index1;
        swapIndex2 = index2;
        swapCount++;
        repaint();

        // Perform the swap
        if (array != null && index1 >= 0 && index2 >= 0 && index1 < array.length && index2 < array.length) {
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }

        // Add small delay to visualize swap
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private JPanel createStatusPanel() {
        JPanel statusPanel = new JPanel(new GridLayout(2, 1));
        statusPanel.setBackground(new Color(240, 240, 240));

        statusLabel = new JLabel("Create an array to begin", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));

        statsLabel = new JLabel("", SwingConstants.CENTER);
        statsLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        statusPanel.add(statusLabel);
        statusPanel.add(statsLabel);

        return statusPanel;
    }

    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(new Color(230, 230, 230));

        // Random Array Button
        JButton randomArrayBtn = createStyledButton("Random Array", new Color(76, 175, 80));
        randomArrayBtn.addActionListener(e -> {
            generateRandomArray();
            updateStatus("Random array created", true);
        });

        // Input Array Button
        JButton inputArrayBtn = createStyledButton("Input Array", new Color(33, 150, 243));
        inputArrayBtn.addActionListener(e -> {
            inputCustomArray();
            updateStatus("Custom array created", true);
        });

        // Start Sort Button
        JButton startSortBtn = createStyledButton("Start Sorting", new Color(255, 152, 0));
        startSortBtn.addActionListener(e -> {
            if (!isSorting) {
                startSorting();
            }
        });

        // Back to Menu Button
        JButton backBtn = createStyledButton("Back to Menu", new Color(158, 158, 158));
        backBtn.addActionListener(e -> parentFrame.returnToMainMenu());

        // Add buttons to control panel
        controlPanel.add(randomArrayBtn);
        controlPanel.add(inputArrayBtn);
        controlPanel.add(startSortBtn);
        controlPanel.add(backBtn);

        return controlPanel;
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Create gradient
                GradientPaint gradient = new GradientPaint(
                        0, 0, bgColor,
                        0, getHeight(), bgColor.darker()
                );
                g2d.setPaint(gradient);

                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

                // Button text
                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Arial", Font.BOLD, 12));
                FontMetrics fm = g2d.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(getText())) / 2;
                int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
                g2d.drawString(getText(), x, y);
            }
        };
        button.setPreferredSize(new Dimension(120, 40));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        return button;
    }

    private void generateRandomArray() {
        Random rand = new Random();
        String input = JOptionPane.showInputDialog("Enter size of array: ");
        int size = Integer.parseInt(input);
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100) + 1;  // 1-100 values
        }
        sortAlgorithm.setArray(array);
        resetSortingStats();
        repaint();
    }

    private void inputCustomArray() {
        String input = JOptionPane.showInputDialog("Enter array elements (comma-separated):");
        if (input != null && !input.trim().isEmpty()) {
            try {
                String[] strArray = input.split(",");
                array = new int[strArray.length];
                for (int i = 0; i < strArray.length; i++) {
                    array[i] = Integer.parseInt(strArray[i].trim());
                }
                sortAlgorithm.setArray(array);
                resetSortingStats();
                repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter numbers.");
                updateStatus("Invalid array input", false);
            }
        }
    }

    private void startSorting() {
        if (array == null) {
            JOptionPane.showMessageDialog(this, "Create an array first!");
            updateStatus("Please create an array", false);
            return;
        }

        // Reset sorting stats
        resetSortingStats();
        updateStatus("Sorting in progress...", true);

        // Start sorting in a new thread
        new Thread(() -> {
            isSorting = true;
            startTime = System.nanoTime();

            sortAlgorithm.sort(this);

            endTime = System.nanoTime();
            SwingUtilities.invokeLater(() -> {
                isSorting = false;
                currentCompareIndex1 = -1;
                currentCompareIndex2 = -1;
                updateFinalStats();
                repaint();
            });
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (array == null) {
            return;
        }

        // Calculate dimensions
        int panelWidth = getWidth();
        int panelHeight = getHeight() - 150;  // Leave space for controls
        int barWidth = panelWidth / (array.length + 1);
        int maxBarHeight = panelHeight;

        // Draw title
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        String algorithmName = sortAlgorithm.getClass().getSimpleName() + " Visualization";
        g.drawString(algorithmName, 10, 30);

        // Find max value for scaling
        int maxValue = findMaxValue();

        // Draw bars
        for (int i = 0; i < array.length; i++) {
            // Calculate bar height proportionally
            int barHeight = (int) ((double) array[i] / maxValue * maxBarHeight);

            // Determine color based on visualization state
            Color barColor;
            if (i == currentCompareIndex1 || i == currentCompareIndex2) {
                barColor = Color.RED;  // Highlight compared elements
            } else if (i == swapIndex1 || i == swapIndex2) {
                barColor = Color.GREEN;  // Highlight swapped elements (can adjust timing)
            } else {
                barColor = new Color(70, 130, 180);  // Normal bar color
            }

            // Draw bar
            int x = (i + 1) * barWidth;
            int y = getHeight() - barHeight - 100;  // Adjust for bottom margin
            g.setColor(barColor);
            g.fillRect(x, y, barWidth - 5, barHeight);

            // Draw value on top of bar
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(array[i]), x, y - 5);
        }
    }

    private int findMaxValue() {
        if (array == null || array.length == 0) return 1;
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }

    // Methods for sorting algorithms to update visualization
    public void setCompareIndices(int index1, int index2) {
        currentCompareIndex1 = index1;
        currentCompareIndex2 = index2;
        comparisonCount++;
        repaint();

        // Add small delay to visualize comparison
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void resetSortingStats() {
        startTime = 0;
        endTime = 0;
        comparisonCount = 0;
        swapCount = 0;
        statsLabel.setText("");
    }

    private void updateStatus(String message, boolean isPositive) {
        statusLabel.setForeground(isPositive ? Color.BLUE : Color.RED);
        statusLabel.setText(message);
    }

    private void updateFinalStats() {
        double duration = (endTime - startTime) / 1_000_000.0;  // Convert to milliseconds
        String statsText = String.format(
                "Time: %.2f ms | Comparisons: %d | Swaps: %d",
                duration, comparisonCount, swapCount
        );
        statsLabel.setText(statsText);
        updateStatus("Sorting completed", true);
    }
}
