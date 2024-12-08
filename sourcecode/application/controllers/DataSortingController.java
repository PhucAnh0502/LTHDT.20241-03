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

	public void setData(int[] data) {
		selectedAlgorithm.setInitialArray(data);
	}

	public void setVisualize(Visualize visualize) {
		this.visualize = visualize;
	}

	public void sortAndVisualize() {
		selectedAlgorithm.sort();
	}
}

