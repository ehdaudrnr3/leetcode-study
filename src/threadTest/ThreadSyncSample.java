package threadTest;

/**
 * 쓰레드 테스트시 동기화 샘플을 하나의 화장실로 예로 들어 샘플코드를 만들어냄 
 * @author mgpc
 *
 */
class Key {
	
	/**
	 * 화장실 문을연다
	 * @param name
	 */
	public void open(String name) {
		System.out.println(name+" is toilet open");
	}
	
	/**
	 * 화장싫 문을 닫는다.
	 * @param name
	 */
	public void close(String name) {
		System.out.println(name+" is toilet close");
	}
	
	/**
	 * 싼다
	 * @param name
	 */
	public void defecate(String name) {
		System.out.println(name+" have defecate");
	}
	
	/**
	 * 거울을 본다
	 * @param name
	 */
	public void lookAtMirror(String name) {
		System.out.println(name+" look at mirror");
	}
	
	public void useToilet(String name) {
		open(name);
		close(name);
		defecate(name);
	}
	
	public synchronized void useToiletSync(String name) {
		open(name);
		close(name);
		defecate(name);
	}
	
	public void useToToiletForBlock(String name) {
		lookAtMirror(name);
		synchronized (this) {
			open(name);
			close(name);
			defecate(name);
		}
	}
}

class MyThread extends Thread {
	private String name;
	private Key key;
	
	public MyThread(String name, Key key) {
		this.name = name;
		this.key = key;
	}
	
	@Override
	public void run() {
		key.useToilet(name);
		//key.useToiletSync(name);
		//key.useToToiletForBlock(name);
	}
}
public class ThreadSyncSample {

	public static void main(String[] args) {

		Key key = new Key();
		MyThread t1 = new MyThread("kim", key);
		MyThread t2 = new MyThread("lee", key);
		MyThread t3 = new MyThread("park", key);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
