package practice;

import java.util.LinkedList;
import java.util.Queue;

public class KSimilarString {

    public int kSimilarity(String s1, String s2) {
        //number of swaps

        Queue<String> bfsq=new LinkedList<>();
        bfsq.offer(s1);
        int level=0;
        while(!bfsq.isEmpty()){
            int size=bfsq.size();
            while(size>0){
                String comparewith=bfsq.poll();
                if(comparewith.equalsIgnoreCase(s2)){
                    return level;
                }

                //iterate through the string and create 1 swap strings and post in bfsq
                char ch[]=comparewith.toCharArray();
                int i=0;
                while(ch[i]==s2.charAt(i)){
                    i++;
                }
                for(int j=i+1;j<ch.length;j++){
                    if(ch[j]!=s2.charAt(i)){
                        continue;
                    }else{
                        swap(ch,i,j);
                        bfsq.offer(new String(ch));
                        swap(ch,i,j);
                    }
                }

                size--;
            }
            level++;
        }
        return level;
    }

    public void swap(char[] ch,int i,int j){
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }



    public static void main(String[] args) {
        KSimilarString kSimilarString=new KSimilarString();
        int ans=kSimilarString.kSimilarity("ab","ba");
        System.out.println("Answer is "+ans);
    }
}
