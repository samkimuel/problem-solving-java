package 프로그래머스.DP.정수삼각형;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		// [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	30
		System.out.println(
			solution.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
	}

	public int solution(int[][] triangle) {
		int[][] dp = new int[triangle.length][triangle.length];

		dp[0][0] = triangle[0][0];

		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j];
				} else if (i == j) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
				}

				dp[i][j] += triangle[i][j];
			}
		}

		int answer = 0;
		for (int i = 0; i < triangle.length; i++) {
			answer = Math.max(dp[triangle.length - 1][i], answer);
		}

		return answer;
	}
}
