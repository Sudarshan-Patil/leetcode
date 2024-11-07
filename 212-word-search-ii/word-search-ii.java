class Node {
    char ch;
    int count;
    boolean isTerminal;
    HashMap<Character, Node> hm;
    String word;
    Node(char ch) {
        this.ch = ch;
        this.count = 0;
        this.isTerminal = false;
        this.hm = new HashMap<Character, Node>();
        this.word = null;
    }
}
class Solution {
    Node root;
    HashSet<String> hs;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    Solution() {
        this.root = new Node('\0');
        hs = new HashSet<String>();
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<String>();
        buildTri(words);
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                dfs(i, j, board, this.root);
            }
        }

        for (String key:hs) {
            ans.add(key);
        }

        return ans;
    }

    public void buildTri(String[] word) {
        for (int i=0; i<word.length; i++) {
            String s = word[i];
            Node temp = this.root;
            for (int j=0; j<s.length(); j++) {
                char ch = s.charAt(j);
                if (!temp.hm.containsKey(ch)) {
                    Node newNode = new Node(ch);
                    temp.hm.put(ch, newNode);
                }
                temp = temp.hm.get(ch);
                temp.count++;
            }
            temp.isTerminal = true;
            temp.word = s;
        }
        return;
    }

    public boolean dfs(int i, int j, char[][] board, Node temp) {
        if (temp.isTerminal == true) {
            //add word to ans
            if (temp.word!=null) {
                hs.add(temp.word);
                temp.word = null;   
            }
        }

        if (i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] == '#' || !temp.hm.containsKey(board[i][j])) {
            return false;
        }

        char ch = board[i][j];
        board[i][j] = '#';

        for (int k=0; k<4; k++) {
            dfs(i+dx[k], j+dy[k], board, temp.hm.get(ch));
        }
    
        board[i][j] = ch;
        return false;
    }
}