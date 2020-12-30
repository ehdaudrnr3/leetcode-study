package leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Difiiculty : Medium
 */
public class Distant_Barcodes {
	public static void main(String[] args) {
		int[] barcodes = new int[]{1, 1, 1, 2, 2, 2};
		Solution.rearrangeBarcodes(barcodes);
	}
	
	static class Solution {
	    public static int[] rearrangeBarcodes(int[] barcodes) {
	        Map<Integer, Integer> cnt = new HashMap();
	        for (int barcode : barcodes) cnt.put(barcode, cnt.getOrDefault(barcode, 0) + 1);
	        
	        Queue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
	        for (Integer barcode : cnt.keySet()) q.offer(new int[] { barcode, cnt.get(barcode)});
	        
	        int[] rs = new int[barcodes.length];
	        int i = 0;
	        while(!q.isEmpty()) {
	        	int[] bar = q.poll();
	        	while(bar[1]-- > 0) {
	        		rs[i] = bar[0];
	        		i+=2;
	        		if(i >= barcodes.length) {
	        			i=1;
	        		}
	        	}
	        }
	        
	        return rs;
	    }
	}
}
