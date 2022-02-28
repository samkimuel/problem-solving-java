package 이취코테.이진탐색.떡볶이떡만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] tteok;
	static int highestTteok;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		tteok = new int[N];
		highestTteok = 0;
		for (int i = 0; i < N; i++) {
			tteok[i] = scan.nextInt();

			if (tteok[i] > highestTteok) {
				highestTteok = tteok[i];
			}
		}
	}

	static void solution() {
		int answer = 0;
		int start = 0;
		int end = highestTteok;

		while (start <= end) {
			int maxHeight = 0;
			int mid = (start + end) / 2;
			for (int i = 0; i < N; i++) {
				if (tteok[i] > mid) {
					maxHeight += tteok[i] - mid;
				}
			}

			if (maxHeight < M) {
				end = mid - 1;
			} else {
				answer = mid;
				start = mid + 1;
			}
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
