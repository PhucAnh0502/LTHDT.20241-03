package application.algorithm;

import application.panel.SortingPanel;

public class ShellSort extends SortingAlgorithm {
	// Additional attribute: gap
	private int gap;
    @Override
    public void sort(SortingPanel panel) {
        array = panel.getArray();  // Get the array from the panel
        if (array == null || array.length <= 1) return;

        for (gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                while (j >= gap && array[j - gap] > array[j]) {
                    panel.setCompareIndices(j, j - gap);
                    panel.setSwapIndices(j, j - gap);
                    j -= gap;
                }
                panel.setArray(array);  // Update the array in the panel
            }
        }
        panel.setArray(array);  // Finalize the array in the panel after sorting
    }
}
