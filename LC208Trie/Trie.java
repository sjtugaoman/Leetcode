//Trie implementation

public class Trie {
  static final int ALPHABET_SIZE = 26;

  static class TrieNode {
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    boolean isEndOfWord;
    TrieNode() {
      isEndOfWord = false;
      for(int i = 0; i <  ALPHABET_SIZE; i++) {
        children[i] = null;
      }
    };
}
    static TrieNode root;

    static void insert(String key) {
      int level;
      int length = key.length();
      int index;

      TrieNode pCrawl = root;

      for(level = 0; level < length; level++) {
        index = key.charAt(level) - 'a';
        if(pCrawl.children[index] == null) {
          pCrawl.children[index] = new TrieNode();
        }
        pCrawl = pCrawl.children[index];
      }
      pCrawl.isEndOfWord = true;
    }

    static boolean search(String key) {
      int level;
      int length = key.length();
      int index;

      TrieNode pCrawl = root;
      for(level = 0; level < length; level++) {
        index = key.charAt(level) - 'a';
        if(pCrawl.children[index] == null) return false;
        pCrawl = pCrawl.children[index];
      }
      return (pCrawl != null && pCrawl.isEndOfWord);
    }

    //Driver
    public static void main(String args[]) {
      String keys[] = {"the", "a", "there", "answer", "any"};
      String output[] = {"Not present in trie", "Present in Trie"};

      root = new TrieNode();

      //Construct Trie
      int i;
      for(i = 0; i < keys.length; i++) {
        insert(keys[i]);
      }

      if(search("theres") == true) System.out.println(output[1]);
      else System.out.println(output[0]);
    }
 }
