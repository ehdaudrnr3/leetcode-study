package threadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SO {

	private static Map<String, List<Node>> map = new HashMap<>();
	private static Map<String, Integer> amtMap = new HashMap<>();
	private static List<Data> data = data();

	public static void main(String[] args) {
		List<Node> list = get();
		
		long start = System.currentTimeMillis();
		for (Node node : list) {
			dfs(node);
			sum(node);
		}
		long end = System.currentTimeMillis();
		System.out.println("time: "+(end - start) / 1000);
		
		Collections.sort(list, Comparator.comparing(Node::getPrintNo).thenComparing(Node::getNode));
		for (Node node : list) {
			System.out.println(node.toString());
		}
	}

	public static void dfs(Node node) {
		if (map.containsKey(node.getNode())) {
			node.getChild().addAll(map.get(node.getNode()));
			return;
		}

		for (Node item : get()) {
			if (item.getParent().equals(node.getNode())) {
				dfs(item);
				node.getChild().add(item);
			}
		}
		
		if (!node.getChild().isEmpty())
			map.put(node.getNode(), node.getChild());
	}
	
	public static void sum(Node node) {
		if (amtMap.containsKey(node.getNode())) {
			node.setAmt(amtMap.get(node.getNode()));
			return;
		}
		
		int amt = node.getAmt();
		for (Node item : node.getChild()) {
			sum(item);
			amt += item.getAmt();
		}
		
		List<Data> remove = new ArrayList<>();
		for (Data item : data) {
			if(node.getNode().equals(item.getNode())) {
				amt+=item.getAmt();
				remove.add(item);
			}
		}
		
		node.setAmt(amt);
		amtMap.put(node.getNode(), amt);
		data.removeAll(remove);
	}

	public static List<Node> get() {
		Node root = new Node("1000", 1, "001", "");
		Node n = new Node("1100", 2, "002", "1000");
		Node n1 = new Node("1101", 3, "002", "1100");
		Node n2 = new Node("1102", 3, "003", "1100");
		Node n3 = new Node("1111", 4, "002", "1101");
		Node n4 = new Node("1112", 4, "002", "1101");
		Node n7 = new Node("1113", 4, "002", "1101");
		Node n5 = new Node("1200", 2, "004", "1000");
		Node n8 = new Node("1201", 3, "004", "1200");
		Node n6 = new Node("1300", 2, "005", "1000");

		List<Node> list = new ArrayList<>();
		list.add(root);
		list.add(n);
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);
		list.add(n6);
		list.add(n7);
		list.add(n8);
		return list;
	}
	
	public static List<Data> data() {
		Data n1 = new Data("1111", 2000);
		Data n2 = new Data("1112", 2000);
		Data n3 = new Data("1113", 2000);
		Data n4 = new Data("1102", 2000);
		Data n5 = new Data("1201", 2000);
		Data n6 = new Data("1300", 2000);
		Data n7 = new Data("1101", 3000);
		Data n8 = new Data("1111", 5000);

		List<Data> list = new ArrayList<>();
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);
		list.add(n6);
		list.add(n7);
		list.add(n8);

		return list;
	}
}

class Node {
	String node;
	String parent;
	String printNo;
	int lv;
	int amt;
	List<Node> child = new ArrayList<>();

	public Node(String node, int lv, String printNo, String parent) {
		super();
		this.node = node;
		this.lv = lv;
		this.printNo = printNo;
		this.parent = parent;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public List<Node> getChild() {
		return child;
	}

	public void setChild(List<Node> child) {
		this.child = child;
	}
	
	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public String getPrintNo() {
		return printNo;
	}

	public void setPrintNo(String printNo) {
		this.printNo = printNo;
	}

	@Override
	public String toString() {
		return "Node [node=" + padLeft(node, node.length()+lv, ' ') + ", amt = "+amt+"]";
	}

	public String padLeft(String word, int totalWidth, char paddingChar) {
		String padWord = word;
		padWord = String.format("%" + totalWidth + "s", word).replace(' ', paddingChar);
		return padWord;
	}
}

/**
 * @author mgpc
 *
 */
class Data  {
	String node;
	int amt;
	
	public Data(String node, int amt) {
		this.node = node;
		this.amt = amt;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
}