package 백준.이분탐색.듣보잡1764;

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
	static Set<String> name;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();

		name = new HashSet<>();
		for (int i = 0; i < N; i++) {
			name.add(scan.nextLine());
		}
	}

	static void solution() {
		int count = 0;

		String[] answer = new String[N];
		int index = 0;
		for (int i = 0; i < M; i++) {
			String target = scan.nextLine();
			if (name.contains(target)) {
				count++;
				answer[index++] = target;
			}
		}

		sb.append(count).append('\n');
		Arrays.sort(answer, 0, count);
		for (int i = 0; i < count; i++) {
			sb.append(answer[i]).append('\n');
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
