
import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        findPaths(root, "", result);

        return result;
    }

    private void findPaths(TreeNode root, String path,
                           List<String> result) {
        if (root == null) {
            return;
        }

        // Add the current node to the path
        if (path.isEmpty()) {
            path = String.valueOf(root.val);
        } else {
            path += "->" + root.val;
        }

        // If the node is a leaf, save the path
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        // Explore left and right subtrees
        findPaths(root.left, path, result);
        findPaths(root.right, path, result);
    }
}
