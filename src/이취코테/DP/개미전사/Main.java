package 이취코테.DP.개미전사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] containers;
	static int[] dp;

	static void input() {
		N = scan.nextInt();
		containers = new int[N];
		for (int i = 0; i < N; i++) {
			containers[i] = scan.nextInt();
		}
	}

	static void solution() {
		dp = new int[N];

		dp[0] = containers[0];
		dp[1] = Math.max(containers[0], containers[1]);
		for (int i = 2; i < N; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + containers[i]);
		}

		System.out.println(dp[N - 1]);
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
