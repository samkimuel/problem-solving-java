package 이취코테.이진탐색.부품찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class MainSet {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static Set<Integer> parts;
	static int[] requestParts;

	static void input() {
		N = scan.nextInt();
		parts = new HashSet<>();
		for (int i = 0; i < N; i++) {
			parts.add(scan.nextInt());
		}

		M = scan.nextInt();
		requestParts = new int[M];
		for (int i = 0; i < M; i++) {
			requestParts[i] = scan.nextInt();
		}
	}

	static void solution() {
		for (int i = 0; i < M; i++) {
			if (parts.contains(requestParts[i])) {
				sb.append("yes").append(" ");
			} else {
				sb.append("no").append(" ");
			}
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
