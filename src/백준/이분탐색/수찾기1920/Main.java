package 백준.이분탐색.수찾기1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] A;
	static Set<Integer> set;

	static void input() {
		N = scan.nextInt();

		A = new int[N];
		set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(scan.nextInt());
		}

//		for (int i = 0; i < N; i++) {
//			A[i] = scan.nextInt();
//		}

		M = scan.nextInt();
	}

	// Set
	static void solution() {
		for (int i = 0; i < M; i++) {
			if (set.contains(scan.nextInt())) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}

		System.out.println(sb);
	}

	// 이분탐색
	static void solution(int num) {
		Arrays.sort(A);

		sb.append(binarySearch(num)).append("\n");
	}

	static int binarySearch(int num) {
		int left = 0;
		int right = N - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (A[mid] == num) {
				return 1;
			} else if (A[mid] < num) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		input();
		solution();

//		for (int i = 0; i < M; i++) {
//			solution(scan.nextInt());
//		}
//
//		System.out.println(sb);
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
