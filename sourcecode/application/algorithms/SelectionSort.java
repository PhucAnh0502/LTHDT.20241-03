package application.algorithms;

public class SelectionSort extends SortingAlgorihm {
    public SelectionSort(int[] initialArray){
        super(initialArray);
        sortName = "Selection Sort";
    }
    public void sort(int[] array){
        int n = arr.length;
        for(int i=0; i<n; i++){
            int min = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }

            swap(arr, i, min);
        }
    }
}
