package 이취코테.DFSBFS.음료수얼려먹기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] graph;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();

		graph = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String str = scan.nextLine();
			for (int j = 1; j <= M; j++) {
				graph[i][j] = Character.getNumericValue(str.charAt(j - 1));
			}
		}
	}

	static boolean dfs(int x, int y) {
		if (x < 1 || x > N || y < 1 || y > M) {
			return false;
		}

		if (graph[x][y] == 0) {
			graph[x][y] = 1;
			dfs(x - 1, y);
			dfs(x, y - 1);
			dfs(x + 1, y);
			dfs(x, y + 1);
			return true;
		}

		return false;
	}

	static void solution() {
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (dfs(i, j)) {
					answer++;
				}
			}
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
