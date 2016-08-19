package beakjoon.past;

import java.util.ArrayList;
import java.util.Scanner;
 
public class T10974 {
 
    private static ArrayList<Integer> picked;
    private static boolean[] isPick;
 
    // n: 전체 원소의 개수
    // picked: 지금까지 고른 원소의 개수
    // isPick: 이전에 선택된 원소인지 저장하고 있는 변수
    // n개의 원소의 모든 순열을 구하는 방법
    public static void permutation(int n, ArrayList<Integer> picked,
            boolean isPick[]) {
 
        if (picked.size() == n) {
            for (int i = 0; i < n; i++) {
                if(i == (n-1))
                    System.out.print(picked.get(i));
                else
                    System.out.print(picked.get(i) + " ");
            }
            System.out.println();
            return;
        }
 
        for (int next = 0; next < n; next++) {
            if (isPick[next])
                continue;
 
            picked.add(next + 1);
            isPick[next] = true;
 
            permutation(n, new ArrayList<Integer>(picked), isPick);
 
            picked.remove(picked.size() - 1);
            isPick[next] = false;
        }
    }
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (1 <= n && n <= 8) {
            picked = new ArrayList<Integer>();
            isPick = new boolean[n];
 
            permutation(n, picked, isPick);
        }
 
    }
 
}