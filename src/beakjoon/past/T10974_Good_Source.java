package beakjoon.past;

import java.util.Scanner;
 
public class T10974_Good_Source {
    static int N;
    static int[] LArr;
    static int[] CArr;
    static int[] visit;
 
    public static void main(String[] args) {
         
        //System.setIn(new FileInputStream("input.txt"));
 
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
 
        //초기화
        init();
         
        //시작
        recursive(0);
    }
     
    //초기화
    static void init(){
        LArr = new int[N];
        CArr = new int[N];
        visit = new int[N];
        for(int i =0; i<N; i++) CArr[i] = i;
    }
     
    static void recursive(int level) {
        //모두 방문 했는지 확인
        if (complete()) {
            display(LArr);
            return;
        }
 
        for (int i = 0; i < CArr.length; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                LArr[level] = CArr[i];
                level++;
                recursive(level);
                level--;
                visit[i] = 0;
            }
        }
    }
 
    static boolean complete() {
        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == 0)
                return false;
        }
        return true;
    }
 
    static void display(int[] inArr) {
        StringBuilder sb = new StringBuilder();
//      sb.append("{");
        for (int i = 0; i < inArr.length; i++) {
            sb.append(inArr[i] + 1);
            if(i < inArr.length - 1){
                sb.append(" ");
            }
        }
//      sb.append("}");
        System.out.println(sb.toString());
    }
}