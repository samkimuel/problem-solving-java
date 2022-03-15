package 프로그래머스.스택큐.기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		//[93, 30, 55]	[1, 30, 5]	[2, 1]
		//[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
		System.out.println(
			Arrays.toString(solution.solution(
				new int[]{93, 30, 55},
				new int[]{1, 30, 5}
			)));
		System.out.println(
			Arrays.toString(solution.solution(
				new int[]{95, 90, 99, 99, 80, 99},
				new int[]{1, 1, 1, 1, 1, 1}
			)));
	}

	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			int todo = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);

			q.offer(todo);
		}

		List<Integer> result = new ArrayList<>();
		int todo = q.poll();
		int count = 1;

		while (!q.isEmpty()) {
			int remain = q.poll();

			if (todo >= remain) {
				count++;
				continue;
			}

			result.add(count);
			count = 1;
			todo = remain;
		}

		result.add(count);

		return convertToArray(result);
	}

	private int[] convertToArray(List<Integer> result) {
		int[] answer = new int[result.size()];

		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}

		return answer;
	}
}
