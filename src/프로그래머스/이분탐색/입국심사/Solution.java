package 프로그래머스.이분탐색.입국심사;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		// 6	[7, 10]	28
		System.out.println(solution.solution(6, new int[]{7, 10}));
	}

	public long solution(int n, int[] times) {
		long answer = 0;

		Arrays.sort(times);

		long start = 1;
		long end = (long) n * times[times.length - 1];

		while (start <= end) {
			long headCount = 0;
			long mid = (start + end) / 2;

			for (int time : times) {
				headCount += mid / time;
			}

			if (headCount < n) {
				start = mid + 1;
			} else {
				answer = mid;
				end = mid - 1;
			}
		}

		return answer;
	}
}
