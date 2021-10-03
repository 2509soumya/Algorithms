package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakeAndLadder {

    public int snakesAndLadders(int[][] board) {
        int end=board.length*board.length;
        Queue<Integer> bfsq=new LinkedList<>();
        bfsq.offer(1);
        Set<Integer> visited=new HashSet<>();
        visited.add(1);

        int move=0;
        boolean found=false;

        rootloop:
        while(!bfsq.isEmpty()){
            int size=bfsq.size();
            while(size>0){
                int position=bfsq.poll();
                int roll=1;
                while(roll<=6 && position+roll<=end){
                    int next=position+roll;
                    if(!visited.contains(next)){
                        int nextcoord=fetchcoordfromboard(next,board);
                        if(nextcoord==end){
                            found=true;
                            break rootloop;
                        }
                        visited.add(next);
                        bfsq.offer(nextcoord);
                    }
                    roll++;
                }
                size--;

            }
            move++;
        }
        return found?move+1:-1;
    }


    public int fetchcoordfromboard(int pos,int[][] board){
        int n=board.length;
        int r=board.length-1-((pos-1)/n);
        int c=(pos-1)%n;
        if((n%2==0 && r%2==0)||(n%2!=0 && r%2!=0)){
            c=n-1-c;
        }
        if(board[r][c]==-1){
            return pos;
        }else{
            return board[r][c];
        }
    }

    public static void main(String[] args) {
        SnakeAndLadder snakeAndLadder=new SnakeAndLadder();
        int ans=snakeAndLadder.snakesAndLadders(new int[][]{{-1,-1,19,10,-1},{2,-1,-1,6,-1},{-1,17,-1,19,-1},{25,-1,20,-1,-1},{-1,-1,-1,-1,15}});
        System.out.println("Answer is "+ans);
    }
}
