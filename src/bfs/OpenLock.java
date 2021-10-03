package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OpenLock {

    //DFS gives OOM , try BFS



    Set<String> deadendslist;
    String target;

    public int openLock(String[] deadends, String target) {
        this.deadendslist=new HashSet<>();

        for(int i=0;i<deadends.length;i++){
            deadendslist.add(deadends[i]);
        }

        return dfs("0000",new ArrayList<>());
    }

    public int dfs(String lockpos, List<String> visited){
        if(lockpos==target){
            return 0;
        }else if(deadendslist.contains(lockpos) || visited.contains(lockpos)){
            return -1;
        }else{
            System.out.println("Visiting lock position: "+lockpos);
            visited.add(lockpos);
            int moveshere=-1;
            for(int i=0;i<lockpos.length();i++){
                char ch=lockpos.charAt(i);
                int idx=ch-'0';
                idx+=10;
                char forward=(char)((idx+1)%10+'0');
                char backward=(char)((idx-1)%10+'0');

                int movesfor=dfs(lockpos.substring(0,i)+forward+lockpos.substring(i+1),visited);
                if(movesfor!=-1){
                    movesfor++;
                    moveshere=(moveshere==-1)?movesfor:Math.min(moveshere,movesfor);
                }
                int movesback=dfs(lockpos.substring(0,i)+backward+lockpos.substring(i+1),visited);
                if(movesback!=-1){
                    movesback++;
                    moveshere=(moveshere==-1)?movesback:Math.min(moveshere,movesback);
                }
            }

            return moveshere;
        }
    }

    public static void main(String[] args) {
        OpenLock openLock=new OpenLock();
        openLock.openLock(new String[]{"0201","0101","0102","1212","2002"},"0202");
    }


}
