package application.algorithm;

public abstract class SortingAlgorithm {
	protected int[] array;

	public void setArray(int[] inputArray) {
		// Create a copy of the input array to avoid modifying original
		this.array = new int[inputArray.length];
		System.arraycopy(inputArray, 0, this.array, 0, inputArray.length);
	}

	// Abstract method to be implemented by specific sorting algorithms
	public abstract void sort(SortingPanel panel);
}
