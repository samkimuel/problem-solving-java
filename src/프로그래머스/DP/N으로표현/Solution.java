package 프로그래머스.DP.N으로표현;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		// 5	12	4
		// 2	11	3
		System.out.println(solution.solution(5, 12));
		System.out.println(solution.solution(2, 11));
	}

	public int solution(int N, int number) {
		int answer = -1;

		Set<Integer>[] numSet = new HashSet[9];

		int n = N;
		for (int i = 1; i <= 8; i++) {
			numSet[i] = new HashSet<>();
			numSet[i].add(n);
			n = n * 10 + N;
		}

		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j < i; j++) {
				for (int a : numSet[j]) {
					for (int b : numSet[i - j]) {
						numSet[i].add(a + b);
						numSet[i].add(a - b);
						numSet[i].add(b - a);
						numSet[i].add(a * b);

						if (b != 0) {
							numSet[i].add(a / b);
						}

						if (a != 0) {
							numSet[i].add(b / a);
						}
					}
				}
			}
		}

		for (int i = 1; i <= 8; i++) {
			if (numSet[i].contains(number)) {
				return i;
			}
		}

		return answer;
	}
}
