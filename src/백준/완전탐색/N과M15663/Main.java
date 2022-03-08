package 백준.완전탐색.N과M15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] num, selected;
	static boolean[] visited;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();

		num = new int[N];
		selected = new int[M];
		for (int i = 0; i < N; i++) {
			num[i] = scan.nextInt();
		}

		visited = new boolean[N];
	}

	static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(num[selected[i]]).append(" ");
			}
			sb.append("\n");

			return;
		}

		int lastNum = 0;
		for (int i = 0; i < N; i++) {
			if (!visited[i] && num[i] != lastNum) {
				visited[i] = true;
				lastNum = num[i];
				selected[depth] = i;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}

	static void solution() {
		Arrays.sort(num);

		dfs(0);

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
