package application;

import application.algorithms.MergeSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	private static int[] readArrayFromFile(String filename) {
		ArrayList<Integer> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] numbers = line.split("\\s+");
				for (String number : numbers) {
					list.add(Integer.parseInt(number));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
    public static void main(String[] args) {
        System.out.println("Welcome to the project!");
        
        //Testing Merge Sort
        // Create a sample array to sort
        int[] sampleArray = readArrayFromFile("data.txt");

        // Instantiate MergeSort with the sample array
        MergeSort mergeSort = new MergeSort(sampleArray);

        // Measure the sorting time
        mergeSort.measureSortTime();

        // Print the sorted array
		if (mergeSort.isSorted() == true) {
			System.out.println("The array was Merge sorted successfully. Sorted Array:");
			for (int num : mergeSort.getSortedArray()) {
				System.out.print(num + " ");
			}
			System.out.println();
			// Print the sorting time
			System.out.println("Time taken to sort: " + mergeSort.getSortTime() + " ms");
		} else System.out.println("Failed to sort");
	}
}
