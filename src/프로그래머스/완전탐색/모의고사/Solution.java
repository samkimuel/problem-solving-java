package 프로그래머스.완전탐색.모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		//[1,2,3,4,5]	[1]
		//[1,3,2,4,2]	[1,2,3]
		System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 4, 5})));
		System.out.println(Arrays.toString(solution.solution(new int[]{1, 3, 2, 4, 2})));
	}

	public int[] solution(int[] answers) {
		int[] firstSupo = new int[]{1, 2, 3, 4, 5};
		int[] secondSupo = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
		int[] thirdSupo = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int[] score = new int[3];

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == firstSupo[i % firstSupo.length]) {
				score[0]++;
			}

			if (answers[i] == secondSupo[i % secondSupo.length]) {
				score[1]++;
			}

			if (answers[i] == thirdSupo[i % thirdSupo.length]) {
				score[2]++;
			}
		}

		int max = 0;
		for (int i = 0; i < score.length; i++) {
			max = Math.max(max, score[i]);
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < score.length; i++) {
			if (max == score[i]) {
				list.add(i + 1);
			}
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
