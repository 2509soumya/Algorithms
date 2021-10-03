package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {

        Stack<String> directorystack=new Stack<>();
        List<String> filenames=new ArrayList<>();

        input=input+"\n";
        int prevtabcount=-1;
        int currtabcount=0;
        String name="";
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(ch=='\n'){
                if(name.contains(".")){

                    Stack<String> tempstack= (Stack<String>) directorystack.clone();
                    String res="";
                    while(!tempstack.isEmpty()){
                        res=tempstack.pop()+"/"+res;
                    }

                    filenames.add(res+name);
                }else{
                        while(currtabcount<=prevtabcount && !directorystack.isEmpty()){
                            directorystack.pop();
                            prevtabcount--;
                        }
                    directorystack.push(name);
                    prevtabcount=currtabcount;
                }
                currtabcount=0;
                name="";
            }else if(ch=='\t'){
                currtabcount++;
            }else{
                name+=ch;
            }
        }

        int maxlength=0;
        for(String filename : filenames){
            System.out.println("Filenames added " +filename);
            maxlength=Math.max(maxlength,filename.length());
        }
        return maxlength;
    }

    public static void main(String[] args) {
        LongestAbsoluteFilePath longestAbsoluteFilePath=new LongestAbsoluteFilePath();
        int longestexpr=longestAbsoluteFilePath.lengthLongestPath("dir\n        file.txt\n");
        System.out.println("Longest expression is "+longestexpr);
    }

}
