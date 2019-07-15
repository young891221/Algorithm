import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Two_Sum_BST {

    public static void main(String[] args) {
        //TreeNode root = new TreeNode(5);
        //System.out.println(new Solution().findTarget([5,3,6,2,4,null,7], 9));
    }

    static class Solution {
        private Set<Integer> set = new HashSet<>();
        private boolean result;

        public boolean findTarget(TreeNode root, int k) {
            dp(root, k);
            return result;
        }

        private void dp(TreeNode root, int k) {
            if (root == null) return;
            int base = k - root.val;
            if (set.contains(base)) {
                result = true;
            }
            set.add(root.val);
            findTarget(root.left, k);
            findTarget(root.right, k);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //solution1
    /*public class Solution {
        public boolean findTarget(TreeNode root, int k) {
            Set < Integer > set = new HashSet();
            return find(root, k, set);
        }
        public boolean find(TreeNode root, int k, Set < Integer > set) {
            if (root == null)
                return false;
            if (set.contains(k - root.val))
                return true;
            set.add(root.val);
            return find(root.left, k, set) || find(root.right, k, set);
        }
    }*/

}
