package programmers.DFSAndBFS;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ¹è´Þ {
	public static void main(String[] args) {
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int n = 5;
		int k = 3;
		Solution s= new Solution();
		int answer = s.solution(n, road, k);
		System.out.println("answer: "+ answer);
		
	}
	
	static class Solution {
		
	    public int solution(int N, int[][] road, int K) {
	    	final int max = Integer.MAX_VALUE;
	    	int[][] adj = new int[N][N];
	    	for (int[] i : adj) {
				Arrays.fill(i, max);
			}
	    	
	    	for (int[] r : road) {
				int x = r[0] - 1;
				int y = r[1] - 1;
				int w = r[2];
				
				if(w < adj[x][y]) {
					adj[x][y] = adj[y][x] = w;
				}
			}
	    	
	    	boolean[] visited = new boolean[N];
	    	int[] dist = new int[N];
	    	Arrays.fill(dist, max);
	    	
	    	PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> dist[a] - dist[b]);
	    	dist[0] = 0;
	    	q.add(0);
	    	
	    	while(!q.isEmpty()) {
	    		int curr = q.poll();
	    		if(!visited[curr]) {
	    			visited[curr] = true;
	    			for (int i = 0; i < N; i++) {
    					if(adj[curr][i] == max) continue;
    					if(dist[i] > dist[curr] + adj[curr][i]) {
    						dist[i] = dist[curr] + adj[curr][i];
    						q.offer(i);
    					}
					}
	    		}
	    	}
	    	
	    	long count = Arrays.stream(dist).filter(v->v<=K).count();
	    	return (int) count;
	    }
	    
	}
}
