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
		
		//������ʼ��
		maxHeapSort(array, array.length);
		System.out.print("��ʼ�ѣ�");
		printArrayln(array);
		
		//����n-1��ѭ�����������
		for(int i=array.length - 1; i > 0; i--) {
			swap(array, i, 0);
			
			maxHeapSort(array, i);
			
			System.out.print("��" + (array.length - i) + "������");
			printArrayln(array);
			
		}
			
	}
	
	/**
	 * ����
	 * @param array
	 */
	private static void maxHeapSort(int[] array, int limitIndex) {
		for(int parentIndex = limitIndex/2; parentIndex >= 0; parentIndex--) {
			//���ѵĹ���Ӧ�ô����һ����Ҷ�ӽڵ㿪ʼ,û�����Ӿ��Ƿ�Ҷ�ӽڵ�
//			int childIndex = 2*parentIndex + 1;//����
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
		
		//�ͺ��ӽڵ�Ƚϣ���ȡ���ӣ�������Һ������Һ��Ӵ������ӣ���ȡ�Һ���
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
