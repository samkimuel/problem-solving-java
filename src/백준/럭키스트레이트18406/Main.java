package 백준.럭키스트레이트18406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static String N;

	static void input() {
		N = scan.nextLine();
	}

	static void solution() {
		int sumL = 0;
		int sumR = 0;
		for (int i = 0; i < N.length() / 2; i++) {
			sumL += N.charAt(i) - '0';
		}

		for (int i = N.length() / 2; i < N.length(); i++) {
			sumR += N.charAt(i) - '0';
		}

		if (sumL == sumR) {
			sb.append("LUCKY");
		} else {
			sb.append("READY");
		}
		System.out.println(sb);
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
