package 백준.완전탐색.NQueen9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, answer = 0;
	static int[] board;

	static void input() {
		N = scan.nextInt();
		board = new int[N + 1];
	}

	static void nQueen(int col) {
		if (col == N + 1) {
			answer++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			board[col] = i;
			boolean isPossible = true;
			for (int j = 1; j < col; j++) {
				if (board[j] == board[col] || Math.abs(j - col) == Math.abs(board[j] - board[col])) {
					isPossible = false;
					break;
				}
			}

			if (isPossible) {
				nQueen(col + 1);
			}
		}
	}

	static void solution() {
		nQueen(1);
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
