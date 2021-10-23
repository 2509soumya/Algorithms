package trie;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    class TrieNode{
        TrieNode[] children;
        String wordend;

        TrieNode(TrieNode[] children,String iswordend){
            this.children=children;
            this.wordend=wordend;
        }
        TrieNode(){
            this.children=new TrieNode[26];
        }
    }

    TrieNode trie;
    List<String> ans=new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        trie=new TrieNode();
        for(String dictword : wordDict){
            insert(dictword);
        }
        dfs(s,0,trie,"");
        return ans;
    }

    public void dfs(String s,int idx,TrieNode node,String ssf){
        if(idx>=s.length()){
            return;
        }
        int chridx=s.charAt(idx)-'a';

        if(node.children[chridx]!=null){
            node=node.children[chridx];

            if(node.wordend!=null && idx==s.length()-1){
                ssf=ssf+node.wordend;
                ans.add(ssf);
            }else if(node.wordend!=null){
                dfs(s,idx+1,node,ssf);
                dfs(s,idx+1,trie,ssf+node.wordend+" ");
            }else{
                dfs(s,idx+1,node,ssf);
            }
        }
    }


    public void insert(String word){
        TrieNode curr=trie;
        for(int i=0;i<word.length();i++){
            int chidx=word.charAt(i)-'a';
            if(curr.children[chidx]==null){
                curr.children[chidx]=new TrieNode();
            }
            curr=curr.children[chidx];
        }
        curr.wordend=word;
    }
}
