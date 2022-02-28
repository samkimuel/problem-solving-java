package 이취코테.이진탐색.부품찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainBinarySearch {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] parts, partNum;

	static void input() {
		N = scan.nextInt();
		parts = new int[N];
		for (int i = 0; i < N; i++) {
			parts[i] = scan.nextInt();
		}

		M = scan.nextInt();
		partNum = new int[M];
		for (int i = 0; i < M; i++) {
			partNum[i] = scan.nextInt();
		}
	}

	static int binarySearch(int[] arr, int target, int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (parts[mid] == target) {
				return mid;
			} else if (parts[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return -1;
	}

	static void solution() {
		for (int i = 0; i < M; i++) {
			int answer = binarySearch(parts, partNum[i], 0, N - 1);

			if (answer == -1) {
				sb.append("no").append(" ");
			} else {
				sb.append("yes").append(" ");
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
