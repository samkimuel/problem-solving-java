package 이취코테.그리디.큰수의법칙;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M, K;
	static int[] array;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		K = scan.nextInt();
		array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = scan.nextInt();
		}
	}

	static void solution() {
		Arrays.sort(array);
		int first = array[N - 1];
		int second = array[N - 2];

		int answer = 0;
		while (M > 0) {
			for (int i = 0; i < K; i++) {
				if (M == 0) {
					break;
				}
				answer += first;
				M--;
			}

			if (M == 0) {
				break;
			}
			answer += second;
			M--;
		}

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
