package beakjoon.past;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListStack {

	private Node top;
	private int size;
	
	private class Node {
		private Object data;
		private Node nextNode;

		Node(Object data) {
			this.data = data;
			this.nextNode = null;
		}
	}

	public ListStack() {
		this.top = null;
	}

	public int empty() {
		if (top == null)
			return 1;
		else
			return 0;
	}

	public void push(Object item) {
		Node newNode = new Node(item);
		newNode.nextNode = top;
		top = newNode;
		size++;
	}

	public Object top() {
		if (empty() == 1)
			throw new ArrayIndexOutOfBoundsException();
		return top.data;
	}

	public Object pop() {
		Object item = top();
		top = top.nextNode;
		size--;
		return item;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		//Stack<String> stack = new Stack<String>();
		List<Object> array = new ArrayList<Object>();
		Scanner scan = new Scanner(System.in);

		ListStack listStack = new ListStack();

		int T = scan.nextInt();
		scan.nextLine();
		while (1 <= T && T <= 10000) {
			String str = scan.nextLine();
			String[] instr = null;
			instr = str.split(" ");

			for (int j = 0; j < instr.length; j++) {

				switch (instr[j]) {
				case "push":
					listStack.push(instr[j + 1]);
					break;
				case "pop":
					try{
						array.add(listStack.pop());
						}catch(Exception e){
							array.add(-1);
						}
					break;
				case "top":
					array.add(listStack.top());
					break;
				case "size":
					array.add(listStack.size());
					break;
				case "empty":
					int empty = listStack.empty();
					if (empty == 1)
						array.add(1);
					else
						array.add(0);
				default:
					break;
				}
			}

			T--;
			if (T == 0) {
				for (int i = 0; i < array.size(); i++)
					System.out.println(array.get(i));
				break;
			}
		}
	}

}
