package application.algorithm;

import application.panel.SortingPanel;

public class MergeSort extends SortingAlgorithm {
	// Additional attribute: Auxiliary array
    private int[] auxArray;  // Auxiliary array for merges

    @Override
    public void sort(SortingPanel panel) {
        int[] array = panel.getArray();  // Get the array from the panel
        if (array == null || array.length <= 1) return;

        auxArray = new int[array.length];  // Initialize the auxiliary array
        mergeSort(panel, array, 0, array.length - 1);
        panel.setArray(array);  // Finalize the array in the panel after sorting
    }

    private void mergeSort(SortingPanel panel, int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(panel, array, left, mid);
            mergeSort(panel, array, mid + 1, right);
            merge(panel, array, left, mid, right);
        }
    }

    private void merge(SortingPanel panel, int[] array, int left, int mid, int right) {
        System.arraycopy(array, left, auxArray, left, right - left + 1);  // Copy to auxiliary array
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            panel.setCompareIndices(i, j);

            if (auxArray[i] <= auxArray[j]) {
                array[k++] = auxArray[i++];
            } else {
                array[k++] = auxArray[j++];
            }
            panel.setMergeIndices(array, left, k - left);  // Pass the merged array to the panel
        }

        // Copy remaining elements from the left subarray (if there are any)
        while (i <= mid) {
            array[k++] = auxArray[i++];
            panel.setMergeIndices(array, left, k - left);  // Pass the merged array to the panel
        }

        // Copy remaining elements from the right subarray (if there are any)
        while (j <= right) {
            array[k++] = auxArray[j++];
            panel.setMergeIndices(array, left, k - left);  // Pass the merged array to the panel
        }

        // Update the array in the panel after merging
        panel.setArray(array);
    }
}
