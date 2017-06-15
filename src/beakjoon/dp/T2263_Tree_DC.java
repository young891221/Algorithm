package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by youngjae on 2017. 5. 9..
 */
public class T2263_Tree_DC {
    private static int n;
    private static int[] inOrder, postOrder, position = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer in = new StringTokenizer(bf.readLine());
        StringTokenizer post = new StringTokenizer(bf.readLine());

        inOrder = new int[n];
        postOrder = new int[n];
        for(int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(in.nextToken());
            postOrder[i] = Integer.parseInt(post.nextToken());
            position[inOrder[i]] = i;
        }

        solve(0, n-1, 0, n-1);
    }

    private static void solve(int in_start, int in_end, int post_start, int post_end) {
        if(in_start > in_end || post_start > post_end) return;
        int root = postOrder[post_end];
        System.out.print(root+" ");
        int p = position[root];

        int left = p-in_start;
        solve(in_start, p-1, post_start, post_start + left - 1);
        solve(p+1, in_end, post_start+left, post_end-1);
    }
}
