package application.algorithm;

import application.panel.SortingPanel;

public abstract class SortingAlgorithm {
	protected int[] array;
	
	// This is not identical from the sorting panel one
	public void setArray(int[] inputArray) {
		// Create a copy of the input array to avoid modifying original
		this.array = new int[inputArray.length];
		System.arraycopy(inputArray, 0, this.array, 0, inputArray.length);
	}

	// Abstract method meant to be implemented
	public abstract void sort(SortingPanel panel);
}
