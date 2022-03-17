package 프로그래머스.힙.디스크컨트롤러;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		// [[0, 3], [1, 9], [2, 6]]	9
		System.out.println(solution.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
	}

	public int solution(int[][] jobs) {
		Arrays.sort(jobs, Comparator.comparing(i -> i[0]));

		PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.comparing(Task::getExecutionTime));

		int answer = 0;
		int index = 0;
		int time = 0;

		while (!pq.isEmpty() || index < jobs.length) {

			while (index < jobs.length && jobs[index][0] <= time) {
				pq.offer(new Task(jobs[index][0], jobs[index][1]));
				index++;
			}

			if (pq.isEmpty()) {
				time = jobs[index][0];
				continue;
			}

			Task currentTask = pq.poll();
			time += currentTask.getExecutionTime();
			answer += time - currentTask.getStart();
		}

		return answer / jobs.length;
	}
}

class Task {

	private int start;
	private int executionTime;

	public Task(int start, int executionTime) {
		this.start = start;
		this.executionTime = executionTime;
	}

	public int getStart() {
		return start;
	}

	public int getExecutionTime() {
		return executionTime;
	}
}
