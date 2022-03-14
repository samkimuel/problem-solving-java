package 슼.사번;

import java.util.Arrays;

/*
 * 플로이드 워셜로 하면 시간초과 -> 부모 자식 관계를 생각한 트리로 문제 풀 것
 *
 * 1. A + B = C -> 트리에서 어떤 성질??
 * i -> k : i, k 결정하기만 하면 그 경로 위에 j가 있어야 한다
 *
 * 2. i, j, k 총 경우의 수 = 사이에 있는 경유지의 개수
 * 트리 모든 노드 확인하지 않아도 됨
 * (i, j, k)의 순서쌍 수 = i -> k 거리 - 1
 *
 * 총 경우의 수 = 가능한 모든 경로의 길이의 합 - N(N-1)/2
 * 가능한 모든 경로 길이의 합?? -> 백준 1289
 *
 * 1. i->k = i->j + j->k
 * in 트리 => j는 i-> 경로 위에 있어야 한다
 * 2. (i, j, k)의 경우의 수는 (i->k) 길이 - 1
 * 3. 모든 i랑 모든 k에 대해 i->k 길이 - N(N-1)/2
 * 모든 경로 길이의 합 * 2 - N(N-1)/2
 * 모든 경로의 길이 합은 어떻게 구함? -> 트리 DP...
 * 1. rooted tree
 * 2. dp[i] : i를 루트로 하는 서브트리 내에서 가능한 모든 경로 길이의 합
 * dp[i] = i를 포함하지 않는 경로 길이의 합 + i를 포함한 경로 길이의 합
 * i를 포함하지 않는 경로 길이의 합 = dp[c1] + dp[c2] +...dp[ck] (자식
 * i를 포함하는 경로 길이의 합 = (시작 -> i 거리) * 끝의 개수
 * (c1에서 i로 오는 모든 경로의 길이) * (c2~ck, i의 정점 개수) + ... + (ck * i로) * (c1~ck-1, i 정점개수)
 */
public class Solution {

	int[][] graph;

	public static void main(String[] args) {
		Solution solution = new Solution();

		//n	edges	result
		//5	[[0,1],[0,2],[1,3],[1,4]]	16
		//4	[[2,3],[0,1],[1,2]]	8
		System.out.println(solution.solution(5, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}}));
	}

	public long solution(int n, int[][] edges) {
		long answer = 0;

		setGraph(n, edges);

		floydWarshall(n);

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != j && i != k && j != k && checkDistance(i, j, k)) {
						answer += 1;
					}
				}
			}
		}

		return answer;
	}

	public void setGraph(int n, int[][] edges) {
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE / 2);
		}
		for (int[] edge : edges) {
			graph[edge[0]][edge[1]] = 1;
			graph[edge[1]][edge[0]] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					graph[i][j] = 0;
				}
			}
		}
	}

	public void floydWarshall(int n) {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
	}

	public boolean checkDistance(int from, int to, int k) {
		if (graph[from][k] + graph[k][to] == graph[from][to]) {
			return true;
		}

		return false;
	}
}
