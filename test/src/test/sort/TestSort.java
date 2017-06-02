package test.sort;

public class TestSort {

	public static void main(String[] args) {
		int[] array = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
		
		bubbleSort(array);
		
		printArray(array);
	}
	
	
	
	public static void bubbleSort(int[] array) {
		for(int i=0; i<array.length - 1; i++) {
			for(int j=i+1; j<array.length; j++) {
				if(array[j] < array[i]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
	}
	
	public static void insertSort(int[] array) {
		for(int i=0; i<array.length; i++) {
//			for(int j=0; j<i; j++) {
//				if(array[j] > array[i]) {
//					int temp = array[i];
//					array[i] = array[j];
//					array[j] = temp;
//				}
//			}
			
			int temp = array[i];
			int j = i;
			while(j > 0 && array[j-1] > temp) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = temp;
			
			printArray(array);
			System.out.println();
		}
	}
	
	public static void printArray(int[] array) {
		for(int a:array) {
			System.out.print(a);
			System.out.print(", ");
		}
	}
	
	public static void selectSort(int[] array) {
		for(int i=0; i<array.length; i++) {
			int temp = array[i];
			
			int flag = i;
			for(int j=i+1; j<array.length; j++) {
				if(temp > array[j]) {
					temp = array[j];
					flag = j;
				}
			}
			
			if(flag != i) {
				array[flag] = array[i];
				array[i] = temp;
			}
		}
	}
}
