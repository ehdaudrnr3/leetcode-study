package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		int count = 0;
		
		PriorityQueue<Print> queue = new PriorityQueue<Print>(priorities.length, new Comparator<Print>() {
			@Override
			public int compare(Print o1, Print o2) {
				if(o1.getPrior() > o2.getPrior()) {
					return 1;
				} else if(o1.getPrior() < o2.getPrior()) {
					return -1;
				}
				return 0;
			}
			
		});
		
		for (int i = 0; i < priorities.length; i++) {
			queue.offer(new Print(priorities[i], i));
		}
		
		for (int j = 0; j < queue.size(); j++) {
			if(queue.peek().getIndex() == location) {
				System.out.println(count);
			}
			count++;
		}
	}
	
	static class Print {
		int prior;
		int index;
		public int getPrior() {
			return prior;
		}
		public void setPrior(int prior) {
			this.prior = prior;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public Print(int prior, int index) {
			super();
			this.prior = prior;
			this.index = index;
		}
		
		
	}
	
	
}
