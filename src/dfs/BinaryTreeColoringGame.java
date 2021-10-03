package dfs;

//https://leetcode.com/problems/binary-tree-coloring-game/
public class BinaryTreeColoringGame {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    int num_nodes_left;
    int num_nodes_right;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        findNode(root,x);
        int remaning_nodes=n-(num_nodes_left+num_nodes_right+1);
        int max_side=Math.max(remaning_nodes,Math.max(num_nodes_left,num_nodes_right));
        if(max_side>(n-max_side)){
            return true;
        }else{
            return false;
        }
    }

    public int findNode(TreeNode root,int searchnode){
        if(root==null){
            return 0;
        }
        int num_nodesleft=findNode(root.left,searchnode);
        int num_nodesright=findNode(root.right,searchnode);
        if(root.val==searchnode){
            this.num_nodes_left=num_nodesleft;
            this.num_nodes_right=num_nodesright;
        }
        return num_nodesleft+num_nodesright+1;
    }


}
