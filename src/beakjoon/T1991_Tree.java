package algospot;

import java.util.Scanner;

public class T1991_Tree {

	static Node[] arr = new Node[100];

	class Node {
		private char data;
		private Node left;
		private Node right;

		public Node() {
			super();
		}

		public Node(char data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public char getData() {
			return data;
		}

		public void setData(char data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

	public static void preOrder(Node root) {
		if (root == null)
			return;

		System.out.print(root.getData());
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}

	public static void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.getLeft());
		System.out.print(root.getData());
		inOrder(root.getRight());
	}

	public static void postOrder(Node root) {
		if (root == null)
			return;

		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getData());
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int index = scan.nextInt();
		char ch[] = new char[3];
		
		for(int i = 1; i <= 26; i++){
			if(arr[i] == null)
				arr[i] = new T1991_Tree().new Node();
			arr[i].setData('-');
			arr[i].setLeft(null);
			arr[i].setRight(null);
		}
		
		for (int i = 0; i < index; i++) {
			for (int j = 0; j < 3; j++) {
				ch[j] = scan.next().charAt(0);
			}
			if(arr[ch[0] - 'A' + 1] == null)
				arr[ch[0] - 'A' + 1] = new T1991_Tree().new Node();
			arr[ch[0] - 'A' + 1].setData(ch[0]);
			if (ch[1] != '.') {
				arr[ch[1] - 'A' + 1] = new T1991_Tree().new Node();
				arr[ch[1] - 'A' + 1].setData(ch[1]);
				arr[ch[0] - 'A' + 1].setLeft(arr[ch[1] - 'A' + 1]);;
			}
			if (ch[2] != '.') {
				arr[ch[2] - 'A' + 1] = new T1991_Tree().new Node();
				arr[ch[2] - 'A' + 1].setData(ch[2]);;
				arr[ch[0] - 'A' + 1].setRight(arr[ch[2] - 'A' + 1]);;
			}
		}

		preOrder(arr[1]);
		System.out.println();
		inOrder(arr[1]);
		System.out.println();
		postOrder(arr[1]);

	}

}
