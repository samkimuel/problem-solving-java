package 백준.DFS와BFS1260;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M, V;
	static int[][] graph;
	static boolean[] visited;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		V = scan.nextInt();
		graph = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			graph[x][y] = graph[y][x] = 1;
		}
	}

	static void dfs(int x) {
		visited[x] = true;
		sb.append(x).append(" ");

		for (int y = 1; y <= N; y++) {
			if (graph[x][y] == 0) {
				continue;
			}

			if (visited[y]) {
				continue;
			}

			dfs(y);
		}
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int x = q.poll();
			sb.append(x).append(" ");

			for (int y = 1; y <= N; y++) {
				if (graph[x][y] == 0) {
					continue;
				}

				if (visited[y]) {
					continue;
				}

				q.add(y);
				visited[y] = true;
			}
		}
	}

	static void solution() {
		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		for (int i = 1; i <= N; i++) {
			visited[i] = false;
		}
		bfs(V);
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
