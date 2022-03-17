package 프로그래머스.힙.이중우선순위큐;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	private PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
	private PriorityQueue<Integer> minQ = new PriorityQueue<>();

	public static void main(String[] args) {
		Solution solution = new Solution();

		//["I 16","D 1"]	[0,0]
		//["I 7","I 5","I -5","D -1"]	[7,5]
		System.out.println(Arrays.toString(solution.solution(new String[]{"I 16", "D 1"})));
		System.out.println(
			Arrays.toString(solution.solution(new String[]{"I 7", "I 5", "I -5", "D -1"})));
	}

	public int[] solution(String[] operations) {
		int[] answer = new int[2];

		int size = 0;
		for (int i = 0; i < operations.length; i++) {
			String[] operation = operations[i].split(" ");

			switch (operation[0]) {
				case "I":
					insertElement(Integer.parseInt(operation[1]));
					size++;
					break;
				case "D":
					if (size > 0) {
						deleteElement(operation[1]);
						size--;
					}
					break;
				default:
					break;
			}
		}

		if (size > 0) {
			answer[0] = maxQ.poll();
			answer[1] = minQ.poll();
		}
		return answer;
	}

	private void insertElement(int value) {
		maxQ.offer(value);
		minQ.offer(value);
	}

	private void deleteElement(String op) {
		if (op.equals("1")) {
			int val = maxQ.poll();
			minQ.remove(val);
		} else if (op.equals("-1")) {
			int val = minQ.poll();
			maxQ.remove(val);
		}
	}
}
