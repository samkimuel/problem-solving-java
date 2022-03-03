package 이취코테.그래프이론.신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class SpanningTree {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int V, E;
	static int[] parent;
	static List<Edge> edges;

	static void input() {
		V = scan.nextInt();
		E = scan.nextInt();

		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		edges = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			int nodeA = scan.nextInt();
			int nodeB = scan.nextInt();
			int cost = scan.nextInt();
			edges.add(new Edge(nodeA, nodeB, cost));
		}
	}

	static int findParent(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = findParent(parent[x]);
	}

	static void unionParent(int nodeA, int nodeB) {
		nodeA = findParent(nodeA);
		nodeB = findParent(nodeB);
		if (nodeA < nodeB) {
			parent[nodeB] = nodeA;
		} else {
			parent[nodeA] = nodeB;
		}
	}

	static void solution() {
		int answer = 0;

		edges.sort(Comparator.comparing(Edge::getCost));

		for (Edge edge : edges) {
			int nodeA = edge.getNodeA();
			int nodeB = edge.getNodeB();
			int cost = edge.getCost();
			if (findParent(nodeA) != findParent(nodeB)) {
				unionParent(nodeA, nodeB);
				answer += cost;
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) {
		input();
		solution();
	}

	static class Edge {

		private int nodeA;
		private int nodeB;
		private int cost;

		public Edge(int nodeA, int nodeB, int cost) {
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.cost = cost;
		}

		public int getNodeA() {
			return nodeA;
		}

		public int getNodeB() {
			return nodeB;
		}

		public int getCost() {
			return cost;
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
