package programmers.DFSAndBFS;

import java.util.Arrays;

public class 단어변환 {
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = new String[] {
				"hot", "dot", "dog", "lot", "log", "cog"
		};
		Solution sol = new Solution();
		int answer = sol.solution(begin, target, words);
		System.out.println("Answer : " + answer);
	}
	
	static class Solution {
		private int answer;
		private String target;
		private String[] words; 
		private boolean[] visited;
		
	    public int solution(String begin, String target, String[] words) {
	    	this.target = target;
	    	this.words = words;
	    	this.visited = new boolean[words.length];
	        this.answer = Integer.MAX_VALUE;
	        
	        boolean avaliable = Arrays.stream(words).anyMatch(t->t.compareTo(target) == 0);
	        if(!avaliable) {
	        	return 0;
	        }
	        System.out.println("answer : "+ answer);
	        dfs(0, begin);
	        System.out.println("answer : "+ answer);
	        return answer;
	    }
	    
	    public void dfs(int n, String begin) {
	    	if(begin.compareTo(target) == 0) {
	    		answer = Math.min(answer, n);
	    		return;
	    	}
	    	
	    	for (int i = 0; i < words.length; i++) {
	    		if(!visited[i] && match(begin, words[i])) {
	    			visited[i] = true;
	    			System.out.println("begin : "+ begin + " word : "+ words[i]);
	    			dfs(n + 1, words[i]);
	    			visited[i] = false;
	    		}
			}
	    }
	    
	    private boolean match(String begin, String target) {
	    	int count = 0;
	    	char[] beginArr = begin.toCharArray();
	    	for (int i = 0; i < beginArr.length; i++) {
				if(beginArr[i] != target.charAt(i)) {
					count++;
				}
			}
	    	return count < 2 ? true : false;
	    }
	}
}
