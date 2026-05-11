package lc208_实现Trie_前缀树;

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();

    }

    public void insert(String word) {
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = searchPrefix(word);
        return cur != null && cur.isEnd;
    }

    public boolean startsWith(String prefix) {

        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String s) {//给你一个字符串，返回最后走到的节点；走不到就 null。
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return null;
            }
            cur = cur.children[index];
        }
        return cur;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;

    public TrieNode() {
    }
}