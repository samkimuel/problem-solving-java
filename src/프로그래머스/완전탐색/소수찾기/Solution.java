package 프로그래머스.완전탐색.소수찾기;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	boolean[] used;
	Set<Integer> numSet;

	public static void main(String[] args) {
		Solution solution = new Solution();

		//"17"	3
		//"011"	2
		System.out.println(solution.solution("17"));
		System.out.println(solution.solution("011"));

		System.out.println(solution.solutionV2("17"));
		System.out.println(solution.solutionV2("011"));
	}

	public int solution(String numbers) {
		used = new boolean[numbers.length()];
		numSet = new HashSet<>();

		go(numbers, 0, "");

		return (int) numSet.stream()
			.filter(n -> isPrime(n))
			.count();
	}

	public int solutionV2(String numbers) {
		used = new boolean[numbers.length()];
		numSet = new HashSet<>();

		go(numbers, 0, "");

		int count = 0;
		for (int num : numSet) {
			if (isPrime(num)) {
				count++;
			}
		}

		return count;
	}

	public void go(String numbers, int depth, String num) {
		if (depth == numbers.length()) {
			return;
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (!used[i]) {
				used[i] = true;
				numSet.add(Integer.parseInt(num + numbers.charAt(i)));
				go(numbers, depth + 1, num + numbers.charAt(i));
				used[i] = false;
			}
		}
	}

	public boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}

		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}
}
