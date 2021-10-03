package bfs;

import java.util.HashSet;
import java.util.Set;

public class LexSmallest {

    Set<String> visited_nums=new HashSet<>();

    public String findLexSmallestString(String s, int a, int b) {
        dfs(s,a,b);
        //iterate visited and find lex small;
        String smallestnum=s;
        for(String num:visited_nums){
            if(num.compareTo(smallestnum)<0){
                smallestnum=num;
            }
        }
        return smallestnum;
    }

    public void dfs(String s, int a, int b){
        if(visited_nums.contains(s)){
            return;
        }else{
            visited_nums.add(s);
            dfs(op1(s,a,b),a,b);
            dfs(op2(s,a,b),a,b);
            return;
        }
    }


    public String op1(String s, int a, int b){
        String finalstr="";
        for(int i=0;i<s.length();i++){
            int num=s.charAt(i)-'0';
            if(i%2==1){
                num=(num+a)%10;
            }
            finalstr=finalstr+(char)(num+'0');
        }
        return finalstr;
    }

    public String op2(String s, int a, int b){
        b=b%s.length();

        if(b==0){
            return s;
        }else{
            String part1=s.substring(0,s.length()-b);
            String part2=s.substring(s.length()-b);
            return part2+part1;
        }
    }

    public static void main(String[] args) {
        System.out.println((1+"")+(2+""));
        LexSmallest lexSmallest=new LexSmallest();
        System.out.println(lexSmallest.findLexSmallestString("0011",4,2));
    }
}
