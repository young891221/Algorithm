package beakjoon.past;

import java.util.Scanner;

public class Queue_10845 {

	private int[] arr;
	private int front;
	private int rear;
	private int maxSize;
	private static int size = 0;

	public Queue_10845(int maxSize){
		this.front = 0;
		this.rear = -1;
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
	}
	

	void push(int item){
		arr[++rear] = item;
		size++;
	}
	
	int pop(){
		if(empty() == 1)
			return -1;
		
		int item = front();
		front++;
		size--;
		return item;
	}
	
	int empty(){
		if(front == rear+1)
			return 1;
		return 0;
	}
	
	int front(){
		if(empty() == 1)
			return -1;
		return arr[front];
	}
	
	int back(){
		if(empty() == 1)
			return -1;
		return arr[rear];
	}
	
	
	public static void main(String[] args) {
		
		int arrSize;
		Scanner scan = new Scanner(System.in);
		arrSize = scan.nextInt();
		Queue_10845 queue = new Queue_10845(arrSize);
		
		while((arrSize--) > 0){
			String command = scan.next();
			
			if(command.equals("push")){
				queue.push(scan.nextInt());
			}else if(command.equals("pop")){
				System.out.println(queue.pop());
			}else if(command.equals("size")){
				System.out.println(size);
			}else if(command.equals("empty")){
				System.out.println(queue.empty());
			}else if(command.equals("front")){
				System.out.println(queue.front());
			}else if(command.equals("back")){
				System.out.println(queue.back());
			}
			
		}
		
		

	}

}
