package 프로그래머스.완전탐색.카펫;

import java.util.Arrays;
import java.util.Set;

public class Solution {

	boolean[] used;
	Set<Integer> numSet;

	public static void main(String[] args) {
		Solution solution = new Solution();

		// 10	2	[4, 3]
		// 8	1	[3, 3]
		// 24	24	[8, 6]
		System.out.println(Arrays.toString(solution.solution(10, 2)));
		System.out.println(Arrays.toString(solution.solution(8, 1)));
		System.out.println(Arrays.toString(solution.solution(24, 24)));
	}

	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		for (int i = 1; i * i <= yellow; i++) {
			if (yellow % i == 0 && (i + 2 + yellow / i + 2 - 2) * 2 == brown) {
				answer[1] = i + 2;
				answer[0] = yellow / i + 2;
			}
		}

		return answer;
	}
}
