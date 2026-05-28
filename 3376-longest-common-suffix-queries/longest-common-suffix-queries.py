class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.idx = -1       # best container index at this node
        self.min_len = float('inf')

class Solution:
    def stringIndices(
        self,
        wordsContainer: list[str],
        wordsQuery: list[str]
    ) -> list[int]:

        root = TrieNode()

        # Step 1: Insert all container words (reversed) into Trie
        for i, word in enumerate(wordsContainer):
            node = root
            # Update root with every word (handles "no common suffix" fallback)
            if len(word) < node.min_len:
                node.min_len = len(word)
                node.idx = i
            for ch in reversed(word):
                c = ord(ch) - ord('a')
                if not node.children[c]:
                    node.children[c] = TrieNode()
                node = node.children[c]
                if len(word) < node.min_len:
                    node.min_len = len(word)
                    node.idx = i

        # Step 2: Query each word (reversed) in the Trie
        ans = []
        for word in wordsQuery:
            node = root
            for ch in reversed(word):
                c = ord(ch) - ord('a')
                if not node.children[c]:
                    break
                node = node.children[c]
            ans.append(node.idx)

        return ans