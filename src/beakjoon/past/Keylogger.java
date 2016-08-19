package beakjoon.past;

import java.util.Scanner;

public class Keylogger {

	class Node {

		char data;
		Node node;

		public Node(char data) {
			this.data = data;
		}
	}

	class LinkedList {

		Node header;

		public void add(Node node) {

			if (header == null) {
				header = node;
			} else {
				Node tempNode = header;

				while (tempNode.node != null) {
					tempNode = tempNode.node;
				}

				tempNode.node = node;
			}
		}

		public void add(Node node, int loc) {

			if (loc == 0) {
				node.node = header;
				header = node;
			} else {
				Node before = header;

				while (--loc > 0 && before.node != null)
					before = before.node;

				node.node = before.node;
				before.node = node;
			}

		}

		public char get(int loc) {

			Node tempNode = header;
			while (loc-- > 0) {
				tempNode = tempNode.node;
			}
			return tempNode.data;
		}

		public void remove(int loc) {

			Node tempNode = header;

			while (loc-- > 1) {
				tempNode = tempNode.node;
			}
			if (tempNode.node == null)
				tempNode.node = null;
			else
				tempNode.node = tempNode.node.node;

		}

		public String print() {

			String res = String.valueOf(header.data);

			Node tempNode = header;
			while (tempNode.node != null) {
				tempNode = tempNode.node;
				res += tempNode.data;

			}
			return res;
		}
	}

	class KeyLogger {

		public String check(String command) {

			LinkedList list = new LinkedList();
			int loc = -1;

			for (int i = 0; i < command.length(); i++) {

				char word = command.charAt(i);

				if (word == '<') {
					if (loc != -1)
						loc--;
				} else if (word == '>') {
					loc++;
				} else if (word == '-') {
					list.remove(--loc);
				} else {
					list.add(new Node(word), ++loc);
				}
			}

			return list.print();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KeyLogger kl = new Keylogger().new KeyLogger();
		int cnt = 0;
		
		Scanner sc = new Scanner(System.in);
		cnt = sc.nextInt();
		String[] arr = new String[cnt];
		
		for (int i = 0; i < cnt; i++) {
			String command = sc.next();
			if (command.length() >= 1 && command.length() <= 1000000)
				arr[i] = kl.check(command);
		}

		for (String temp : arr)
			System.out.println(temp);

	}

}