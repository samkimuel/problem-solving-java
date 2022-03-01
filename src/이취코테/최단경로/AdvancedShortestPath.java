package 이취코테.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdvancedShortestPath {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int start;
	static List<List<Node>> graph;
	static int[] distance;
	static boolean[] visited;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		start = scan.nextInt();

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			int cost = scan.nextInt();
			graph.get(from).add(new Node(to, cost));
		}

		distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		visited = new boolean[N + 1];
	}

	static void dijkstra(int start) {
		Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));

		pq.offer(new Node(start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();

			if (distance[now] < dist) {
				continue;
			}

			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = distance[now] + graph.get(now).get(i).getDistance();
				if (cost < distance[graph.get(now).get(i).getIndex()]) {
					distance[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}

	static void solution() {
		dijkstra(start);

		for (int i = 1; i <= N; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				sb.append("INFINITY").append("\n");
			} else {
				sb.append(distance[i]).append("\n");
			}
		}

		System.out.println(sb);
	}

	public static void main(String[] args) {
		input();
		solution();
	}

	static class FastReader {

		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	static class Node {

		private int index;
		private int distance;

		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		public int getIndex() {
			return index;
		}

		public int getDistance() {
			return distance;
		}
	}
}
