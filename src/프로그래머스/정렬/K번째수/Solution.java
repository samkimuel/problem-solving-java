package 프로그래머스.정렬.K번째수;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		// [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
		System.out.println(
			Arrays.toString(solution.solution(
				new int[]{1, 5, 2, 6, 3, 7, 4},
				new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}
			)));
	}

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int firstIdx = commands[i][0];
			int lastIdx = commands[i][1];
			int targetIdx = commands[i][2];

			int[] arr = Arrays.copyOfRange(array, firstIdx - 1, lastIdx);
			Arrays.sort(arr);
			answer[i] = arr[targetIdx - 1];
		}

		return answer;
	}
}
