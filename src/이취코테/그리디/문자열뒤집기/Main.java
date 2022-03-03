package 이취코테.그리디.문자열뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static String S;

	static void input() {
		S = scan.nextLine();
	}

	static void solution() {
		int countFlipZero = 0;
		int countFlipOne = 0;

		if (S.charAt(0) == '0') {
			countFlipOne = 1;
		} else {
			countFlipZero = 1;
		}

		for (int i = 0; i < S.length() - 1; i++) {
			if (S.charAt(i) != S.charAt(i + 1)) {
				if (S.charAt(i) == '0') {
					countFlipZero++;
				} else {
					countFlipOne++;
				}
			}
		}

		System.out.println(Math.min(countFlipZero, countFlipOne));
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
