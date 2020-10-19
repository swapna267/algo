package Medium;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

  public static List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> pathSumMerged = new ArrayList<>();
    if (root == null) {
      return pathSumMerged;
    }
    if (root.left == null && root.right == null && sum == root.val) {
      List<Integer> path = new ArrayList<>();
      path.add(root.val);
      pathSumMerged.add(path);
      return pathSumMerged;
    }


    if (root.left != null) {
      List<List<Integer>> pathSumLeft = pathSum(root.left, sum - root.val);
      pathSumMerged.addAll(pathSumLeft);
    }

    if (root.right != null) {
      List<List<Integer>> pathSumRight = pathSum(root.right, sum - root.val);
      pathSumMerged.addAll(pathSumRight);
    }

    for (List<Integer> list : pathSumMerged) {
      list.add(0,root.val);
    }

    return  pathSumMerged;
  }

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
