package 이취코테.최단경로.전보;

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

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M, C;
	static List<List<Node>> graph;
	static int[] distance;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		C = scan.nextInt();

		distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			int distance = scan.nextInt();
			graph.get(from).add(new Node(to, distance));
		}
	}

	static void dijkstra(int start) {
		Queue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getDistance));
		pq.offer(new Node(start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.getIndex();
			int dist = node.getDistance();

			if (distance[now] < dist) {
				continue;
			}

			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = dist + graph.get(now).get(i).getDistance();
				if (cost < distance[graph.get(now).get(i).getIndex()]) {
					distance[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}

	static void solution() {
		dijkstra(C);

		int count = 0;
		int maxDist = 0;
		for (int dist : distance) {
			if (dist != Integer.MAX_VALUE) {
				count++;
				maxDist = Math.max(maxDist, dist);
			}
		}

		sb.append(count - 1).append(" ").append(maxDist);
		System.out.println(sb);
	}

	public static void main(String[] args) {
		input();
		solution();
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
