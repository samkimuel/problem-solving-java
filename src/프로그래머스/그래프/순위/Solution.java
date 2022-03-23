package 프로그래머스.그래프.순위;

public class Solution {

	int[][] graph;

	public static void main(String[] args) {
		Solution solution = new Solution();

		// 5	[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]	2
		System.out.println(
			solution.solution(
				5,
				new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}
			));
	}

	public int solution(int n, int[][] results) {
		setGraph(n, results);

		floydWarshall(n);

		return getAnswer(n);
	}

	private void setGraph(int n, int[][] results) {
		graph = new int[n + 1][n + 1];

		for (int[] result : results) {
			graph[result[0]][result[1]] = 1;
			graph[result[1]][result[0]] = -1;
		}
	}

	private void floydWarshall(int n) {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
					}

					if (graph[i][k] == -1 && graph[k][j] == -1) {
						graph[i][j] = -1;
					}
				}
			}
		}
	}

	private int getAnswer(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			int count = 0;
			for (int j = 1; j <= n; j++) {
				if (graph[i][j] == 1 || graph[i][j] == -1) {
					count++;
				}
			}

			if (count == n - 1) {
				answer++;
			}
		}
		return answer;
	}
}
