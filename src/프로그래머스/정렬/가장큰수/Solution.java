package 프로그래머스.정렬.가장큰수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		// [6, 10, 2]	"6210"
		// [3, 30, 34, 5, 9]	"9534330"
		// [0, 0, 0, 0, 0] "0"
		System.out.println(solution.solution(new int[]{6, 10, 2}));
		System.out.println(solution.solution(new int[]{3, 30, 34, 5, 9}));
		System.out.println(solution.solution(new int[]{0, 0, 0, 0, 0}));

		System.out.println(solution.solutionV2(new int[]{6, 10, 2}));
		System.out.println(solution.solutionV2(new int[]{3, 30, 34, 5, 9}));
		System.out.println(solution.solutionV2(new int[]{0, 0, 0, 0, 0}));

	}

	public String solution(int[] numbers) {
		StringBuilder sb = new StringBuilder();

		List<String> nums = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			nums.add(String.valueOf(numbers[i]));
		}
		nums.sort((num1, num2) -> (num2 + num1).compareTo(num1 + num2));

		if (nums.get(0).equals("0")) {
			return "0";
		}

		for (String num : nums) {
			sb.append(num);
		}
		return sb.toString();
	}

	public String solutionV2(int[] numbers) {
		return Arrays.stream(numbers)
			.mapToObj(String::valueOf)
			.sorted((str1, str2) -> -str1.concat(str2).compareTo(str2.concat(str1)))
			.reduce("", (s1, s2) -> s1.equals("0") && s2.equals("0") ? "0" : s1.concat(s2));
	}
}
