package application.controllers;

import application.visualization.Visualize;
import application.algorithms.ShellSort;
import application.algorithms.SelectionSort;
import application.algorithms.MergeSort;
import application.algorithms.SortingAlgorithm;

import javax.swing.*;
import java.util.List;

public class DataSortingController extends JPanel {
	private MainScreenController mainController;
	private List<String> data;
	private MergeSort mergeSort;
	private SelectionSort selectionSort;
	private ShellSort shellSort;

	public DataSortingController(MainScreenController mainController, SelectionSort selectionSort) {
		this.mainController = mainController;
		this.selectionSort = selectionSort;
	}

	public DataSortingController(MainScreenController mainController, MergeSort mergeSort) {
		this.mainController = mainController;
		this.mergeSort = mergeSort;
	}

	public DataSortingController(MainScreenController mainController, ShellSort shellSort) {
		this.mainController = mainController;
		this.shellSort = shellSort;
	}
}
