package application.algorithm;

import application.panel.SortingPanel;

public class ShellSort extends SortingAlgorithm {
    @Override
    public void sort(SortingPanel panel) {
        int[] array = panel.getArray();
        if (array == null || array.length <= 1) return;

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    panel.setCompareIndices(j, j - gap);
                    array[j] = array[j - gap];
                    panel.setArray(array);  // Update the array in the panel to visualize the swap
                    panel.repaint();
                }

                array[j] = temp;

                // Visualize the final placement of temp
                panel.setSwapIndices(j, i);
                panel.setArray(array);  // Update the array in the panel to visualize the swap
                panel.repaint();
            }
        }
    }
}
