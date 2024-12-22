package application.algorithm;

import application.panel.SortingPanel;

public class MergeSort extends SortingAlgorithm {
    
    @Override
    public void sort(SortingPanel panel) {
        array = panel.getArray();  // Get the array from the panel
        if (array == null || array.length <= 1) return;
        mergeSort(panel, 0, array.length - 1);
    }

    private void mergeSort(SortingPanel panel, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(panel, left, mid);
            mergeSort(panel, mid + 1, right);
            merge(panel, left, mid, right);
        }
    }

    private void merge(SortingPanel panel, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int[] mergeIndices = new int[temp.length];
        int mergeIndex = 0;

        while (i <= mid && j <= right) {
            panel.setCompareIndices(i, j);

            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }

            mergeIndices[mergeIndex++] = k;

            // Add a small delay to visualize the merge step
            panel.setMergeIndices(mergeIndices);
            panel.repaint();
        }

        // Copy remaining elements from left subarray (if there are any)
        while (i <= mid) {
            temp[k++] = array[i++];
            mergeIndices[mergeIndex++] = k;
            panel.setMergeIndices(mergeIndices);
            panel.repaint();
        }

        // Copy remaining elements from right subarray (if there are any)
        while (j <= right) {
            temp[k++] = array[j++];
            mergeIndices[mergeIndex++] = k;
            panel.setMergeIndices(mergeIndices);
            panel.repaint();
        }

        // Copy all elements from the temporary array back to the original array
        System.arraycopy(temp, 0, array, left, temp.length);

        // Update the array in the panel
        panel.setArray(array);

        // Repaint the panel after merging
        panel.repaint();
    }
}
