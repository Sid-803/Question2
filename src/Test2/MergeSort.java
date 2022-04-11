package Test2;


public class MergeSort {
	//Best case: (nlogn) Avg O(n logn) Worst O(n logn)
	//divide n/2 and n/2 and sort in n
	static void merge(int arr[], int left, int mid, int right) {
		int len1 = mid - left +1;
		int len2 = right -mid;
		
		int leftArr[] = new int[len1];
		int rightArr[]=new int[len2];
		
		for (int i =0; i<len1; i++)
			leftArr[i] = arr[left +1];
		for(int j=0; j<len2;j++)
			rightArr[j]=arr[mid +1+j];
		
		int i,j,k;
		i=0;
		j=0;
		k=left;
		
		while(i<len1 && j<len2) {
			if(leftArr[i]<=rightArr[j]) {
				arr[k]=leftArr[i];
				i++;
			}else {
				arr[k]=rightArr[i];
				j++;
			}k++;
		}while (i<len1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		while (j<len2){
			arr[k]=rightArr[j];
			j++;
			k++;
		}
	}
		static void mergeSort(final int arr[], final int left,final int right) {
			if (left < right) {
				int mid = (left + right)/2;
				mergeSort(arr,left,mid);
				mergeSort(arr,mid+1,right);
				merge(arr,left,mid,right);
			}
		}
		static void display(int arr[]) {
			int n = arr.length;
			for (int i =0; i<n; ++i)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	
}
