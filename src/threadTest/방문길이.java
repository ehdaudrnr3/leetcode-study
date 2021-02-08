package threadTest;

public class 방문길이 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int answer = sol.solution("LULLLLLLU");
		System.out.println(answer);
		
		int[][][][] arr = new int[][][][]{ 
			{
				{ 
					{1}
				}
			}
		};
	}
	
	static class Solution {
		int cx = 5;
        int cy = 5;
        boolean[][] visited = new boolean[11][11];
        
        
		public int solution(String dirs) {
	        int answer = 0;
	        
	        for (char c : dirs.toCharArray()) {
				if(!isVisited(c)) {
					int[] po = getPosition(c);
					visited[po[1]][po[0]] = true;
					cx = po[0];
					cy = po[1];
					answer++;
				}
			}
	        return answer;
	    }
	    
	    private boolean isVisited(char c) {
	    	int x = cx;
	    	int y = cy;
	    	
	    	if(c == 'U') {
	    		y = cy-1;
			} else if(c == 'D') {
				y = cy+1;
			} else if(c == 'L') {
				x = cx-1;
			} else {
				x = cx+1;
			}
	    	
	    	if(x < 0 || x > 10 || y < 0 || y > 10) return true;
	    	
	    	return visited[y][x];
	    }
	    
	    private int[] getPosition(char c) {
	    	int x = cx;
	    	int y = cy;
	    	
	    	if(c == 'U') {
	    		y = cy-1;
			} else if(c == 'D') {
				y = cy+1;
			} else if(c == 'L') {
				x = cx-1;
			} else {
				x = cx+1;
			}
	    	
	    	return new int[] {x, y};
	    }
	}
}
