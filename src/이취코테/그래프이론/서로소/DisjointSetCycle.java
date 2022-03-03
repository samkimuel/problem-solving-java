package 이취코테.그래프이론.서로소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DisjointSetCycle {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int V, E;
	static int[] parent;

	static void input() {
		V = scan.nextInt();
		E = scan.nextInt();

		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}

	static int findParent(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = findParent(parent[x]);
	}

	static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);

		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	static void solution() {
		boolean cycle = false;

		for (int i = 0; i < E; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();

			if (parent[a] == parent[b]) {
				cycle = true;
				break;
			} else {
				unionParent(a, b);
			}
		}

		if (cycle) {
			System.out.println("사이클 발생!");
		} else {
			System.out.println("사이클 발생하지 않음!");
		}
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
