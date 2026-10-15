
import java.util.*;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Visit the next smallest node
            current = stack.pop();
            k--;

            if (k == 0) {
                return current.val;
            }

            // Explore the right subtree
            current = current.right;
        }

        return -1;
    }
}
