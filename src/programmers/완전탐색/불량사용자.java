package programmers.완전탐색;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class 불량사용자 {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	
	static class Solution {
		private boolean[] visited;
	    private Set<List<String>> result;
	
	    @Test
	    public void test() {
	        assertEquals(2, solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
	        System.out.println();
	        assertEquals(2, solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
	        System.out.println();
	        assertEquals(3, solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
	    }
	
	    public int solution(String[] user_id, String[] banned_id) {
	    	result = new HashSet<>();
	    	visited = new boolean[user_id.length];
	    	dfs(0, "", user_id, banned_id);
	    	return result.size();
	    }
	    
	    public void dfs(int n, String str, String[] users, String[] banneds) {
	    	if(n == banneds.length) {
	    		String[] strings = str.trim().split(" ");
	    		Arrays.sort(strings);
	    		
	    		List<String> list = new ArrayList<>();
	    		for (String s : strings) {
	    			list.add(s);
				}
	    		result.add(list);
	    		return;
	    	}
	    	
	    	String regx = banneds[n].replace("*", "[\\w\\d]");
	    	for (int i = 0; i < users.length; i++) {
	    		if(users[i].matches(regx) && !visited[i]) {
	    			visited[i] = true;
	    			dfs(n + 1, str + " " + users[i], users, banneds);
	    			visited[i] = false;
	    		}
			}
	    }
	}
}