package Medium;


/**
 * Sum of values between L and R both inclusive
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * <p>
 * class Solution {
 * public int rangeSumBST(TreeNode root, int L, int R) {
 * <p>
 * }
 * }
 */
public class RangeSumBST {

  public static void main(String[] args) {

  }

  public static int rangeSumBST(TreeNode root, int L, int R) {
    TreeNode subTreeRoot = findRoot(root, L, R);
    if (subTreeRoot.val == L) {
      return L + rangeSumRight(subTreeRoot.right, R);
    }

    if (subTreeRoot.val == R) {
      return R + rangeSumLeft(subTreeRoot.left, L);
    }

    return subTreeRoot.val + rangeSumLeft(subTreeRoot.left, L) + rangeSumRight(subTreeRoot.right, R);
  }

  public static TreeNode findRoot(TreeNode root, int L, int R) {
    if (root.val == L || root.val == R) {
      return root;
    }

    if (L < root.val && R < root.val) {
      return findRoot(root.left, L, R);
    }
    if (L > root.val && R > root.val) {
      return findRoot(root.right, L, R);
    }

    return root;
  }

  public static int rangeSumLeft(TreeNode root, int L) {
    if (root == null) return 0;
    if (root.val == L) {
      return L + rangeSumAllFromRoot(root.right);
    }

    if (root.val > L) {
      return root.val + rangeSumAllFromRoot(root.right) + rangeSumLeft(root.left, L);
    } else {
      return rangeSumLeft(root.right, L);
    }
  }

  public static int rangeSumRight(TreeNode root, int R) {
    if (root == null) return 0;
    if (root.val == R) {
      return R + rangeSumAllFromRoot(root.left);
    }

    if (root.val < R) {
      return root.val + rangeSumAllFromRoot(root.left) + rangeSumRight(root.right, R);
    } else {
      return rangeSumRight(root.left, R);
    }
  }

  public static int rangeSumAllFromRoot(TreeNode root) {
    if (root == null) return 0;
    return root.val + rangeSumAllFromRoot(root.left) + rangeSumAllFromRoot(root.right);
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
