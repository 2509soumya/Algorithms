package segmenttree;

import org.w3c.dom.Node;

public class AVLTree {
    class AVLNode{
        int val;
        AVLNode left;
        AVLNode right;
        int height=0;
        int balance=0;
        AVLNode(int val){
            this.val=val;
        }
        AVLNode(int val,AVLNode left,AVLNode right,int height,int balance){
            this.val=val;
            this.left=left;
            this.right=right;
            this.height=height;
            this.balance=balance;
        }
    }

    AVLNode root;

    public void insertInBST(int value){
        if(root==null){
            root=new AVLNode(value);
        }else{

        }
    }

    AVLTree(){
      root=null;
    }

    public void insertHelper(int val){
        root=insert(root,val);
    }

    public AVLNode insert(AVLNode root,int value){
         if(root==null){
            return new AVLNode(value);
         }
         if(value > root.val){
             root.right=insert(root.right,value);
        }else{
            root.left=insert(root.left,value);
        }
         //update height and balance node
         return balanceNode(root);
    }

    public void updateHeightAndBalanceFactor(AVLNode node){
        int newheight;
        int balancefactor;

        if(node.left==null && node.right==null){
            newheight=0;
            balancefactor=0;
        }
        else if(node.left!=null && node.right!=null){
            newheight=Math.max(node.left.height,node.right.height)+1;
            balancefactor=node.left.height-node.right.height;
        }else if(node.left==null){
            newheight=node.right.height+1;
            balancefactor=-1*newheight;
        }else{
            newheight=node.left.height+1;
            balancefactor=newheight;
        }
        node.height=newheight;
        node.balance=balancefactor;
    }

    public AVLNode balanceNode(AVLNode node){
        updateHeightAndBalanceFactor(node);
        int balancefactor=node.balance;
        if(balancefactor>1){
            if(node.left.balance>0){
                  node=rotateRight(node);                  //LL rotation
            }else{
                node.left=rotateLeft(node.left);                 //LR rotation
                node=rotateRight(node);
            }
        }else if(balancefactor<-1){
            if(node.right.balance<0){
                node=rotateLeft(node);                //RR rotation
          }else{
                node.right=rotateRight(node.right);                //RL rotation
                node=rotateLeft(node);
            }
        }
        return node;
    }

    //ll rotation
    public AVLNode rotateRight(AVLNode node){
        AVLNode lright=node.left.right;
        AVLNode newroot=node.left;
        node.left=lright;
        newroot.right=node;
        node=newroot;
        updateHeightAndBalanceFactor(node.right);
        updateHeightAndBalanceFactor(node);
        return node;
    }

    //rr rotation
    public AVLNode rotateLeft(AVLNode node){
        AVLNode rleft=node.right.left;
        AVLNode newroot=node.right;
        node.right=rleft;
        newroot.left=node;
        node=newroot;
        updateHeightAndBalanceFactor(node.left);
        updateHeightAndBalanceFactor(node);
        return node;
    }

    public static void main(String[] args) {
        AVLTree avlTree=new AVLTree();
        avlTree.insertHelper(5);
        avlTree.insertHelper(4);
        avlTree.insertHelper(3);
        avlTree.insertHelper(2);
        avlTree.insertHelper(1);
        System.out.println("Post insert");
    }

}
