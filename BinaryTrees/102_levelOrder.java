/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // how many nodes are currently waiting in the queue at this level.
            int levelSize = queue.size();
            // currentlevel stores the values of all nodes at this level
            List<Integer> currentLevel = new ArrayList<>(levelSize); 
            for (int i=0; i<levelSize; i++){
                TreeNode currNode = queue.poll();
                // add the curr node
                currentLevel.add(currNode.val);
                // add the left and right elements (children) to the queue for further process.
                if (currNode.left != null){
                    queue.offer(currNode.left);
                }
                if (currNode.right != null){
                    queue.offer(currNode.right);
                }

            }
            result.add(currentLevel);
        }
        return result;
    }
}
