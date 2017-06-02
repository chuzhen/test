package test.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 击鼓传花
 * @author chuzhen
 *
 */
public class JosephusProblem {

	/**
	 * 
	 * @param list
	 * @param start 开始传递的位置
	 * @param offset 传递的次数
	 */
	public static List<Integer> go(List<Integer> nums, int start, int offset) {
		int remove = start;
		while(nums.size() > 1) {
			System.out.println(nums);
			remove = (remove + offset) % nums.size();
			nums.remove(remove);
		}
		
		return nums;
	}
	
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>(7);
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		
		System.out.println(nums.size());
		
		List<Integer> remain = go(nums, 0, 1);
		System.out.println(remain);
	}
}
