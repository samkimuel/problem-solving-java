package 백준.DP.평범한배낭12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int[] weight, value;

	static void input() {
		N = scan.nextInt();
		K = scan.nextInt();

		weight = new int[N + 1];
		value = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			weight[i] = scan.nextInt();
			value[i] = scan.nextInt();
		}
	}

	static void solution() {
		// dp[n][k] : n개의 물건을 담았을 때 k무게가 되는 가치의 최댓값
		int[][] dp = new int[N + 1][K + 1];
		dp[0][0] = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j - weight[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + value[i]);
				}
			}
		}

		System.out.println(dp[N][K]);
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
