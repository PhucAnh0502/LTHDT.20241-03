package application.algorithm;

public class ShellSort extends SortingAlgorithm {
	@Override
	public void sort(SortingPanel panel) {
		if (array == null || array.length <= 1) return;

		for (int gap = array.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < array.length; i++) {
				int temp = array[i];
				int j;
				for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
					panel.setCompareIndices(j, j - gap);
					array[j] = array[j - gap];
				}

				// Visualize the swap
				panel.setSwapIndices(j, i);

				array[j] = temp;
			}
		}
	}
}
