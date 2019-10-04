package leetcode;

/**
 * @No          208
 * @problem     Implement Trie (Prefix Tree)
 * @level       Medium
 * @desc        实现前缀树
 * @author      liyazhou1
 * @date        2019/10/03
 *
 * <pre>
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * </pre>
 */
public class _0208_ImplementTrie {


    /**
     * Note
     *
     * Thought
     *       多路查找树
     *
     * Challenge
     *      下标控制
     *      代码实现
     *
     * Algorithm
     *      1.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        static class TrieNode {
            char val;
            boolean isWord;
            TrieNode[] children = new TrieNode[26];

            TrieNode() {}
            TrieNode(char ch) {
                this.val = ch;
            }
            TrieNode(char ch, boolean isWord) {
                this.val = ch;
                this.isWord = isWord;
            }
        }

        static class Trie {

            TrieNode root;

            /** Initialize your data structure here. */
            public Trie() {
                // 根节点指向26个字母
                root = new TrieNode(' ');
            }

            /** Inserts a word into the trie. */
            public void insert(String word) {
                if (word == null || word.length() == 0) {
                    return;
                }

                TrieNode curr = root;
                for (int i = 0; i < word.length(); i ++) {
                    char ch = word.charAt(i);
                    if (curr.children[ch-'a'] == null) {
                        curr.children[ch-'a'] = new TrieNode(ch);
                    }
                    curr = curr.children[ch-'a'];
                }
                curr.isWord = true;
            }

            /** Returns if the word is in the trie. */
            public boolean search(String word) {
                if (word == null || word.length() == 0) {
                    return true;
                }

                TrieNode curr = root;
                for (char ch: word.toCharArray()) {
                    // System.out.println("ch = " + ch);
                    if (curr.children[ch-'a'] == null) {
                        return false;
                    }
                    curr = curr.children[ch-'a'];
                }
                return curr.isWord;
            }

            /** Returns if there is any word in the trie that starts with the given prefix. */
            public boolean startsWith(String prefix) {
                if (prefix == null || prefix.length() == 0) {
                    return true;
                }

                TrieNode curr = root;
                for (char ch: prefix.toCharArray()) {
                    // System.out.println(ch);
                    if (curr.children[ch-'a'] == null) {
                        return false;
                    }
                    curr = curr.children[ch-'a'];
                }
                return true;
            }
        }

        public static void main(String[] args) {
            Trie trie = new Trie();

            trie.insert("apple");
            System.out.println("insert apple");
            boolean result = trie.search("apple");  // 返回 true
            System.out.println("search 'apple', result = " + result);

            result = trie.search("app");  // 返回 false
            System.out.println("search 'app', result = " + result);

            result = trie.startsWith("app");  // 返回 true
            System.out.println("startsWith 'app', result = " + result);

            trie.insert("app");
            System.out.println("insert app");
            result = trie.search("app");  // 返回 true
            System.out.println("search 'app', result = " + result);


        }
    }
}
