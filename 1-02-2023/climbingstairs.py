class Solution:
    def climbStairs(self, n: int) -> int:

        bp = [1, 1] + [0] * (n - 1)

        for i in range(2, n + 1):
            bp[i] = bp[i - 1] + bp[i - 2]

        return bp[n]
