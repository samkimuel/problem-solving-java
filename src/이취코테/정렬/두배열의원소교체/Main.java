package 이취코테.정렬.두배열의원소교체;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static Integer[] A, B;

	static void input() {
		N = scan.nextInt();
		K = scan.nextInt();
		A = new Integer[N];
		B = new Integer[N];
		for (int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
		for (int i = 0; i < N; i++) {
			B[i] = scan.nextInt();
		}
	}

	static void solution() {
		Arrays.sort(A);
		Arrays.sort(B, Comparator.reverseOrder());

		for (int i = 0; i < K; i++) {
			if (A[i] >= B[i]) {
				break;
			}

			int temp = A[i];
			A[i] = B[i];
			B[i] = temp; // 사실 필요 없음
		}

		System.out.println(Arrays.stream(A).mapToInt(Integer::intValue).sum());
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

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
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
