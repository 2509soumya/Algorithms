import com.sun.source.tree.Tree;

public class InOrderMorrisTraversal {
/*
morris traversal is an iterative approach towards traversing a binary tree , with O(1) space complexity
idea is before moving from the root towards the left of the tree we create a right pointer from the inorder predeccesor of root
to root , this will help us reach back to root after the entire left subtree is traversed, after we reach back to root we again try to find the
same predeccesor, this time we can find a link between the predeccesor and root , so break the link to not structurally impact the tree
and move towards right
 */

    public TreeNode findInOrderPredeccessor(TreeNode treeNode,TreeNode currNode){
        while(treeNode.right!=null && treeNode.right!=currNode){
            treeNode=treeNode.right;
        }
        return treeNode;
    }

    public void inordermorrisTraversal(TreeNode root){
       TreeNode currNode=root;
       while(currNode!=null){
           if(currNode.left==null){
               System.out.println(currNode.val);
               currNode=currNode.right;
           }else{
               TreeNode predeccesor=findInOrderPredeccessor(currNode.left,currNode);
               if(predeccesor.right==null){
                   predeccesor.right=currNode;
                   currNode=currNode.left;
               }else{
                   predeccesor.right=currNode;
                   System.out.println(currNode.val);
                   currNode=currNode.right;
               }
           }
       }
    }



    public TreeNode findPreOrderPredeccessor(TreeNode treeNode,TreeNode currNode){
        while(treeNode.right!=null && treeNode.right!=currNode){
            treeNode=treeNode.right;
        }
        return treeNode;
    }

    public void preordermorrisTraversal(TreeNode root){
        TreeNode currNode=root;
        while(currNode!=null){
            if(currNode.left==null){
                System.out.println(currNode.val);
                currNode=currNode.right;
            }else{
                TreeNode predeccesor=findPreOrderPredeccessor(currNode.left,currNode);
                if(predeccesor.right==null){
                    predeccesor.right=currNode;
                    System.out.println(currNode.val);
                    currNode=currNode.left;
                }else{
                    predeccesor.right=currNode;
                    currNode=currNode.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        InOrderMorrisTraversal inOrderMorrisTraversal=new InOrderMorrisTraversal();
        inOrderMorrisTraversal.preordermorrisTraversal(new TreeNode(1,new TreeNode(3,new TreeNode(2),null),new TreeNode(4,new TreeNode(5),null)));
    }

}
