package 백준.카드11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static long[] numbers;

	static void input() {
		N = scan.nextInt();
		numbers = new long[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = scan.nextLong();
		}
	}

	static void solution() {
		Arrays.sort(numbers);

		// mode : 최빈값, modeCount : 최빈값의 등장횟수, currentCount : 현재값의 등장횟수
		long mode = numbers[0];
		int modeCount = 1, currentCount = 1;

		for (int i = 1; i < N; i++) {
			if (numbers[i] == numbers[i - 1]) {
				currentCount++;
			} else {
				currentCount = 1;
			}

			if (currentCount > modeCount) {
				modeCount = currentCount;
				mode = numbers[i];
			}
		}

		System.out.println(mode);
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
