package 프로그래머스.정렬.HIndex;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		//[3, 0, 6, 1, 5]	3
		System.out.println(solution.solution(new int[]{3, 0, 6, 1, 5}));
		System.out.println(solution.solutionV2(new int[]{3, 0, 6, 1, 5}));

	}

	public int solution(int[] citations) {
		Arrays.sort(citations);

		int hIndex = 0;
		while (true) {
			int count = 0;
			for (int i = 0; i < citations.length; i++) {
				if (citations[i] >= hIndex) {
					count++;
				}
			}

			if (count < hIndex) {
				break;
			}

			hIndex++;
		}

		return hIndex - 1;
	}

	public int solutionV2(int[] citations) {
		Arrays.sort(citations);

		int hIndex = 0;
		for (int i = 0; i < citations.length; i++) {
			if (citations.length - i <= citations[i]) {
				hIndex++;
			}
		}

		return hIndex;
	}
}
