
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        findPaths(root, targetSum, path, result);

        return result;
    }

    private void findPaths(TreeNode root, int targetSum,
                           List<Integer> path,
                           List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        // Check if the current node is a leaf
        if (root.left == null && root.right == null
                && targetSum == root.val) {
            result.add(new ArrayList<>(path));
        } else {
            findPaths(root.left, targetSum - root.val, path, result);
            findPaths(root.right, targetSum - root.val, path, result);
        }

        // Backtrack to explore other paths
        path.remove(path.size() - 1);
    }
}
