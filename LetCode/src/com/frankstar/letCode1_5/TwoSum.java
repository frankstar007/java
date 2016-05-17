/**
 * 
 */
package com.frankstar.letCode1_5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author frankstar
 * 返回数组中指定和的索引
 */
public class TwoSum {
	public int[] twoSumMethod1(int[] nums, int target) {
		int[] result = null;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					result = new int[]{i,j};
				}
			}
		}
		return result;
	}
	public int[] twoSumMethod2(int[] nums, int target) {
		int[] result = null;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				result = new int[]{i,map.get(complement)};
			}
		}
	
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,5,7,11,15};
		int target = 9;
		TwoSum sum = new TwoSum();
		int[] result1 = sum.twoSumMethod1(nums, target);
		int[] result2 = sum.twoSumMethod2(nums, target);
		System.out.println(Arrays.toString(result2));
	}

}
