package 백준.이분탐색.먹을것인가먹힐것인가7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] A, B;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();

		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
		B = new int[M];
		for (int i = 0; i < M; i++) {
			B[i] = scan.nextInt();
		}
	}

	static void solution() {
		Arrays.sort(B);

		int answer = 0;
		for (int i = 0; i < A.length; i++) {
			answer += binarySearch(A[i]);
		}

		System.out.println(answer);
	}

	static int binarySearch(int num) {
		int result = 0;
		int start = 0;
		int end = M - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (B[mid] < num) {
				result = mid + 1;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			input();
			solution();
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
