package beakjoon.past;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.Popup;

public class Tstack {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		List<Object> array = new ArrayList<Object>();
		Scanner scan = new Scanner(System.in);

		int T = scan.nextInt();
		scan.nextLine();
		while (1 <= T && T <= 10000) {
			String str = scan.nextLine();
			String[] instr = null;
			instr = str.split(" ");

			for (int j = 0; j < instr.length; j++) {

				switch (instr[j]) {
				case "push":
					stack.push(instr[j + 1]);
					break;
				case "pop":
					try{
						stack.pop();
						}catch(Exception e){
							array.add(-1);
						}
					break;
				case "top":
					array.add(stack.peek());
					break;
				case "size":
					array.add(stack.size());
					break;
				case "empty":
					boolean empty = stack.empty();
					if (empty)
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