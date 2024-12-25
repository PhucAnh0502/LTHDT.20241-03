package application.algorithm;

import application.panel.SortingPanel;

public class ShellSort extends SortingAlgorithm{
	// add attrinute: gap
	private int gap;

	@Override
	public void sort(SortingPanel panel) {
		// TODO Auto-generated method stub
		array = panel.getArray();//lay mang tu panel
		if(array == null|| array.length <=1)
		{
			return ;
		}
		for(gap = array.length/2;gap>0;gap/=2)// chia mang
	
		{
			for(int i=gap ; i<array.length; i++) //duyet phan tu ben phai
			{
				int j=i;
				while(j>=gap&&array[j-gap]>array[j])// so sanh 2 ptu ben trai va ben phai
				{   // cap nhat chi so va so sanh
					panel.setCompareIndices(j, j-gap);
					panel.setSwapIndices(j, j-gap);
					j-=gap;
				}
				// cap nhat sau moi lan chay xong vong lap

				panel.setArray(array);
			}
		}
		panel.setArray(array);
		
	}
	
}