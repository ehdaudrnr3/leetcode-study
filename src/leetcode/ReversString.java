package leetcode;

public class ReversString {
    
	public static void main(String[] args) {
		char[] test = {
				'h', 'e', 'l','l','o'
		};
		Test testC =new Test();
		test = testC.reverseString(test);
		for(char ch : test) {
			System.out.println(ch);
		}	
	}
    
}	

class Test {
	char[] ans;
    int index =0;
    
	public char[] reverseString(char[] s) {
        ans = new char[s.length];
        recursion(0, s);
        return ans;
    }
    
    public void recursion(int i, char[] s) {
        if(s ==null || i >=s.length) {
            return;
        }
        recursion(i+1, s);
        ans[index++] = s[i];
    }
}


