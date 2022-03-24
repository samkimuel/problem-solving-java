package 프로그래머스.DP.등굣길;

public class Solution {

	private static final int MOD = 1000000007;

	public static void main(String[] args) {
		Solution solution = new Solution();

		// 4	3	[[2, 2]]	4
		System.out.println(solution.solution(4, 3, new int[][]{{2, 2}}));
	}

	public int solution(int m, int n, int[][] puddles) {
		int[][] dp = new int[m + 1][n + 1];
		dp[1][1] = 1;

		for (int[] puddle : puddles) {
			dp[puddle[0]][puddle[1]] = -1;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 && j == 1) {
					continue;
				}

				if (dp[i][j] == -1) {
					dp[i][j] = 0;
					continue;
				}

				if (i > 1) {
					dp[i][j] += dp[i - 1][j];
				}

				if (j > 1) {
					dp[i][j] += dp[i][j - 1];
				}

				dp[i][j] %= MOD;
			}
		}

		return dp[m][n];
	}
}
