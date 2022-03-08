package 백준.로봇청소기14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

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

	static void solution() {
		int nTurn = 0;
		while (true) {
			if (map[r][c] == 0) {
				map[r][c] = 2;
				answer++;
			}

			turn();
			nTurn++;

			int nextR = r + move[d][0];
			int nextC = c + move[d][1];
			if (map[nextR][nextC] == 0) {
				r = nextR;
				c = nextC;
				nTurn = 0;
				continue;
			}

			if (nTurn == 4) {
				nextR = r - move[d][0];
				nextC = c - move[d][1];

				if (map[nextR][nextC] == 1) {
					break;
				} else {
					r = nextR;
					c = nextC;
					nTurn = 0;
				}
			}
		}

		System.out.println(answer);
	}

	private static void turn() {
		d--;
		if (d < 0) {
			d = 3;
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
