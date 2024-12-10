package application.controllers;

import application.visualization.Visualize;
import application.algorithms.ShellSort;
import application.algorithms.SelectionSort;
import application.algorithms.MergeSort;
import application.algorithms.SortingAlgorithm;

import javax.swing.*;
import java.util.List;

public class DataSortingController {
	private SortingAlgorithm selectedAlgorithm;
	private Visualize visualize;    
    
	public void setData(int[] data, String sortName) {
		switch (sortName) {
		case "ShellSort":
			selectedAlgorithm = new ShellSort(data);
			break;
		case "SelectionSort":
			selectedAlgorithm = new SelectionSort(data);
			break;
		case "MergeSort":
			selectedAlgorithm = new MergeSort(data);
			break;
		default:
			throw new IllegalArgumentException("Invalid sorting algorithm name");
		}
	}
	public void setVisualize(Visualize visualize) {
		this.visualize = visualize;
	}
	public void sortAndVisualize() {
		switch (selectedAlgorithm.getSortName()) { //type cast this selectedAlgorithm
		case "ShellSort":
			((ShellSort) selectedAlgorithm).sort();
			break;
		case "SelectionSort":
			((SelectionSort) selectedAlgorithm).sort();
			break;
		case "MergeSort":
			((MergeSort) selectedAlgorithm).sort();
			if (selectedAlgorithm.isSorted() == true) {
				System.out.println("The array was Merge sorted successfully. Sorted Array:");
				for (int num : selectedAlgorithm.getSortedArray()) {
					System.out.print(num + " ");
				}
				System.out.println();
				// Print the sorting time
				System.out.println("Time taken to sort: " + selectedAlgorithm.getSortTime() + " ms");
			} else System.out.println("Failed to sort");
			break;
		default:
			throw new IllegalArgumentException("Invalid sorting algorithm type");
		}
		visualize.displayArray(selectedAlgorithm.getSortedArray());
	}
}

