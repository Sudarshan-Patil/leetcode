class Node {
    char c;
    HashMap<Character, Node> hm = new HashMap<>();
    boolean isTerminal = false;
    Node(char c) {
        this.c = c;
    }
}
class Solution {
    StringBuilder ans = new StringBuilder();
    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node('\0');    
        Node head;
        for (int i=0; i<dictionary.size(); i++) {
            String s = dictionary.get(i);
            head = root;
            for (int j=0; j<s.length(); j++) {
                char c = s.charAt(j);
                if (!head.hm.containsKey(c)) {
                    Node n = new Node(c);
                    head.hm.put(c, n);
                }
                head = head.hm.get(c);
            }
            head.isTerminal = true;
        }

        head = root;

        int j=0;
        for (int i=0; i<sentence.length(); i++) {
            while(i<sentence.length() && sentence.charAt(i) != ' ') {
                i++;
            }
            if (i<sentence.length()) {
                validate(sentence, j, i, head);
                j=i+1;
            }
        }

        validate(sentence, j, sentence.length(), head);

        return ans.toString();
    }

    public void validate(String s, int start, int end, Node head) {
        String temp = s.substring(start, end);
        String t = "";
        for (int i=start; i<end; i++) {
            char ch = s.charAt(i);
            if (head.hm.containsKey(ch)) {
                head = head.hm.get(ch);
                t += ch;
                if (head.isTerminal) {
                    break;
                }
            } else {
                break;
            }
        }

        if (t.length() != 0 && head.isTerminal == true) {
            temp = t;
        }
        
        ans.append(temp);
        if (end != s.length()) {
            ans.append(' ');
        }

        return;
    }
}