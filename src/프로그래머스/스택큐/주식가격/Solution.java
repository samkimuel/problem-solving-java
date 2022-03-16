package 프로그래머스.스택큐.주식가격;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		//[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
		System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 2, 3})));
	}

	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			answer[i] = 0;
			for (int j = i + 1; j < prices.length; j++) {
				answer[i] += 1;
				if (prices[i] > prices[j]) {
					break;
				}
			}
		}

		return answer;
	}
}
