package dfs;

import java.util.*;

public class WordDictionary {

    class Trie{
        int end=0;
        Trie[] children=new Trie[26];
        Trie(){
        }
    }

    Trie root=null;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new Trie();
    }

    public void addWord(String word) {
        Trie roottrie =root;
        int charidx=0;
        while(charidx<word.length()){
                int okfinal=word.charAt(charidx)-'a';
                Trie childtrie=roottrie.children[okfinal];
                 if(childtrie!=null) {
                     roottrie=childtrie;
                 }else {
                     Trie newtrie=new Trie();
                     roottrie.children[okfinal]=newtrie;
                     roottrie=newtrie;
                 }
                 if(charidx==word.length()-1){
                     roottrie.end=1;
                 }
            charidx++;
        }
    }



    public boolean search(String word) {
        //bfs
        Queue<Trie> triequeue=new LinkedList<>();
        int charidx=0;
        triequeue.offer(root);

        int endinghere=0;
        while(!triequeue.isEmpty() && charidx<word.length()){
            int size=triequeue.size();
            endinghere=0;
            while(size>0){
                Trie elem=triequeue.poll();
                if(word.charAt(charidx)=='.'){
                    for(Trie child:  elem.children){
                        if(child!=null){
                            endinghere+=child.end;
                            triequeue.offer(child);
                        }
                    }
                }else{
                    int okfinal=word.charAt(charidx)-'a';
                    Trie childtrie=elem.children[okfinal];
                    if(childtrie!=null) {
                        endinghere+=childtrie.end;
                        triequeue.offer(childtrie);
                    }
                }
                size--;
            }
            if(triequeue.isEmpty()){
                break;
            }
            charidx++;
        }
        return charidx>=word.length() && endinghere>0;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary=new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        wordDictionary.addWord("a");
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));
    }
}
