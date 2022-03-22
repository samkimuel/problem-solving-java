package 백준.정렬.수열정렬1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] A;

	static void input() {
		N = scan.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
	}

	static void solution() {
		List<Element> elements = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			elements.add(new Element(i, A[i]));
		}

		elements.sort(Comparator.comparing(Element::getValue).thenComparing(Element::getIndex));

		int[] P = new int[N];
		for (int i = 0; i < N; i++) {
			P[elements.get(i).getIndex()] = i;
		}

		for (int i = 0; i < N; i++) {
			sb.append(P[i]).append(" ");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) {
		input();
		solution();
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
