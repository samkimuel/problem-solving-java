package 이취코테.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SimpleShortestPath {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int start;
	static List<List<Node>> graph;
	static int[] dist;
	static boolean[] visited;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		start = scan.nextInt();
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			int cost = scan.nextInt();
			graph.get(from).add(new Node(to, cost));
		}
	}

	static void dijkstra(int start) {
		dist[start] = 0;
		visited[start] = true;
		for (int i = 0; i < graph.get(start).size(); i++) {
			dist[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
		}

		for (int i = 0; i < N - 1; i++) { // 시작 노드를 제외한 전체 N-1개의 노드에 대해
			int now = getSmallestNode();
			visited[now] = true;
			for (int j = 0; j < graph.get(now).size(); j++) {
				int cost = dist[now] + graph.get(now).get(j).getDistance();
				if (cost < dist[graph.get(now).get(j).getIndex()]) {
					dist[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
	}

	private static int getSmallestNode() {
		int minValue = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 1; i <= N; i++) {
			if (dist[i] < minValue && !visited[i]) {
				minValue = dist[i];
				index = i;
			}
		}

		return index;
	}

	static void solution() {
		dijkstra(start);

		for (int i = 1; i <= N; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INFINITY").append("\n");
			} else {
				sb.append(dist[i]).append("\n");
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
}

class Node {

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
