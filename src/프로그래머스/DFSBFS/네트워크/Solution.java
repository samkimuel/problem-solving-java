package 프로그래머스.DFSBFS.네트워크;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		// 3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
		// 3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
		System.out.println(solution.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
		System.out.println(solution.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
	}

	public int solution(int n, int[][] computers) {
		int answer = 0;

		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				bfs(computers, visited, i);
				answer++;
			}
		}

		return answer;
	}

	public void bfs(int[][] computers, boolean[] visited, int start) {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < computers[now].length; i++) {
				if (i != now && computers[now][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
