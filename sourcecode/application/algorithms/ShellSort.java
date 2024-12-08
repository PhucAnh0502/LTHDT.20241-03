package application.algorithms;

public class ShellSort extends SortingAlgorithm {
	// Additional attribute:
	private int[] array;
	private int temp;
	// Public Constructor
	public ShellSort(int[] initialArray){
		super(initialArray);
		sortName = "ShellSort";
	}
	private void shellSort(int[] a)
	{
		int n = a.length;
		for(int gap=n/2;gap>0;gap/=2) // bap dau bang nua chieu dai mang va giam dan bang cach chia doi (n/2) sau moi lan lap
		{
			for(int i=gap;i<n;i++) 
			{
				temp = a[i];
				int j;
				for(j=i;j>=gap&&a[j-gap]>temp;j-=gap)
					a[j]=a[j-gap];
				a[j]=temp;
			}
		}
		
	}


	public void sort(int[] array) {
		shellSort(array);
	};
	public int getTemp()
	{
		return temp;
	}
	
	
}
