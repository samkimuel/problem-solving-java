package 백준.완전탐색.연산자끼워넣기14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, min, max;
	static int[] num, operator;

	static void input() {
		N = scan.nextInt();

		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = scan.nextInt();
		}

		operator = new int[4];
		for (int i = 0; i < 4; i++) {
			operator[i] = scan.nextInt();
		}

		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
	}

	static void dfs(int depth, int value) {
		if (depth == N - 1) {
			min = Math.min(min, value);
			max = Math.max(max, value);
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;
				dfs(depth + 1, calculate(value, num[depth + 1], i));
				operator[i]++;
			}
		}
	}

	static int calculate(int operand1, int operand2, int operator) {
		switch (operator) {
			case 0:
				return operand1 + operand2;
			case 1:
				return operand1 - operand2;
			case 2:
				return operand1 * operand2;
			default:
				return operand1 / operand2;
		}
	}

	static void solution() {
		dfs(0, num[0]);
		sb.append(max).append('\n').append(min);
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
