package 백준.완전탐색.N과M15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] value;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();

		value = new int[M + 1];
	}

	static void dfs(int at, int depth) {
		if (depth == M + 1) {
			for (int i = 1; i <= M; i++) {
				sb.append(value[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = at; i <= N; i++) {
			value[depth] = i;
			dfs(i, depth + 1);
		}
	}

	static void solution() {
		dfs(1, 1);
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
