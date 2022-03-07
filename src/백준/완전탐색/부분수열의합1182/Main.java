package 백준.완전탐색.부분수열의합1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, S, answer = 0;
	static int[] num;

	static void input() {
		N = scan.nextInt();
		S = scan.nextInt();

		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = scan.nextInt();
		}
	}

	static void dfs(int depth, int value) {
		if (depth == N) {
			if (value == S) {
				answer++;
			}
			return;
		}

		dfs(depth + 1, value);
		dfs(depth + 1, value + num[depth]);
	}

	static void solution() {
		dfs(0, 0);

		if (S == 0) { // 부분수열 아닐 때
			answer--;
		}

		System.out.println(answer);
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
