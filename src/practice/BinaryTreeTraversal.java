package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
    class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
        TreeNode(int val){
            this.val=val;
        }
    }

    public void preOrder(TreeNode root){
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void InOrder(TreeNode root){
        InOrder(root.left);
        System.out.println(root.val);
        InOrder(root.right);
    }
    public void PostOrder(TreeNode root){
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.println(root.val);
    }

    public List<Integer> preorderWithStack(TreeNode root){
        List<Integer> ans=new ArrayList<>();

        Stack<TreeNode> preorderstack=new Stack<>();
        preorderstack.push(root);
        while(!preorderstack.isEmpty()){
            TreeNode node=preorderstack.pop();
            ans.add(node.val);
            if(node.right!=null)
            preorderstack.push(node.right);
            if(node.left!=null)
            preorderstack.push(node.left);
        }
       return ans;
    }

    public List<Integer> inorderWithStack(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> inorderstack=new Stack<>();

        inorderstack.push(root);

        while(!inorderstack.isEmpty()){
            TreeNode node=inorderstack.peek();
            if(node.left==null){
                inorderstack.pop();
                ans.add(node.val);
                if(node.right!=null){
                    inorderstack.push(node.right);
                }
            }else {
                inorderstack.push(node.left);
                node.left=null;
            }
        }
        return ans;
    }

    public List<Integer> postOrderWithStack(TreeNode root){
        List<Integer> ans=new ArrayList<>();

        Stack<TreeNode> postorderstack=new Stack<>();
        postorderstack.push(root);

        while(!postorderstack.isEmpty()){
            TreeNode node=postorderstack.peek();
            if(node.left==null && node.right==null){
                postorderstack.pop();
                ans.add(node.val);
            }else{
                if(node.left!=null){
                    postorderstack.push(node.left);
                    node.left=null;
                }else{
                    postorderstack.push(node.right);
                    node.right=null;
                }
            }
        }
        return ans;
    }


}
