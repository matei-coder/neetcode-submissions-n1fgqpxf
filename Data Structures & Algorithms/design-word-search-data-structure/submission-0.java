class WordDictionary {

    public class Trie{
        Trie[] children = new Trie[26];
        boolean isLast = false;
    }

    Trie root;
    
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie node = root;
        for(char x : word.toCharArray()){
            int idx = x - 'a';
            if(node.children[idx]==null) node.children[idx] = new Trie();
            node = node.children[idx];
        }
        node.isLast = true;
    }

    public boolean search(String word) {
        return find(word ,root , 0);
    }

    public boolean find(String word , Trie root , int x){
        if((x==word.length())) return root.isLast;
        if(word.charAt(x)!='.'){
            if(root.children[word.charAt(x)-'a']==null) return false;
            root = root.children[word.charAt(x)-'a'];
            return find(word , root , x+1);
        }
        else{
            for(int i=0;i<26;i++){
                if(root.children[i]!=null){
                    Trie temp = root;
                    root = root.children[i];
                    if(find(word , root , x+1))return true;
                    root = temp;
                }
            }

        }
        return false;

        
    }
}
