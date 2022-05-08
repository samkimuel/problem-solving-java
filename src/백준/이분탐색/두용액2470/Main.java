package 백준.이분탐색.두용액2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] liquid;

	static void input() {
		N = scan.nextInt();

		liquid = new int[N];
		for (int i = 0; i < N; i++) {
			liquid[i] = scan.nextInt();
		}
	}

	static void solution() {
		Arrays.sort(liquid);

		int sum = Integer.MAX_VALUE;
		int first = 0;
		int second = 0;

		for (int i = 0; i < N - 1; i++) {
			int candidate = lowerBound(liquid, i + 1, N - 1, -liquid[i]);

			if (i < candidate - 1 && Math.abs(liquid[i] + liquid[candidate - 1]) < sum) {
				sum = Math.abs(liquid[i] + liquid[candidate - 1]);
				first = liquid[i];
				second = liquid[candidate - 1];
			}

			if (candidate < N && Math.abs(liquid[i] + liquid[candidate]) < sum) {
				sum = Math.abs(liquid[i] + liquid[candidate]);
				first = liquid[i];
				second = liquid[candidate];
			}
		}

		sb.append(first).append(' ').append(second);
		System.out.println(sb);
	}

	static int lowerBound(int[] liquid, int left, int right, int target) {
		int answer = right + 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (liquid[mid] >= target) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return answer;
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
