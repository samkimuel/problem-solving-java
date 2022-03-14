package 슼.일번;

import java.util.Arrays;

/*
 * DP
 *
 * 나의 솔루션 확실한지 모르겠음
 *
 * 백준 12865 참고
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

//		System.out.println(solution.solution(1999, new int[]{2, 11, 20, 100, 200, 600}));
		System.out.println(solution.solutionV2(4578, new int[]{1, 4, 99, 35, 50, 1000}));
		System.out.println(solution.solutionV2(1999, new int[]{2, 11, 20, 100, 200, 600}));
	}

	public int solution(int money, int[] costs) {
		int[] coin = new int[]{1, 5, 10, 50, 100, 500};
		int[] dp = new int[money + 1]; // dp[i] : i원을 생산할 때 최소 비용
		Arrays.fill(dp, Integer.MAX_VALUE / 2);

		dp[1] = costs[0];
		for (int i = 2; i <= money; i++) {
			for (int j = 0; j < coin.length; j++) {
				if (i >= coin[j]) {
					dp[i] = Math.min(dp[i - coin[j]] + costs[j], dp[i]);
				}
			}
		}

		return dp[money];
	}

	/*
	 * dp[k][w] : 1~k 번 보석 사용해서 무게 w를 만족하는 최소 가치
	 * 구하려는 답 -> dp[6][W] 초기값 dp[1][w] = cost[1] * w
	 * k번 보석 사용X (ex 1~2번 보석) / k번 보석 사용O(ex 1~3번)
	 * dp[k-1][w] / dp[k][w-weight[k]] + cost[k]
	 */
	public int solutionV2(int money, int[] costs) {
		int[] coin = new int[]{1, 5, 10, 50, 100, 500};

		int[][] dp = new int[coin.length][money + 1];

		for (int i = 0; i < money + 1; i++) {
			dp[0][i] = costs[0] * i;
		}

		for (int k = 1; k < coin.length; k++) {
			for (int w = 1; w < money + 1; w++) {
				dp[k][w] = dp[k - 1][w];

				if (w - coin[k] >= 0) {
					dp[k][w] = Math.min(dp[k][w], dp[k][w - coin[k]] + costs[k]);
				}
			}
		}

		return dp[coin.length - 1][money];
	}
}
