package 이취코테.DP.효율적인화폐구성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] moneys;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();

		moneys = new int[N];
		for (int i = 0; i < N; i++) {
			moneys[i] = scan.nextInt();
		}
	}

	static void solution() {
		int[] dp = new int[M + 1]; // dp[i] : i원을 만들기 위한 최소한의 화폐 개수
		Arrays.fill(dp, 10001);

		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = moneys[i]; j <= M; j++) {
				if (dp[j - moneys[i]] != 10001) {
					dp[j] = Math.min(dp[j], dp[j - moneys[i]] + 1);
				}
			}
		}

		if (dp[M] == 10001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[M]);
		}
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
