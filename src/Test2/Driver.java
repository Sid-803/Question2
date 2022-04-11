package Test2;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		System.out.println("Enter total denomination");
		Scanner s = new Scanner(System.in);
		int d = s.nextInt();
		System.out.println("Enter denominations");
		int denoms[] = new int[d];
		for (int i = 0;i<d;i++) {
			denoms[i]=s.nextInt();
			
		}
		System.out.println("Enter Amount");
		int sum = s.nextInt();
		
		MergeSort.display(denoms);
		MergeSort.mergeSort(denoms,0,denoms.length-1);
		System.out.print("Sorted array ");
		MergeSort.display(denoms);
		
		int ct[] = new int[denoms.length];
		for (int i = 0; i<denoms.length;i++) {
			if (sum>=denoms[i]) {
				int exchange = sum/denoms[i];
				sum = sum -(denoms[i]*exchange);
				ct[i]=exchange;
				
			}
		}
		if(sum>0) {
			System.out.println("Payment not possible");
		}else {
			System.out.println("Payment possible with minimum note count");
			for(int i=0; i<ct.length; i++) {
				System.out.println(denoms[i]+ "-" + ct[i]);
			}
		}
		s.close();
	}
	
}
