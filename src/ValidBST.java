import java.util.Deque;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root,long lowerlimit,long upperlimit) {
        if(root==null){
            return true;
        }

        if(root.val>lowerlimit && root.val<upperlimit){
            return isValidBST(root.left,lowerlimit,root.val) && isValidBST(root.right,root.val,upperlimit);
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        ValidBST validBST=new ValidBST();
        boolean res=validBST.isValidBST(new TreeNode(2,new TreeNode(1),new TreeNode(3)));
        System.out.printf("Result is "+res);
    }
}
