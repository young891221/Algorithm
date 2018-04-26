package l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Task5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CustomQueue customQueue = new CustomQueue();

        while (true) {
            String input[] = br.readLine().split(" ");
            switch (input[0]) {
                case "add":
                    customQueue.add(Integer.parseInt(input[1]));
                    break;
                case "min":
                    System.out.println(customQueue.min());
                    break;
                case "remove":
                    System.out.println(customQueue.remove());
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("올바르지 않은 명령어입니다.");
                    System.exit(0);
            }
        }
    }

    private static class CustomQueue {
        private Queue<Integer> queue;
        private PriorityQueue<Integer> priorityQueue; //완전이진트리로 구현됨

        public CustomQueue() {
            this.queue = new LinkedList<>();
            this.priorityQueue = new PriorityQueue<>();
        }

        //O(log n) 일정한 시간
        public int min() {
            return priorityQueue.peek();
        }

        public void add(int value) {
            queue.add(value);
            priorityQueue.add(value); //O(log n)
        }

        public int remove() {
            Integer removeTarget = queue.remove();
            priorityQueue.remove(removeTarget); //O(n)
            return removeTarget;
        }

    }
}
