package 백준.구현.달팽이1913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, T;
	static int[][] map;
	static int[] coordinate = new int[2];

	// 남동북서
	static int[] moveR = new int[]{1, 0, -1, 0};
	static int[] moveC = new int[]{0, 1, 0, -1};

	static void input() {
		N = scan.nextInt();
		T = scan.nextInt();

		map = new int[N][N];
	}

	static void solution() {
		Snail snail = new Snail(0, 0, 0, N * N);

		while (true) {
			map[snail.getRow()][snail.getCol()] = snail.getNum();

			if (!snail.move()) {
				break;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(" ");

				if (map[i][j] == T) {
					coordinate[0] = i + 1;
					coordinate[1] = j + 1;
				}
			}
			sb.append("\n");
		}
		sb.append(coordinate[0]).append(" ").append(coordinate[1]);
		System.out.println(sb);
	}

	public static void main(String[] args) {
		input();
		solution();
	}

	static class Snail {

		private int row;
		private int col;
		private int dir;
		private int num;

		public Snail(int row, int col, int dir, int num) {
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.num = num;
		}

		public boolean move() {
			int nextR = row + moveR[dir];
			int nextC = col + moveC[dir];

			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || map[nextR][nextC] != 0) {
				dir = (dir + 1) % 4;
			}

			nextR = row + moveR[dir];
			nextC = col + moveC[dir];

			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || map[nextR][nextC] != 0) {
				return false;
			}

			row = nextR;
			col = nextC;
			num -= 1;
			map[row][col] = num;

			return true;
		}

		public int getRow() {
			return row;
		}

		public int getCol() {
			return col;
		}

		public int getNum() {
			return num;
		}
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
