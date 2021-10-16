package practice;

import java.util.*;

public class MergeBST {

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

    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer,TreeNode> lookup=new HashMap<>();
        List<Integer> nonroots=new ArrayList<>();
        for(TreeNode node : trees){
            lookup.put(node.val,node);
            if(node.left!=null){
                nonroots.add(node.left.val);
            }
            if(node.right!=null){
                nonroots.add(node.right.val);
            }
        }

        for(TreeNode node : trees){
            if(node.left!=null && lookup.containsKey(node.left.val)){
                if(lookup.get(node.left.val).right==null || lookup.get(node.left.val).right.val < node.val){
                    node.left=lookup.get(node.left.val);
                }
            }

            if(node.right!=null && lookup.containsKey(node.right.val)){
                if(lookup.get(node.right.val).left==null || lookup.get(node.right.val).left.val > node.val){
                    node.right=lookup.get(node.right.val);
                }
            }
        }

        System.out.println("nonroots - "+nonroots);

        int rootnode=-1;
        int rootcount=0;
        for(TreeNode node : trees){
            if(!nonroots.contains(node.val)){
                rootnode=node.val;
                rootcount++;
            }
        }
        System.out.println("rootcount - "+rootcount +" rootnode - "+rootnode);
        if(rootcount!=1){
            return null;
        }else{
            return lookup.get(rootnode);
        }
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(2,new TreeNode(1),null);
        TreeNode t2=new TreeNode(3,new TreeNode(2),new TreeNode(5));
        TreeNode t3=new TreeNode(5,new TreeNode(4),null);

        List<TreeNode> treeNodes=Arrays.asList(t1,t2,t3);
        MergeBST mergeBST=new MergeBST();
        TreeNode cumulatedtree=mergeBST.canMerge(treeNodes);
        System.out.println(cumulatedtree);
    }


}
