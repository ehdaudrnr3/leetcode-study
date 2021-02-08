package programmers.DFSAndBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 여행경로 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] answers = sol.solution(new String[][] {
			{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}
		});
		for (String answer : answers) {
			System.out.print(answer + " -> ");
		}
	}
	
	static class Solution {
		private boolean[] visited;
		private List<String> collect;
	    public String[] solution(String[][] tickets) {
	        visited = new boolean[tickets.length];
	        collect = new ArrayList<>();
	        dfs(0, "ICN", "ICN", tickets);
	        Collections.sort(collect);
	        
	        return collect.get(0).split(" ");
	    }
	    
	    private void dfs(int len, String start, String answer, String[][] tickets) {
	    	if(len == tickets.length) {
	    		collect.add(answer);
	    		return;
	    	}
	    	
	    	for (int i = 0; i < tickets.length; i++) {
				if(!visited[i] && tickets[i][0].compareTo(start) == 0){
					visited[i] = true;
					dfs(len + 1, tickets[i][1], answer + " " + tickets[i][1], tickets);
					visited[i] = false;
				}
	    	}
	    }
	}
}
