package application.algorithms;

public abstract class SortingAlgorithm {
	// Attributes
	protected String sortName;
	protected float sortTime;
	protected int[] initialArray;	// the input array
	protected int[] array;			// the temporary array to be handled by the sort() method
	protected int[] sortedArray;	// the output, sorted array
	protected boolean sorted;
	
	// Operations
	// Constructor
	public SortingAlgorithm(int[] initialArray) { 
		this.initialArray = copyArray(initialArray); 
		this.array = copyArray(this.initialArray);
	}
	// Destructor: Java handled that
	
	// public getters	
	public String getSortName() {
		return sortName;
	}
	public float getSortTime() {
		return sortTime;
	}	
	public int[] getSortedArray() { 
		return sortedArray; 
	}
	
	// Utility functions
	protected void swap(int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	protected void printArray() {
		for (int value : array) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
	public boolean isSorted() {
		for (int i = 0; i < sortedArray.length - 1; i++) {
			if (sortedArray[i] > sortedArray[i + 1]) {
				return false;
			}
		}
		return true;
	}
	public void measureSortTime() {
	    int[] tempArray = copyArray(initialArray); // Copy the initial array
	    long startTime = System.nanoTime();
	    sort(tempArray);
	    sortedArray = copyArray(tempArray);
	    long endTime = System.nanoTime();
	    sortTime = (endTime - startTime) / 1e6f; // Convert to milliseconds
	    sorted = isSorted();	
	}
	protected int[] copyArray(int[] source) {
		int[] copy = new int[source.length];
		System.arraycopy(source, 0, copy, 0, source.length);
		return copy;
	}
//	protected void reverseArray() {
//		int n = array.length;
//		for (int i = 0; i < n / 2; i++) {
//			swap(i, n - i - 1);
//		}
//	}
	// meant to be inherited and overridden 
	protected abstract void sort(int[] array);
}
