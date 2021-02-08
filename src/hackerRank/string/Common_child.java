package hackerRank.string;

public class Common_child {
	public static void main(String[] args) {
		int answer = commonChild("ABCDEF", "FBDAMN");
		System.out.println("Answer : " + answer);
	}
	
	// Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
    	char[] s1Arr = s1.toCharArray();
    	char[] s2Arr = s2.toCharArray();
    	
    	int[][] n = new int[s1Arr.length + 1][s2Arr.length + 1];
    	for (int i = 1; i < n.length; i++) {
    		for (int j = 1; j < n[0].length; j++) {
    			if(s1Arr[i-1] == s2Arr[j-1]) {
    				n[i][j] = n[i-1][j-1] + 1;
    			} else {
    				n[i][j] = Math.max(n[i-1][j], n[i][j-1]);
    			}
			}
		}
    	
		return n[s1Arr.length][s2Arr.length];
    }

}
