package practice;

import java.util.Stack;

public class RecoverBT {

    static class TreeNode{
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int val,TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
        TreeNode(int val){
            this.val=val;
        }
    }

    class StackElem{
        TreeNode node;
        int depth;
        int state;
        StackElem(TreeNode node,int depth,int state){
            this.node=node;
            this.depth=depth;
            this.state=state;
        }
    }

    class ParseOutput{
        int depth;
        int val;
        ParseOutput(int depth,int val){
            this.depth=depth;
            this.val=val;
        }
    }


    String traversal;
    int startpointer=0;

    public TreeNode recoverFromPreorder(String traversal) {
        this.traversal=traversal;
        Stack<StackElem> preorderstack=new Stack<>();
        TreeNode root=null;

        while(startpointer<=traversal.length()){
           if(preorderstack.isEmpty()){
               ParseOutput parseOutput=parseStr();
               root=new TreeNode(parseOutput.val);
               preorderstack.push(new StackElem(root,parseOutput.depth,1));
           }else{
               ParseOutput parseOutput=parseStr();
               if(parseOutput.depth==preorderstack.peek().depth+1){
                   System.out.println();
               }
           }
        }
       return root;
    }

    public ParseOutput parseStr(){
        int depth=0;
        while(traversal.charAt(startpointer)=='-'){
            startpointer++;
            depth++;
        }

        int num=0;
        while(traversal.charAt(startpointer)-'0'>=0 && traversal.charAt(startpointer)-'0'>=9){
            num=num*10+traversal.charAt(startpointer)-'0';
            startpointer++;
        }
        return new ParseOutput(depth,num);
    }
}
