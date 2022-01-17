package 이취코테.구현.왕실의나이트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static String position;
	static Move[] moves = Move.getMoves();

	static void input() {
		position = scan.nextLine();
	}

	static void solution() {
		int row = Character.getNumericValue(position.charAt(1));
		int column = position.charAt(0) - 'a' + 1;

		int answer = 0;
		for (int i = 0; i < 8; i++) {
			int nextRow = row + moves[i].getX();
			int nextColumn = column + moves[i].getY();

			if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	public static void main(String[] args) {
		input();
		solution();
	}

	static class Move {

		private int x;
		private int y;

		public Move(int x, int y) {
			this.x = x;
			this.y = y;
		}

		static Move[] getMoves() {
			return new Move[]{
				new Move(-2, 1),
				new Move(2, 1),
				new Move(-1, 2),
				new Move(1, 2),
				new Move(2, -1),
				new Move(-2, -1),
				new Move(-1, -2),
				new Move(1, -2),
			};
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
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
