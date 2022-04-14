package 백준.이분탐색.두수의합3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int n, x;
	static int[] a;

	static void input() {
		n = scan.nextInt();

		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}

		x = scan.nextInt();
	}

	static void solution() {
		Arrays.sort(a);

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (binarySearch(x - a[i], i + 1)) {
				count++;
			}
		}

		System.out.println(count);
	}

	static boolean binarySearch(int target, int left) {
		int right = n - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (target < a[mid]) {
				right = mid - 1;
			} else if (target > a[mid]) {
				left = mid + 1;
			} else {
				return true;
			}
		}

		return false;
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
