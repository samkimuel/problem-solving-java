package 프로그래머스.DP.도둑질;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		// [1, 2, 3, 1]	4
		System.out.println(solution.solution(new int[]{1, 2, 3, 4}));
	}

	public int solution(int[] money) {
		// 첫번쨰 집을 터는 경우
		int[] dp1 = new int[money.length];
		dp1[0] = money[0];
		dp1[1] = dp1[0];
		for (int i = 2; i < money.length - 1; i++) {
			dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);
		}

		// 마지막 집을 터는 경우
		int[] dp2 = new int[money.length];
		dp2[0] = 0;
		dp2[1] = money[1];
		for (int i = 2; i < money.length; i++) {
			dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
		}

		return Math.max(dp1[money.length - 2], dp2[money.length - 1]);
	}
}
