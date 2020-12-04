package leetcode.medium.twopoint;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. Partition Labels
 * 
 * @author mgpc
 */
public class PartitionLabels {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "ababcbacadefegdehijhklij";
		List<Integer> labels = solution.partitionLabels(s);
		solution.print(labels);
	}
}

class Solution {
	public List<Integer> partitionLabels(String S) {
		List<Integer> labels = new ArrayList<>();
		int[] lastIndexes = new int[128];
		for (int i = 0; i < S.length(); i++) {
			lastIndexes[(int)S.charAt(i)] = i;
		}
		
		int left = 0;
		int right = 0;
		for (int i = 0; i < S.length(); i++) {
			right = Math.max(right, lastIndexes[(int)S.charAt(i)]);
			if(i == right) {
				labels.add(right - left + 1);
				left = right + 1;
			}
		}
		return labels;
	}
	
	public void print(List<Integer> labels) {
		for (Integer label : labels) {
			System.out.print(label+", ");
		}
	}
}