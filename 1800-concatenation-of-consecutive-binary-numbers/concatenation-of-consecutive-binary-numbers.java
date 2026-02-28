class Solution {
  public int concatenatedBinary(int n) {
    final int MOD = 1_000_000_007;
    long ans = 0;

    for (int i = 1; i <= n; ++i) {
        ans = ((ans << numberOfBits(i)) % MOD + i) % MOD;
    }

    return (int) ans;
  }

  private int numberOfBits(int n) {
    int cnt = 0;
    while (n>0) {
        cnt++;
        n = n>>1;
    }

    return cnt;
  }
}