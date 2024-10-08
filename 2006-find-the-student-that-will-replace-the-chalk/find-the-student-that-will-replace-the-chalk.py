class Solution:
    def chalkReplacer(self, chalk: List[int], k: int) -> int:
        s = sum(chalk)
        k %= s

        for i in range(len(chalk)):
            if chalk[i] > k:
                return i
            else:
                k -= chalk[i]

        return -1