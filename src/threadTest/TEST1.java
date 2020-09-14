package threadTest;

public class TEST1 {
	public static void main(String[] args) {
		System.out.println(solution1("z-+.^."));
	}
	
	public static String solution1(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z|^0-9|^/./|^/-/|^/_/]", "");
        new_id = new_id.replaceAll("[.]{2,}", ".");
        new_id = new_id.replaceAll("^.|$.", "");
        
        if(new_id.length() == 0) return "a";
        else if(new_id.length() >= 16) {
        	new_id = new_id.substring(0, 15);
        	new_id = new_id.replaceAll("%.", "");
        }else if(new_id.length() <= 2) {
        	String sub = new_id.substring(new_id.length()-1);
        	while(new_id.length() < 3) {
        		new_id+=sub;
        	}
        }
        return new_id;
    }
}
