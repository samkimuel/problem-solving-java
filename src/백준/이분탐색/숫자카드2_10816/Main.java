package 백준.이분탐색.숫자카드2_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] nums, targets;

	static void input() {
		N = scan.nextInt();
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = scan.nextInt();
		}

		M = scan.nextInt();
		targets = new int[M];
		for (int i = 0; i < M; i++) {
			targets[i] = scan.nextInt();
		}
	}

	static int lowerBound(int target) {
		int left = 0;
		int right = N - 1;
		int ans = right + 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (nums[mid] >= target) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return ans;
	}

	static int upperBound(int target) {
		int left = 0;
		int right = N - 1;
		int ans = right + 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (nums[mid] > target) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return ans;
	}

	static void solution() {
		Arrays.sort(nums);

		for (int i = 0; i < M; i++) {
			int upper = upperBound(targets[i]);
			int lower = lowerBound(targets[i]);
			sb.append(upper - lower).append(' ');
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
