package threadTest;

import java.util.LinkedList;
import java.util.Queue;

public class test {
	public static void main(String[] args) {
		int[][] a = {{0, 3}, {2, 5}, {4, 2}, {5, 3}};
		int[][] b = {{0, 3}, {2, 5}, {4, 2}, {5, 3}};
		int numa = 2;
		int numb = 1;
		
		int solution = solution(numa, a);
		System.out.println(solution);
	
	}
	
    public static int solution(int N, int[][] simulation_data) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        int i=0;
        while (i < N) {
        	int ptime = simulation_data[i][0] + simulation_data[i][1];
			q.offer(ptime);
			i++;
		}
        
        int len = simulation_data.length;
        int time = 0;
        while(!q.isEmpty() && i < len) {
        	if(q.peek() <= simulation_data[i][0]) {
        		q.poll();
        		int ptime = simulation_data[i][0] + simulation_data[i][1];
        		q.offer(ptime);
        		i++;
        	} else {
        		int wt = (q.poll() - simulation_data[i][0]);
        		time += wt;
        		int ptime = simulation_data[i][0] + simulation_data[i][1];
        		q.offer(ptime+wt);
        	}
        }
        return time;
    }
}
