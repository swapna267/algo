package Medium;
/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

 The root is the maximum number in the array.
 The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 Construct the maximum tree by the given array and output the root node of this tree.
 * }
 */
class MaximumTree {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    TreeNode root = null;
    for (int i=0;i<nums.length;i++) {
      root = addNodeToTree(nums[i], root);
    }
    return root;
  }

  public TreeNode addNodeToTree(int num, TreeNode root) {
    if (root == null) {
      TreeNode newRoot = new TreeNode(num);
      return newRoot;
    }

    if (num > root.val) {
      TreeNode newRoot = new TreeNode(num);
      newRoot.left = root;
      return newRoot;
    } else {
      if (root.right == null) {
        root.right = new TreeNode(num);
        return root;
      }
      root.right = addNodeToTree(num, root.right);
      return root;
    }
  }


  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}