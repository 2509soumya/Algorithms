package heaps;

public class MaxHeap {


    int[] heapdynamicarr;
    int ridx=0;

    public MaxHeap(int size){
        heapdynamicarr=new int[size+1];
    }

    public void inserthelper(int val){
           //insert at leaf
            ridx++;
            heapdynamicarr[ridx]=val;
            balanceHeapAtInsert(ridx);
    }

    public void deleteHelper(){
           if(ridx<=1){
               ridx=0;
           }else{
               heapdynamicarr[1]=heapdynamicarr[ridx];
               ridx--;
               balanceHeapOnDelete(ridx);
           }
    }

    public void balanceHeapAtInsert(int leafidx){
        while(leafidx>=1){
            int parent=heapdynamicarr[leafidx/2];
            int child=heapdynamicarr[leafidx];
            if(child>parent){
                heapdynamicarr[leafidx]=parent;
                heapdynamicarr[leafidx/2]=child;
            }else{
                break;
            }
            leafidx=leafidx/2;
        }
    }


    public void balanceHeapOnDelete(int topidx){
       int idx=1;

       while(idx<=topidx){
           int left=2*idx;
           int right=2*idx+1;
           if(heapdynamicarr[idx]>heapdynamicarr[left] && heapdynamicarr[idx]>heapdynamicarr[right] ){
               break;
           }else{
               if(heapdynamicarr[left]>heapdynamicarr[idx]){
                   int val=heapdynamicarr[left];
                   heapdynamicarr[left]=heapdynamicarr[idx];
                   heapdynamicarr[idx]=val;
                   idx=left;
               }else{
                   int val=heapdynamicarr[right];
                   heapdynamicarr[right]=heapdynamicarr[idx];
                   heapdynamicarr[idx]=val;
                   idx=right;
               }
           }
       }

    }


    public void heapify(int[] arr){
        int idx=arr.length-1;

        while(idx>=1){
            int leftnode=2*idx;
            int rightnode=2*idx+1;
            if(leftnode<arr.length && rightnode<arr.length){
                 balanceHeapOnDelete(idx);
            }
            idx--;
        }
    }




}
