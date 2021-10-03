package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinJumpReachHome {

    static class Position{
        int pos;
        boolean lastjump;
        Position(int pos,boolean lastjump){
            this.pos=pos;
            this.lastjump=lastjump;
        }

        @Override
        public boolean equals(Object o){
            Position pospos=(Position)o;
            if(this.pos==pospos.pos && this.lastjump==pospos.lastjump){
                return true;
            }else{
                return false;
            }
        }
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        Set<Integer> forbiddenlist=new HashSet<>();
        for(int i=0;i<forbidden.length;i++){
            forbiddenlist.add(forbidden[i]);
        }


        Set<Position> visited=new HashSet<>();

        Queue<Position> bfsq=new LinkedList<>();
        if(!forbiddenlist.contains(a)){
            visited.add(new Position(a,true));
            bfsq.offer(new Position(a,true));
        }

        int level=1;

        while(!bfsq.isEmpty()){
            int size=bfsq.size();
            while(size>0){
                Position position=bfsq.poll();
                int pos_x=position.pos;
                if(pos_x==x){
                    return level;
                }
                int forward_x=a+pos_x;
                int backward_x=pos_x-b;

                if(!forbiddenlist.contains(forward_x) && !visited.contains(new Position(forward_x,true)) && (forward_x<4000)){
                    visited.add(new Position(forward_x,true));
                    bfsq.offer(new Position(forward_x,true));
                }
                if(backward_x>=0 && !forbiddenlist.contains(backward_x) && position.lastjump && !visited.contains(new Position(backward_x,false))){
                    visited.add(new Position(backward_x,false));
                    bfsq.offer(new Position(backward_x,false));
                }
                size--;
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {

        Position abc=new Position(123,false);
        Position def=new Position(456,false);
        System.out.println(abc.equals(def));
    }
}
