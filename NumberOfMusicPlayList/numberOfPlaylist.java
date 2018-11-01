class Solution {
    long MOD = (long) Math.pow(10, 9) + 7;
    public int numMusicPlaylists(int N, int L, int K) {
        if(L < N) return 0;
        long[][] dp = new long[N + 1][L + 1];
        for(int i = K + 1; i <= N; i++) {
            for(int j = i; j <= L; j++) {
                if(i == j || i == K + 1) {
                    dp[i][j] = factorial(i);
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] * i + dp[i][j - 1] * (i - K)) % MOD;
                }
            }
        }
        return (int)dp[N][L];
    }

    private long factorial(int n) {
        if(n == 1) return 1;
        return factorial(n - 1) * n;
    }
}

public class numberOfPlaylist {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numMusicPlaylists(3, 4, 1));
    }
}