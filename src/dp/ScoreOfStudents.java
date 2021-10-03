package dp;

import java.util.*;

public class ScoreOfStudents {

    public int scoreOfStudents(String s, int[] answers) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty() && stack.peek()=='*'){
                int currnum=s.charAt(i)-'0';
                stack.pop();
                int leftnum=stack.pop()-'0';
                stack.push((char)('0'+(currnum*leftnum)));
            }else{
                stack.push(s.charAt(i));
            }
        }

        int finalans=0;
        while(!stack.isEmpty()){
            char poppedchar=stack.pop();
            if(poppedchar!='+'){
                finalans+=poppedchar-'0';
            }
        }
        Map<String,Set<Integer>> resintmap=new HashMap<>();

        Set<Integer> finalpossiblescores=scoreOfStudentsRecurse(s,resintmap);
        System.out.println("Possible output are :");
        for(Integer res: finalpossiblescores){
            System.out.println(res);
        }

        int totalscore=0;
        for(int i=0;i<answers.length;i++){
            if(answers[i]==finalans){
                totalscore+=5;
            }else if(finalpossiblescores.contains(answers[i])){
                totalscore+=2;
            }
        }
        return totalscore;
    }



    public Set<Integer> scoreOfStudentsRecurse(String s,Map<String,Set<Integer>> resintmap){
        if(s.length()==1){
            Set<Integer> res=new HashSet<>();
            res.add(s.charAt(0)-'0');
            return res;
        }else if(resintmap.containsKey(s)){
            return resintmap.get(s);
        }

        Set<Integer> reshere=new HashSet<>();
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='+' || s.charAt(i)=='*'){
                Set<Integer> leftsideres=scoreOfStudentsRecurse(s.substring(0,i),resintmap);
                Set<Integer> rightsideres=new HashSet<>();
                if(i+1<s.length()){
                    rightsideres=scoreOfStudentsRecurse(s.substring(i+1),resintmap);
                }
                if(rightsideres.size()>0){
                    for(Integer resleft : leftsideres){
                        for(Integer resright : rightsideres){
                            if(s.charAt(i)=='+'){
                                int ans=resleft+resright;
                                if(ans<=1000){
                                    reshere.add(ans);
                                }

                            }else{
                                int ans=resleft*resright;
                                if(ans<=1000){
                                    reshere.add(ans);
                                }
                            }
                        }
                    }
                }else{
                    for(Integer resleft : leftsideres){
                        if(resleft<=1000){
                            reshere.add(resleft);
                        }
                    }
                }
            }
        }
        resintmap.put(s,reshere);
        return reshere;
    }


    public static void main(String[] args) {
        ScoreOfStudents scoreOfStudents=new ScoreOfStudents();
        int ans=scoreOfStudents.scoreOfStudents("4+2*2+3*1+2",new int[]{42,17,13,66,32,547,21,90,13,33,45,66,34,21,13,13,13,46,21,177,18,13,18,16,16,678,13,42,66,13,18,18,777,21,924,13,268,13,13,13,25,62,45,33,888,779,13,206,48,13,34,17});
        System.out.println("Final score : "+ans);
        System.out.println("--------");
    }
}
