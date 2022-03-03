package 이취코테.그래프이론.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class TopologySort {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int V, E;
	static int[] indegree;
	static List<List<Integer>> graph;
	static List<Integer> answer = new ArrayList<>();

	static void input() {
		V = scan.nextInt();
		E = scan.nextInt();

		indegree = new int[V + 1];

		graph = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			graph.get(from).add(to);
			indegree[to] += 1;
		}
	}

	static void topologySort() {
		Deque<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= V; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int now = q.poll();
			answer.add(now);
			for (int i = 0; i < graph.get(now).size(); i++) {
				indegree[graph.get(now).get(i)] -= 1;

				if (indegree[graph.get(now).get(i)] == 0) {
					q.offer(graph.get(now).get(i));
				}
			}
		}
	}

	static void solution() {
		topologySort();

		for (int i = 0; i < answer.size(); i++) {
			sb.append(answer.get(i)).append(" ");
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
