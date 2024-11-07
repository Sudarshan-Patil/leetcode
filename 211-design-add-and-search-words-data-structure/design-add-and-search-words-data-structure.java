class Node {
    char ch;
    int count;
    boolean isTerminal;
    HashMap<Character, Node> hm;
    Node(char ch) {
        this.ch = ch;
        this.count = 0;
        this.isTerminal = false;
        this.hm = new HashMap<Character, Node>();
    }
}
class WordDictionary {
    Node root;
    public WordDictionary() {
        this.root = new Node('\0');
    }
    
    public void addWord(String word) {
        Node temp = this.root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (!temp.hm.containsKey(ch)) {
                Node newNode = new Node(ch);
                temp.hm.put(ch, newNode);
            }
            temp = temp.hm.get(ch);
            temp.count++;
        }
        temp.isTerminal = true;
        return;
    }
    
    public boolean search(String word) {
        return isFound(this.root, word, 0);
    }

    private boolean isFound(Node temp, String s, int start) {
        if (start==s.length() && temp.isTerminal) {
            return true;
        }

         if (start==s.length()) {
            return false;
        }

        if (temp==null || temp.hm.size() == 0) {
            return false;
        }

        char ch = s.charAt(start);
        if (!temp.hm.containsKey(ch) && ch!='.') {
            return false;
        }

        if (ch != '.') {
            return isFound(temp.hm.get(ch), s, start+1);
        } else {
            for (char key:temp.hm.keySet()) {
                if (isFound(temp.hm.get(key), s, start+1) == true) {
                    return true;
                }
            }
        }

        return false;
    }

    public void display(Node temp) {
        if (temp == null) {
            return;
        }

        System.out.println(temp.ch + " : " + temp.count + " : " + temp.hm);

        for (char key:temp.hm.keySet()) {
            display(temp.hm.get(key));
        }
        return;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */