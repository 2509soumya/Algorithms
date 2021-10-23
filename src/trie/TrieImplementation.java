package trie;

class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    TrieNode(TrieNode[] children,boolean isEnd){
        this.children=children;
        this.isEnd=isEnd;
    }
    TrieNode(){
        this.children=new TrieNode[26];
        this.isEnd=false;
    }
}


public class TrieImplementation {

    TrieNode root;

    public TrieImplementation(){
        root=new TrieNode();
    }

    public void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            TrieNode nextnode=curr.children[word.charAt(i)-'a'];
            if(nextnode==null){
                nextnode=new TrieNode();
                curr.children[word.charAt(i)-'a']=nextnode;
            }
            curr=nextnode;
        }
        curr.isEnd=true;
    }

    public boolean search(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            TrieNode nextnode=curr.children[word.charAt(i)-'a'];
            if(nextnode==null){
                return false;
            }
            curr=nextnode;
        }
        return curr.isEnd;
    }

    public boolean startsWith(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            TrieNode nextnode=curr.children[word.charAt(i)-'a'];
            if(nextnode==null){
                return false;
            }
            curr=nextnode;
        }
        return true;
    }

    public static void main(String[] args) {
        TrieImplementation trieImplementation=new TrieImplementation();
        trieImplementation.insert("hello");
        trieImplementation.insert("darkness");
        trieImplementation.insert("my");
        trieImplementation.insert("old");
        trieImplementation.insert("friend");
        System.out.println(trieImplementation.search("oldfriend"));

    }
}
