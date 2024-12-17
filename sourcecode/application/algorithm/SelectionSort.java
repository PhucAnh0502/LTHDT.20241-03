package application.algorithm;

import application.panel.SortingPanel;

public class SelectionSort extends SortingAlgorithm {
    @Override
    public void sort(SortingPanel panel) {
        if (array == null || array.length <= 1) return;

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            // Find the minimum element in unsorted part
            for (int j = i + 1; j < array.length; j++) {
                panel.setCompareIndices(minIndex, j);

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;

                // Visualize the swap
                panel.setSwapIndices(minIndex, i);
            }
        }
    }
}