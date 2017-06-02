package test.sort;

/**
 * @author chuzhen
 * @see http://blog.csdn.net/jinyongqing/article/details/12651349
 * 		http://www.cnblogs.com/jingmoxukong/p/4303826.html
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] array = { 1, 3, 4, 5, 2, 6, 9, 7, 8, 0};
		
		//建立初始堆
		maxHeapSort(array, array.length);
		System.out.print("初始堆：");
		printArrayln(array);
		
		//进行n-1次循环，完成排序
		for(int i=array.length - 1; i > 0; i--) {
			swap(array, i, 0);
			
			maxHeapSort(array, i);
			
			System.out.print("第" + (array.length - i) + "趟排序：");
			printArrayln(array);
			
		}
			
	}
	
	/**
	 * 大顶推
	 * @param array
	 */
	private static void maxHeapSort(int[] array, int limitIndex) {
		for(int parentIndex = limitIndex/2; parentIndex >= 0; parentIndex--) {
			//调堆的过程应该从最后一个非叶子节点开始,没有左孩子就是非叶子节点
//			int childIndex = 2*parentIndex + 1;//左孩子
//			if(childIndex >= limitIndex) {
//				continue;
//			}
			
			adjust(array, parentIndex, limitIndex);
		}
	}

	private static void adjust(int[] array, int parentIndex, int limitIndex) {
		int childIndex = 2*parentIndex + 1;
		if(childIndex >= limitIndex)
			return;
		
		//和孩子节点比较，先取左孩子，如果有右孩子且右孩子大于左孩子，择取右孩子
		if((childIndex+1) < limitIndex && array[childIndex] < array[childIndex+1]) {
			childIndex++;
		}
		
		if(array[parentIndex] < array[childIndex]) {
			swap(array, parentIndex, childIndex);
			
			parentIndex = childIndex;
			adjust(array, parentIndex, limitIndex);
		}
	}

	private static void swap(int[] array, int i, int j) {
		array[i] = array[i] + array[j];
		array[j] = array[i] - array[j];
		array[i] = array[i] - array[j];
	}

	public static void printArrayln(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if(i > 0) {
				System.out.print(", ");
			}
			System.out.print(array[i]);
		}
		System.out.println();
	}
	
	public static boolean is2NCF(int n) {
		if(n < 2) {
			return false;
		}
		
		return ((n & (n-1)) == 0);
	}
	
}
