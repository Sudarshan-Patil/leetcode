class Solution:
    def chalkReplacer(self, chalk: List[int], k: int) -> int:
        if len(chalk) == 1:
            return 0
        sum = 0
        for i in chalk:
            sum += i
        while k >= sum:
            k -= sum

        if k == 0:
            return k
        else:
            for i, v in enumerate(chalk):
                if v>k:
                    return i
                else:
                    k -= v

        return -1