package application.controllers;

import application.visualization.Visualize;
import application.algorithms.ShellSort;
import application.algorithms.SelectionSort;
import application.algorithms.MergeSort;
import application.algorithms.SortingAlgorithm;

public class DataSortingController implements Visualize {

	private ShellSort shellSort;

	private SelectionSort selectionSort;

	private MergeSort mergeSort;

	private SortingAlgorithm sortingAlgorithm;

}
