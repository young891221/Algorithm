package codility;

class Solution2 {
	static boolean flag = false;

	public static int solution(String S) {

		class Stack {

			int[] arr;
			int top = -1;

			public Stack() {
				arr = null;
			}

			public void push(int data) {
				arr[++top] = data;
			}

			public void dup() {
				if (top > -1)
					push(arr[top]);
			}

			public int pop() {

				if (top == -1)
					return -1;

				return arr[top--];
			}

			public int top() {

				if (top == -1)
					return -1;

				return arr[top];
			}

			public void plus() {
				if (top > 0) {
					int temp1 = arr[top];
					int temp2 = arr[top - 1];
					pop();
					pop();
					push(temp1 + temp2);
				} else {
					flag = true;
				}
			}

			public void minus() {
				if (top > 0) {
					int temp1 = arr[top];
					int temp2 = arr[top - 1];
					pop();
					pop();
					push(temp1 - temp2);
				} else {
					flag = true;
				}
			}

		}

		Stack stack = new Stack();
		String arr[] = S.split(" ");
		stack.arr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("DUP")) {
				stack.dup();
			} else if (arr[i].equals("POP")) {
				stack.pop();
			} else if (arr[i].equals("+")) {
				stack.plus();
			} else if (arr[i].equals("-")) {
				stack.minus();
			} else {
				int sInt = Integer.parseInt(arr[i]);
				stack.push(sInt);
			}
		}

		if (flag)
			return -1;

		return stack.top();
	}

	public static void main(String[] args) {
		String s = "5 6 + -";
		solution(s);
	}

}
