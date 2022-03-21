package 프로그래머스.DFSBFS.여행경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * BFS 보다 DFS로 쉽게 풀 수 있음
 * BFS, PQ -> 테스트케이스 1, 2 실패 - 엣지 케이스 고려 복잡
 */
public class Solution {

	List<String> result;
	boolean[] visited;

	public static void main(String[] args) {
		Solution solution = new Solution();

		// [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
		// [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
		System.out.println(
			Arrays.toString(solution.solution(
				new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}
			))
		);
		System.out.println(
			Arrays.toString(solution.solution(
				new String[][]{
					{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}
				}
			))
		);
	}

	public String[] solution(String[][] tickets) {
		result = new ArrayList<>();
		visited = new boolean[tickets.length + 1];

		dfs(tickets, "ICN", 0, "ICN");

		Collections.sort(result);

		return result.get(0).split("/");
	}

	public void dfs(String[][] tickets, String now, int depth, String value) {
		if (depth == tickets.length) {
			result.add(value);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i] && now.equals(tickets[i][0])) {
				visited[i] = true;
				dfs(tickets, tickets[i][1], depth + 1, value + "/" + tickets[i][1]);
				visited[i] = false;
			}
		}
	}
}
