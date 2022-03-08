package 백준.퇴사14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] T, P;
	static int answer = 0;

	static void input() {
		N = scan.nextInt();

		T = new int[N + 1];
		P = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			T[i] = scan.nextInt();
			P[i] = scan.nextInt();
		}
	}

	static void bruteforce(int depth, int value) {
		if (depth == N + 1) {
			answer = Math.max(answer, value);
			return;
		}

		if (depth > N + 1) {
			return;
		}

		bruteforce(depth + T[depth], value + P[depth]);
		bruteforce(depth + 1, value);
	}

	static void solution() {
		bruteforce(1, 0);

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
