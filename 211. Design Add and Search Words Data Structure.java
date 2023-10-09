class WordDictionary {

    WordDictionary[] children;
    boolean isEndOfWord;

    public WordDictionary() {
        children = new WordDictionary[26];
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
    
    public void addWord(String word) {
        WordDictionary node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new WordDictionary();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        WordDictionary node = this;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (WordDictionary nd: node.children) {
                    if (nd == null)
                        continue;
                    if (nd.search(word.substring(i+1)))
                        return true;
                }
                return false;
            } else {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
        }
        return node.isEndOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
