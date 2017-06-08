package beakjoon.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 순차적으로 배열의 수자를 체크하여 M번째 수를 빼서 나열시키는 것
 * 시간복잡도는 O(n)
 */
public class T1158_Josephuse_Queue {
	static Scanner scan;
	static int N, M, NM;
	static Queue<Integer> queue;
	static ArrayList<Integer> list;
	static StringBuilder builder;

	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		init();
		
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		for(int i = 1; i <= NM; i++) {
			if(i%M == 0) {
				list.add(queue.poll());
			} else {
				queue.add(queue.poll());
			}
		}
		
		result();
	}

	private static void result() {
		builder.append("<");
		for(int i = 0; i < list.size(); i++) {
			if(i == list.size()-1) {
				builder.append(list.get(i));
			} else {
				builder.append(list.get(i)+", ");
			}
		}
		builder.append(">");
		System.out.println(builder);
	}

	private static void init() {
		N = scan.nextInt();
		M = scan.nextInt();
		NM = N * M;
		queue = new LinkedList<Integer>();
		list = new ArrayList<Integer>();
		builder = new  StringBuilder();
	}

}
