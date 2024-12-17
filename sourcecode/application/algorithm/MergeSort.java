package application.algorithm;

public class MergeSort extends SortingAlgorithm {
	@Override
	public void sort(SortingPanel panel) {
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

		while (i <= mid && j <= right) {
			panel.setCompareIndices(i, j);

			if (array[i] <= array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
				panel.setSwapIndices(i, j);
			}
		}

		// Copy remaining elements from left subarray (if there are any)
		while (i <= mid) {
			temp[k++] = array[i++];
		}

		// Copy remaining elements from right subarray (if there are any)
		while (j <= right) {
			temp[k++] = array[j++];
		}

		// Copy all elements from the temporary array back to the original array
		System.arraycopy(temp, 0, array, left, temp.length);
	}
}

