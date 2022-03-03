package 이취코테.그래프이론.서로소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DisjointSet {

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

		return findParent(parent[x]);
	}

	static int compressionFindParent(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = compressionFindParent(parent[x]);
	}

	static void unionParent(int nodeA, int nodeB) {
//		nodeA = findParent(nodeA);
//		nodeB = findParent(nodeB);

		nodeA = compressionFindParent(nodeA);
		nodeB = compressionFindParent(nodeB);

		if (nodeA < nodeB) {
			parent[nodeB] = nodeA;
		} else {
			parent[nodeA] = nodeB;
		}
	}

	static void solution() {
		for (int i = 0; i < E; i++) {
			int nodeA = scan.nextInt();
			int nodeB = scan.nextInt();
			unionParent(nodeA, nodeB);
		}

		sb.append("각 원소가 속한 집합 : ");
		for (int i = 1; i <= V; i++) {
			sb.append(compressionFindParent(i)).append(" ");
		}
		sb.append("\n");
		sb.append("부모 테이블 : ");
		for (int i = 1; i <= V; i++) {
			sb.append(parent[i]).append(" ");
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
