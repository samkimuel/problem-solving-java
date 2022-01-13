package 백준.배열합치기11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int[] A, B, ans;
	static int N, M;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		A = new int[N];
		B = new int[M];
		ans = new int[N + M];
		for (int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
		for (int i = 0; i < M; i++) {
			B[i] = scan.nextInt();
		}
	}

	static void solution() {
		int L = 0;
		int R = 0;
		int idx = 0;
		while (L < N || R < M) {
			if (R >= M || (L < N && A[L] <= B[R])) {
				ans[idx] = A[L];
				L++;
			} else if (L >= N || (R < M && A[L] >= B[R])) {
				ans[idx] = B[R];
				R++;
			}
			idx++;
		}

		for (int num : ans) {
			sb.append(num).append(" ");
		}
		System.out.println(sb.toString());
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
