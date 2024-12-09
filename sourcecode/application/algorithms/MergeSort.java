package application.algorithms;

import application.visualization.Visualize;

public class MergeSort extends SortingAlgorithm implements Visualize {
	// Additional attribute: Auxiliary Array 
	private int[] auxArray;
	// Public Constructor
	public MergeSort(int[] initialArray){
		super(initialArray);
		sortName = "MergeSort";
		this.auxArray = new int[initialArray.length];
	}

    // Merge sort's thing
	private void mergeSort(int[] array, int left, int right) { 
		if (left < right) { 
			int mid = (left + right) / 2;   	// init the middle index of the array
			mergeSort(array, left, mid);		// sort the left
			mergeSort(array, mid + 1, right);	// sort the right
			merge(array, left, mid, right);		// merge the 2
		}
	}
	private void merge(int[] array, int left, int mid, int right) {
		displayArray(array);
		int n1 = mid - left + 1; 				// length of the left of the array
		int n2 = right - mid;					// length of the right of the array
		// copy data from array to auxArray
		System.arraycopy(array, left, auxArray, left, n1);
		System.arraycopy(array, mid + 1, auxArray, mid + 1, n2);
		// merge it back from auxArray to array
		int i = left; int j = mid + 1; int k = left; //index initiated
		while (i <= mid && j <= right) {
			array[k++] = (auxArray[i] <= auxArray[j]) ? auxArray[i++] : auxArray[j++];
			displayArray(array);
		} 
		// put back the remaining left thing
		if (i <= mid) {
			System.arraycopy(auxArray, i, array, k, mid - i + 1);
			displayArray(array);
		}
		// put back the remaining right thing
		if (j <= right) {
			System.arraycopy(auxArray, j, array, k, right - j + 1); 
			displayArray(array);
		}
	}
	// Implement sort function
	public void sort() {
		mergeSort(array, 0, array.length - 1);
	};
	// Implement Visualize's method
	public void displayArray(int[] data) {
        // display the main array
        System.out.print("Main Array: ");
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println();
        // display the auxiliary array
        System.out.print("Auxiliary Array: ");
        for (int value : auxArray) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
	// no swap in merge sort
	public void swapElements(int[] array, int i, int j) {}
}
