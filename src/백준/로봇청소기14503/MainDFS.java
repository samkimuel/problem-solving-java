package 백준.로봇청소기14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainDFS {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int[][] map;
	static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	static int N, M;
	static int r, c, d;
	static int answer = 0;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();

		r = scan.nextInt();
		c = scan.nextInt();
		d = scan.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scan.nextInt();
			}
		}
	}

	static void dfs(int r, int c, int d) {
		if (map[r][c] == 0) {
			map[r][c] = 2;
			answer++;
		}

		for (int i = 0; i < 4; i++) {
			d = turn(d);
			int nextR = r + move[d][0];
			int nextC = c + move[d][1];

			if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && map[nextR][nextC] == 0) {
				dfs(nextR, nextC, d);

				return;
			}
		}

		int backR = r - move[d][0];
		int backC = c - move[d][1];
		if (map[backR][backC] != 1) {
			dfs(backR, backC, d);
		}
	}

	static int turn(int dir) {
		dir--;
		if (dir < 0) {
			dir = 3;
		}

		return dir;
	}

	static void solution() {
		dfs(r, c, d);

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
