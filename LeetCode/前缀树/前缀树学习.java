package 前缀树;

public class 前缀树学习 {

}
/**
 * 数组实现前缀树
 */

class Trie{
    class TrieNode{
        boolean val;
        TrieNode[] children = new TrieNode[26];
    }
    // 前缀树的根节点
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    // 插入新字符串
    public void insert(String word){
        TrieNode p = root;
        for(char c : word.toCharArray()){
            if(p.children[c - 'a'] == null){
                p.children[c - 'a'] = new TrieNode();
            }
            p = p.children[c - 'a'];
        }
        p.val  =true;
    }
    // 查看字符串是否存在
    public boolean search(String word){
        TrieNode p = root;
        for(char c : word.toCharArray()){
            if(p.children[c - 'a'] == null) return false;
            p = p.children[c - 'a'];
        }
        return p.val;
    }
    // 寻找最短前缀
    public boolean startsWith(String prefix){
        TrieNode p = root;
        for(char c : prefix.toCharArray()){
            if(p.children[c-'a']==null) return false;
            p = p.children[c-'a'];
        }
        return true;
    }
}