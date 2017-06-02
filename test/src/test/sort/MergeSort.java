package test.sort;

/**
 * 
 * @author chuzhen
 * @see http://blog.csdn.net/li_zhenxing/article/details/25183771
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] array = { 5, 4, 9, 8, 7, 6, 0, 1, 3, 2 };

		mergeSort(array, 0, array.length-1);

		printArray(array);
	}
	
	public static void printArray(int[] array) {
		for(int a:array) {
			System.out.print(a);
			System.out.print(", ");
		}
	}
	
	public static void mergeSort(int[] array, int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			mergeSort(array, left, mid);
			mergeSort(array, mid+1, right);
			merge(array, left, mid, right);
		}
	}
	
	public static void merge(int[] array, int low, int mid, int high) {
		int i = low;
		int j = mid+1;
		
		int[] array2 = new int[high - low + 1];
		int temp = 0;
		
		while(i<=mid && j<=high) {
			if(array[i] < array[j]) {
				array2[temp] = array[i];
				i++;
			} else {
				array2[temp] = array[j];
				j++;
			}
			temp++;
		}
		
		while(i<=mid) {
			array2[temp] = array[i];
			i++;
			temp++;
		}
		
		while(j<=high) {
			array2[temp] = array[j];
			j++;
			temp++;
		}
		
		for(i=0; i<array2.length; i++) {
			array[i+low] = array2[i];
		}
	}
}
