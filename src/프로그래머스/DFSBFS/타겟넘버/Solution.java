package 프로그래머스.DFSBFS.타겟넘버;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		// [1, 1, 1, 1, 1]	3	5
		// [4, 1, 2, 1]	4	2
		System.out.println(solution.solution(new int[]{1, 1, 1, 1, 1}, 3));
		System.out.println(solution.solution(new int[]{4, 1, 2, 1}, 4));
	}

	public int solution(int[] numbers, int target) {
		return dfs(numbers, target, 0, 0);
	}

	public int dfs(int[] numbers, int target, int depth, int value) {
		if (depth == numbers.length) {
			if (value == target) {
				return 1;
			}

			return 0;
		}

		return dfs(numbers, target, depth + 1, value + numbers[depth])
			+ dfs(numbers, target, depth + 1, value - numbers[depth]);
	}
}
