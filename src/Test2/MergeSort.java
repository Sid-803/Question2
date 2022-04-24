package Test2;
//Definition
//Most efficient in Sorting. 
//Comparison based. DIvide and Conquer
//Problem is divided into two subproblems in every iteration. so it is efficient.
//DIvide: Split in two until only one element is left.
//Conquer: merge the 2 sorted sub problems into one sorted.
//{22 14 5 7} == {22 14} + {5 7} == {22} {14} + {5} {7}
//Sort {14} {22} + {5} {7}
//Merge {5} {7} {14} {22}
//Algo
//Declare first and last indices of array
//Find mid = last+first / 2
//Call mergesort(A[], left,mid) and call mergeSort(A[], mid+1,right)
//Merge two sub arrays. using merge(arr,left, mid,right)
//Arranging single element distribution as left<right(Ascending)
//Both parts are sorted parallely.
//TC
//All cases complexity is O(nlogn) - it uses recursive.n/2+n/2..+n = 2T(n/2)+n - Applying Master theorem
//SC
//O(n)
//As it requires two array of n/2 elements. Which is auxiliary memeory. Extra Space. 
public class MergeSort {
	public static void merge(int[] arr, int left, int mid, int right) {
		
		int len1 = mid - left +1;
		int len2 = right - mid;
		
		int leftArr[] = new int[len1];
		int rightArr[] = new int[len2];
		
		for(int i=0; i<len1;i++)
			leftArr[i] = arr[left + i];
		for(int j = 0; j<len2; j++)
			rightArr[j] = arr[mid+1+j];
		
		int i,j,k;
		i=0;
		j=0;
		k=left;
		
		while(i<len1 && j<len2) {
			if(leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
					i++;
				}else {
					arr[k] = rightArr[j];
					j++;
				}
				k++;
			}
			while(i<len1) {
				arr[k]= leftArr[i];
				i++;
				k++;
			}
			while(j<len2) {
				arr[k]=rightArr[j];
				j++;
				k++;
			}
		}
	
	public static void mergeSort(int arr[], int left, int right) {
		if (left<right) {
			int mid = (left+right)/2;
			
			mergeSort(arr,left,mid);
			mergeSort(arr,mid+1,right);
			
			merge(arr,left,mid,right);
		}
	}
	
	public static void display(int[] arr) {
		int n = arr.length;
		for(int i=0; i<n; ++i)
			System.out.println(arr[i] + " ");
		System.out.println();
	}
	
}
