package application.algorithms;

public class SelectionSort extends SortingAlgorithm {
	// Additional attribute:
	
	// Public Constructor
    public SelectionSort(int[] initialArray){
        super(initialArray);
        sortName = "Selection Sort";
    }
    public void sort(){
        int n = array.length;
        for(int i=0; i<n; i++){
            int min = i;
            for(int j=i+1; j<n; j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            swap(i, min);
        }
    }
}
