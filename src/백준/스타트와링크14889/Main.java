package 백준.스타트와링크14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] S;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;

	static void input() {
		N = scan.nextInt();

		S = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				S[i][j] = scan.nextInt();
			}
		}
	}

	static void bruteforce(int at, int depth) {
		if (depth == N / 2 + 1) {
			calculateDifference();

			return;
		}

		for (int i = at; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				bruteforce(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}

	static void calculateDifference() {
		int teamStart = 0;
		int teamLink = 0;

		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (visited[i] && visited[j]) {
					teamStart += S[i][j];
					teamStart += S[j][i];
				} else if (!visited[i] && !visited[j]) {
					teamLink += S[i][j];
					teamLink += S[j][i];
				}
			}
		}

		answer = Math.min(answer, Math.abs(teamStart - teamLink));
	}

	static void solution() {
		bruteforce(1, 1);

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
