package segmenttree;

public class RBTree {

    class RBNode{
        int val;
        boolean color;//true-black false-red
        RBNode left;
        RBNode right;
        RBNode parent;
        public RBNode(int val,boolean color){
            this.val=val;
            this.color=color;
        }

        public boolean isLeftChild(){
           return this.parent.left==this;
        }

        public boolean flipColor(){
            return !color;
        }
    }

    public RBNode insert(RBNode currNode,RBNode insertNode){
       if(currNode==null){
           return insertNode;
       }
       if(insertNode.val > currNode.val){
           currNode.right=insert(currNode.right,insertNode);
           currNode.right.parent=currNode;
       }else{
           currNode.left=insert(currNode.right,insertNode);
           currNode.left.parent=currNode;
       }
       return currNode;
    }

    RBNode root;

    public void insertHelper(int val){
        RBNode newnode=new RBNode(val,false);
        root=insert(root,newnode);
        //recolorAndrotateNode

    }

    public void recolorAndrotate(RBNode node){
        RBNode parent=node.parent;

        //red is false and black is true
        if(parent!=root && !parent.color){
          RBNode grandparent=parent.parent;
          RBNode uncle=parent.isLeftChild()?grandparent.right:grandparent.left;
          if(uncle!=null && !uncle.color){
              //recolor and recurse
              handleRecoloring(parent,uncle,grandparent);
          }else if(parent.isLeftChild()){
              //rotate and recolor
              handleLeftHeavy(node,parent,grandparent);
          }else{
             //rotate and recolor
              handleRightHeavy(node,parent,grandparent);
          }
        }
        root.color=true;
    }

    public void handleLeftHeavy(RBNode node,RBNode parent,RBNode grandparent){
        if(!node.isLeftChild()){
            rotateLeft(parent);
        }

         parent.flipColor();
         grandparent.flipColor();
         //rotateRight
        rotateRight(grandparent);
    }

    public void handleRightHeavy(RBNode node,RBNode parent,RBNode grandparent){
        if(node.isLeftChild()){
            rotateRight(parent);
        }

        parent.flipColor();
        grandparent.flipColor();
        //rotateLeft
        rotateLeft(grandparent);
    }

    public void handleRecoloring(RBNode parent,RBNode uncle,RBNode grandparent){
        uncle.flipColor();
        parent.flipColor();
        grandparent.flipColor();
        recolorAndrotate(grandparent);
    }

    public RBNode rotateRight(RBNode node){
        RBNode lright=node.left.right;
        RBNode newroot=node.left;
        node.left=lright;
        if(lright!=null){
            lright.parent=node;
        }
        newroot.right=node;
        newroot.parent=node.parent;
        node.parent=newroot;
        node=newroot;
        return node;
    }

    public void updateChildrenOfParent(RBNode node, RBNode newnode){
       if(node.parent==null){
           root=newnode;
       }else if(node.isLeftChild()){
           node.parent.left=newnode;
       }else if(!node.isLeftChild()){
           node.parent.right=newnode;
       }
    }

    public RBNode rotateLeft(RBNode node){
        RBNode rleft=node.right.left;
        RBNode newroot=node.right;
        node.right=rleft;
        if(rleft!=null){
            rleft.parent=node;
        }
        newroot.left=node;
        newroot.parent=node.parent;
        node.parent=newroot;
        node=newroot;
        return node;
    }
}
