package 백준.정렬.단어정렬1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static Set<String> stringSet;
	static String[] strings;

	static void input() {
		N = scan.nextInt();
		stringSet = new HashSet<>();
		for (int i = 0; i < N; i++) {
			stringSet.add(scan.nextLine());
		}
	}

	static void inputV2() {
		N = scan.nextInt();

		strings = new String[N];
		for (int i = 0; i < N; i++) {
			strings[i] = scan.nextLine();
		}
	}

	static void solution() {
		stringSet.stream()
			.sorted(Comparator.comparingInt(String::length).thenComparing(String::compareTo))
			.collect(Collectors.toList())
			.forEach(string -> sb.append(string).append("\n"));

		System.out.println(sb);
	}

	static void solutionV2() {
		Arrays.sort(strings, Comparator.comparing(String::length).thenComparing(String::compareTo));

		for (int i = 0; i < N; i++) {
			if (i > 0 && strings[i].equals(strings[i - 1])) {
				continue;
			}
			sb.append(strings[i]).append("\n");
		}

		System.out.println(sb);
	}

	public static void main(String[] args) {
//		input();
//		solution();
		inputV2();
		solutionV2();
	}

	static class Element {

		private int index;
		private int value;

		public Element(int index, int value) {
			this.index = index;
			this.value = value;
		}

		public int getIndex() {
			return index;
		}

		public int getValue() {
			return value;
		}
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
