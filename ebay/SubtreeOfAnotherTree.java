/*Subtree of Another Tree
Category	Difficulty	Likes	Dislikes
algorithms	Easy (48.56%)	8333	537
Tags
tree

Companies
ebay | facebook | google

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.*/

 class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null || subRoot==null) {
            return false;
        }
        if(root.val==subRoot.val && check(root,subRoot)) {
            return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    private boolean check(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) {
            return true;
        }
        if(root==null || subRoot==null || root.val!=subRoot.val) {
            return false;
        }
        return check(root.left,subRoot.left) && check(root.right,subRoot.right);
    }
}