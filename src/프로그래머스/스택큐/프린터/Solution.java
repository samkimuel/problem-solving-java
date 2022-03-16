package 프로그래머스.스택큐.프린터;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		//[2, 1, 3, 2]	2	1
		//[1, 1, 9, 1, 1, 1]	0	5
		System.out.println(solution.solution(new int[]{2, 1, 3, 2}, 2));
		System.out.println(solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
	}

	public int solution(int[] priorities, int location) {
		Deque<Job> dq = new ArrayDeque<>();

		for (int i = 0; i < priorities.length; i++) {
			dq.offer(new Job(i, priorities[i]));
		}

		Arrays.sort(priorities);
		int index = priorities.length - 1;

		int count = 0;
		while (!dq.isEmpty()) {
			Job job = dq.poll();

			if (priorities[index] > job.getPriority()) {
				dq.offer(job);
			} else if (priorities[index] == job.getPriority()) {
				count++;
				index--;

				if (location == job.getLocation()) {
					break;
				}
			}
		}

		return count;
	}
}

class Job {

	private int location;
	private int priority;

	public Job(int location, int priority) {
		this.location = location;
		this.priority = priority;
	}

	public int getLocation() {
		return location;
	}

	public int getPriority() {
		return priority;
	}

	public String toString() {
		return location + " " + priority;
	}
}
