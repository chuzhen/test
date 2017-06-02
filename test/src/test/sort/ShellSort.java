package test.sort;

/**
 * 
 * @author chuzhen
 * @see http://www.cnblogs.com/jingmoxukong/p/4303279.html
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] array = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
		
		shellSort(array);
		
		printArray(array);
		
	}
	
	public static void printArray(int[] array) {
		for(int a:array) {
			System.out.print(a);
			System.out.print(", ");
		}
	}
	
	static void shellSort(int[] array) {
		for(int increment=array.length/2; increment >=1; increment/=2) {
			for(int start = increment; start < array.length; start++) {
				int temp = array[start];
				int subStart = start - increment;
				
				while(subStart >=0 && array[subStart] > temp) {
					array[subStart + increment] = array[subStart];
					subStart -= increment;
				}
				
				array[subStart+increment] = temp;
			}
		}
	}
}
