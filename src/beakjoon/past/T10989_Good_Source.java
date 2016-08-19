package beakjoon.past;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class T10989_Good_Source {
    public static void main(String args[]) throws IOException
    {
         
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(in.readLine());
        int a[]=new int[10001];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10001;i++)
            a[i]=0;
         
        for(int i = 0; i < num; i++) {
            a[Integer.parseInt(in.readLine())]++;
        }
        for(int i = 0; i<10001; i++) {
            if(a[i]!=0){
                sb.append(i+"\n");
                a[i]--;
                i--;
            }
        }
        System.out.println(sb.toString().substring(0,sb.length()-1));
    }
}