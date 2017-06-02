package test.sort;

/**
 * @author chuzhen
 * @see http://developer.51cto.com/art/201403/430986.htm
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] array = { 5, 4, 9, 8, 7, 6, 0, 1, 3, 2 };
		
		quickSort(array);
	}
	
	public static void printArray(int[] array) {
		for(int a:array) {
			System.out.print(a);
			System.out.print(", ");
		}
		System.out.println();
	}
	
	public static void quickSort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	private static void sort(int[] array, int left, int right) {
		if(left >= right)
			return;

		printArray(array);
		
		int left_origin = left;
		int right_origin = right;
		int key = array[left];
		
		while(left < right) {
			while(left < right && array[right] >= key) {
				right --;
			}
			while(left < right && array[left] <= key) {
				left ++;
			}
			
			if(left < right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		
		if(left_origin != left) {
			array[left_origin] = array[left];
			array[left] = key;
		}
		
		sort(array, left_origin, left-1);
		sort(array, left+1, right_origin);
	}
}
