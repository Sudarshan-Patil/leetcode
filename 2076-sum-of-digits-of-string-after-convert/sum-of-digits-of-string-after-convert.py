class Solution:
    def getLucky(self, s: str, k: int) -> int:
        sum = 0
        for i in range(len(s)):
            t = ord(s[i])-ord('a')+1
            if (t > 9):
                t = self.getSum(t)
            sum += t
        
        k -= 1
        while (k>0) :
            k-=1
            sum = self.getSum(sum)

        return sum

    def getSum(self, sum):
        if (sum <= 1):
            return sum
        
        return (sum%10) + int(self.getSum(sum/10))

        