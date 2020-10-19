package Medium;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode(int x) {
    val = x;
  }
}
public class MaximumBinaryTree {
  public static void main(String[] args) {
    int[] arr = {3,2,1,6,0,5};
    TreeNode node = constructMaxBinaryTree(arr);
    print(node);
  }

  public static void print(TreeNode node){
    if (node!=null) {
      System.out.println(node.val);
      print(node.left);
      print(node.right);
    }
  }

  public static TreeNode constructMaxBinaryTree(int[] nums) {
    return constructMaxBinaryTree(nums, 0, nums.length-1, null);
  }

  public static TreeNode constructMaxBinaryTree(int[] nums, int start,int end, TreeNode parent) {
    int max = nums[start];
    int maxIndex = start;
    for (int i=start+1;i<=end;i++) {
      if (max > nums[i]) {
        max = nums[i];
        maxIndex = i;
      }
    }

    TreeNode root = new TreeNode(max);
    if (parent != null) {
      if (start == 0) {
        parent.left = root;
      } else {
        parent.right = root;
      }
    }


    constructMaxBinaryTree(nums, 0, maxIndex-1, root);
    constructMaxBinaryTree(nums, maxIndex+1, end, root);
    return root;
  }
}
