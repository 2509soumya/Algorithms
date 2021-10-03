import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthBT {

    /*
    //TLE soln with deque
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> maxdequeue=new LinkedList<>();
        int maxwidth=0;

        maxdequeue.add(root);

        while(!maxdequeue.isEmpty()){
            int size=maxdequeue.size();
            maxwidth=Math.max(maxwidth,size);
            while(size>0){
                TreeNode elem=maxdequeue.poll();
                if(elem==null){
                    maxdequeue.offer(null);
                    maxdequeue.offer(null);
                }else{
                    maxdequeue.offer(elem.left);
                    maxdequeue.offer(elem.right);
                }
                size--;
            }
            //pop and poll boundry null's
            while(!maxdequeue.isEmpty() && maxdequeue.peekFirst()==null){
                maxdequeue.pollFirst();
            }
            while(!maxdequeue.isEmpty() && maxdequeue.peekLast()==null){
                maxdequeue.pollLast();
            }
        }
        return maxwidth;
    }
    */

    class CustomTreeNode{
        int index;
        TreeNode node;
        CustomTreeNode(int index,TreeNode node){
            this.index=index;
            this.node=node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<CustomTreeNode> maxqueue=new LinkedList<>();
        int maxwidth=0;

        maxqueue.add(new CustomTreeNode(1,root));
        while(!maxqueue.isEmpty()){
            int length=maxqueue.size();
            int size=length;
            int lidx=-1;
            int ridx=-1;
            while(size>0){
                CustomTreeNode topnode=maxqueue.poll();

                if(size==length){
                    lidx=topnode.index;
                }
                if(size==1) {
                    ridx=topnode.index;
                }

                if(topnode.node.left!=null){
                    maxqueue.offer(new CustomTreeNode(2*topnode.index,topnode.node.left));
                }
                if(topnode.node.right!=null){
                    maxqueue.offer(new CustomTreeNode(2*topnode.index+1,topnode.node.right));
                }
                size--;
            }
            maxwidth=Math.max(maxwidth,lidx-ridx+1);
        }

        return maxwidth;
    }
}
