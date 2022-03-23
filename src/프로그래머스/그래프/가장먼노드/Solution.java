package 프로그래머스.그래프.가장먼노드;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	List<List<Node>> graph;
	int[] distance;

	public static void main(String[] args) {
		Solution solution = new Solution();

		// 6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
		System.out.println(
			solution.solution(
				6,
				new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}
			));
	}

	public int solution(int n, int[][] edge) {
		setGraph(n, edge);

		dijkstra(1);

		Arrays.sort(distance);

		long max = 0;
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (max < distance[i]) {
				answer = 1;
				max = distance[i];
			} else if (max == distance[i]) {
				answer++;
			}
		}

		return answer;
	}

	private void setGraph(int n, int[][] edge) {
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] vertex : edge) {
			graph.get(vertex[0]).add(new Node(vertex[1], 1));
			graph.get(vertex[1]).add(new Node(vertex[0], 1));
		}

		distance = new int[n + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
	}

	private void dijkstra(int start) {
		Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getDist));

		pq.offer(new Node(start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.getDist();
			int now = node.getTo();

			if (distance[now] < dist) {
				continue;
			}

			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = distance[now] + graph.get(now).get(i).getDist();

				if (cost < distance[graph.get(now).get(i).getTo()]) {
					distance[graph.get(now).get(i).getTo()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getTo(), cost));
				}
			}
		}
	}
}

class Node {

	private int to;
	private int dist;

	public Node(int to, int dist) {
		this.to = to;
		this.dist = dist;
	}

	public int getTo() {
		return to;
	}

	public int getDist() {
		return dist;
	}
}
