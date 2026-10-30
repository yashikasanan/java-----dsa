class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        // find node
        // check if they are on same levels
        // check if they are siblings
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (level(root, xx, 0) == level(root, yy, 0)) && !isSibling(root, xx, yy);
    }
    TreeNode findNode(TreeNode node, int x){
        if (node == null){
            return null;
        }
        if (node.val == x){
            return node;
        }
        // checl left side
        TreeNode n = findNode(node.left, x);
        if (n != null){
            return n;
        }
        // check right side
        return findNode(node.right, x);
    }
    int level(TreeNode node, TreeNode x, int lev){
        if (node == null){
            return 0;
        }
        if (node == x){
            return lev;
        }
        int l = level(node.left, x, lev+1);
        if (l != 0){
            return l;
        }
        return level(node.right, x, lev+1);
    }
    boolean isSibling(TreeNode node, TreeNode x, TreeNode y){
        if (node == null){
            return false;
        }
        return (node.left == x && node.right == y) || (node.right == x && node.left == y)
        || isSibling(node.left, x, y) || isSibling(node.right, x, y);
    }
}
