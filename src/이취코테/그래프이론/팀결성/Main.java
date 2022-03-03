package 이취코테.그래프이론.팀결성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[] parent;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();

		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}
	}

	static int findParent(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = findParent(parent[x]);
	}

	static void unionParent(int teamA, int teamB) {
		int a = findParent(teamA);
		int b = findParent(teamB);

		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	static void solution() {
		for (int i = 0; i < M; i++) {
			int op = scan.nextInt();
			int teamA = scan.nextInt();
			int teamB = scan.nextInt();
			operate(op, teamA, teamB);
		}
	}

	static void operate(int operation, int teamA, int teamB) {
		if (operation == 0) {
			unionParent(teamA, teamB);
		} else if (operation == 1) {
			isSameTeam(teamA, teamB);
		}
	}

	static void isSameTeam(int teamA, int teamB) {
		if (findParent(teamA) == findParent(teamB)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
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
