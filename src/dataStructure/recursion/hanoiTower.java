package dataStructure.recursion;

public class hanoiTower {

	public static void main(String[] args) {
		move(3, "A", "B", "C");
	}
	
	public static void move(int num, String from, String by, String to) {
		if(num == 1) {
			System.out.printf("����1�� %s���� %s�� �̵�\n", from, to);
		} else {
			move(num-1, from, to, by);
			System.out.printf("����%d��(��) %s���� %s�� �̵�\n", num, from, to);
			move(num-1, by, from, to);
		}
	}
}


