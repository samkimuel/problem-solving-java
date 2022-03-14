package 슼.삼번;

/*
 * DP (X)
 * 1. 대각선
 * 2. 대각위로/대각아래로
 * 3. 대각 앞뒤로 쪼개기
 *
 * 대각선 왼쪽위 시작이거나 오른쪽아래 시작이거나 같다
 * 대각선 갯수 * 대각선에 도착하는 경우의 수
 * O -> A -> B -> X : O->A / B->X 경우는 오른쪽, 위로만 가는 경우만있다
 * (O->A 경우의 수) * (B->X 경우의 수)
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		//2	2	[[1,1],[2,2]]	12
		//51	37	[[17,19]]	3225685
		System.out.println(solution.solution(2, 2, new int[][]{{1, 1}, {2, 2}}));
		System.out.println(solution.solution(51, 37, new int[][]{{17, 19}}));
	}

	public int solution(int width, int height, int[][] diagonals) {
		final int MOD = 10000019;

		int[][] dp = new int[width + 1][height + 1];

		dp[0][0] = 1;
		for (int i = 0; i < width + 1; i++) {
			for (int j = 0; j < height + 1; j++) {
				if (i == 0 && j == 0) {
					continue;
				}

				if (i > 0) {
					dp[i][j] += dp[i - 1][j];
				}

				if (j > 0) {
					dp[i][j] += dp[i][j - 1];
				}

				dp[i][j] %= MOD;
			}
		}

		int answer = 0;
		for (int[] diagonal : diagonals) {
			int x = diagonal[0];
			int y = diagonal[1];

			// int type 일 때 모듈러 연산 전 dp 곱 연산에서 오버플로우 -> long type
			long countAB = ((long) dp[x][y - 1] * dp[width - x + 1][height - y]) % MOD;
			long countBA = ((long) dp[x - 1][y] * dp[width - x][height - y + 1]) % MOD;

			answer += (countAB + countBA) % MOD;
			answer %= MOD;
		}

		return answer;
	}
}
