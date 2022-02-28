package 이취코테.이진탐색.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, target;
	static int[] arr;

	static void input() {
		N = scan.nextInt();
		target = scan.nextInt();

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
	}

	static int recursiveBinarySearch(int[] array, int target, int start, int end) {
		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;

		if (array[mid] == target) {
			return mid;
		} else if (array[mid] < target) {
			return recursiveBinarySearch(array, target, mid + 1, end);
		} else {
			return recursiveBinarySearch(array, target, start, mid - 1);
		}
	}

	static void solution() {
		int answer = recursiveBinarySearch(arr, target, 0, N - 1);
		if (answer == -1) {
			System.out.println("타겟이 존재하지 않아요:(");
		} else {
			System.out.println(answer + 1);
		}
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
