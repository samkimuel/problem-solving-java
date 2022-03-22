package 백준.파일정리20291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static String[] files;

//	static void input() {
//		N = scan.nextInt();
//
//		files = new String[N];
//		for (int i = 0; i < N; i++) {
//			files[i] = scan.nextLine();
//		}
//	}
//
//	static void solution() {
//		Arrays.sort(files, Comparator.comparing(file -> file.split("\\.")[1]));
//
//		String currentExtension = files[0].split("\\.")[1];
//		int count = 1;
//		for (int i = 1; i < N; i++) {
//			if (currentExtension.equals(files[i].split("\\.")[1])) {
//				count++;
//			} else {
//				sb.append(currentExtension).append(" ").append(count).append("\n");
//				currentExtension = files[i].split("\\.")[1];
//				count = 1;
//			}
//		}
//
//		sb.append(currentExtension).append(" ").append(count).append("\n");
//
//		System.out.println(sb);
//	}

	static void input() {
		N = scan.nextInt();

		files = new String[N];
		for (int i = 0; i < N; i++) {
			files[i] = scan.nextLine().split("\\.")[1];
		}
	}

	static void solution() {
		Map<String, Integer> extensions = new HashMap<>();
		for (int i = 0; i < files.length; i++) {
			extensions.put(files[i], extensions.getOrDefault(files[i], 0) + 1);
		}

		List<String> keys = new ArrayList<>(extensions.keySet());
		Collections.sort(keys);

		for (String extension : keys) {
			sb.append(extension).append(" ").append(extensions.get(extension)).append("\n");
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
