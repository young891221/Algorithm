package beakjoon.past;

import java.util.Scanner;

public class Keylogger_5397 {

	class Node {
		private Node next;
		private char data;

		public Node(char data) {
			this.data = data;
		}
	}

	class LinkedList {
		Node header;
		int size = 0;

		Node node(int index) {
			Node x = header;
			for (int i = 0; i < index; i++)
				x = x.next;

			return x;
		}

		void add(char data) {
			Node node = new Node(data);
			if (header == null) {
				node.next = header;
				header = node;
			}
			size++;
		}

		void add(char data, int loc) {
			if (loc == 0) {
				add(data);
			} else {
				Node temp1 = node(--loc - 1);
				Node temp2 = temp1.next;
				Node node = new Node(data);
				temp1.next = node;
				node.next = temp2;
				size++;
			}
		}

		void remove(int loc) {
			if (loc == 0) {
				Node node = header;
				header = node.next;
				node = null;
				size--;
			}

			Node temp = node(loc - 1);
			Node delete = temp.next;
			temp.next = temp.next.next;

			delete = null;
			size--;

		}

		char get(int loc) {
			Node node = header;
			while (loc-- > 0) {
				node = node.next;
			}
			return node.data;
		}
		
		String print() {
			String str = String.valueOf(header.data);
			Node temp = header;
			while(temp.next != null){
				temp = temp.next;
				str += temp.data;
			}
			
			return str;
		}

	}

	class keylogger {

		public String check(String temp) {
			int loc = -1;
			LinkedList list = new LinkedList();
			int len = temp.length();
			for (int i = 0; i < len; i++) {
				char data = temp.charAt(i);
				
				if (data == '<') {
					if(loc != -1)
						loc--;
				} else if (data == '>') {
					loc++;
				} else if (data == '-') {
					list.remove(--loc);
				} else {				
					list.add(data, ++loc);
				}
			}
			return list.print();
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		keylogger key = new Keylogger_5397().new keylogger();
		int l = scan.nextInt();
		String[] arr = new String[l];

		long start = System.currentTimeMillis();
		for (int i = 0; i < l; i++) {
			String command = scan.next();
			if (command.length() >= 1 && command.length() <= 1000000)
			arr[i] = key.check(command);
		}
		
		for(String str : arr)
			System.out.println(str);
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

}
