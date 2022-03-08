package 백준.완전탐색.암호만들기1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int L, C;
	static char[] chars;
	static int[] selected;

	static void input() {
		L = scan.nextInt();
		C = scan.nextInt();

		chars = new char[C];
		selected = new int[L];
		String[] token = scan.nextLine().split(" ");
		for (int i = 0; i < C; i++) {
			chars[i] = token[i].charAt(0);
		}
	}

	static void dfs(int at, int depth) {
		if (depth == L) {
			int nVowel = 0;
			int nConsonant = 0;

			for (int i = 0; i < L; i++) {
				if (isVowel(chars[selected[i]])) {
					nVowel++;
				} else {
					nConsonant++;
				}
			}

			if (nVowel >= 1 && nConsonant >= 2) {
				for (int i = 0; i < L; i++) {
					sb.append(chars[selected[i]]);
				}
				sb.append("\n");
			}

			return;
		}

		for (int i = at; i < C; i++) {
			selected[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}

	private static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	static void solution() {
		Arrays.sort(chars);
		dfs(0, 0);
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
