public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        if(key>root.val){
            root.right=deleteNode(root.right,key);
        }else if(key<root.val){
            root.left=deleteNode(root.left,key);
        }else{
            if(root.left==null && root.right==null){
                root=null;
            }
            else if(root.left!=null){
                //find and delete inorder predeccesor
                root.val=findInOrderPredecessor(root.left);
                root.left=deleteNode(root.left,root.val);
            }else{
                //find and delete inorder successor
                root.val=findInOrderSuccessor(root.right);
                root.right=deleteNode(root.right,root.val);
            }
        }
        return root;
    }

    public int findInOrderPredecessor(TreeNode node){
        while(node.right!=null){
            node=node.right;
        }
        return node.val;
    }

    public int findInOrderSuccessor(TreeNode node){
        while(node.left!=null){
            node=node.left;
        }
        return node.val;
    }

    public static void main(String[] args) {
        DeleteNodeInBST deleteNodeInBST=new DeleteNodeInBST();
        TreeNode root=deleteNodeInBST.deleteNode(new TreeNode(0),0);
        System.out.printf("here is it");
    }


}
