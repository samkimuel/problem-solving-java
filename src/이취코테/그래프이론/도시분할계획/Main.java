package 이취코테.그래프이론.도시분할계획;

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

	static int N, M;
	static int[] parent;
	static List<Road> roads;

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		roads = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			roads.add(new Road(a, b, c));
		}
	}

	static void solution() {
		int answer = 0;

		roads.sort(Comparator.comparing(Road::getCost));

		int lastCost = 0;

		for (Road road : roads) {
			int houseA = road.getHouseA();
			int houseB = road.getHouseB();
			if (findParent(houseA) != findParent(houseB)) {
				unionParent(houseA, houseB);
				answer += road.getCost();
				lastCost = road.getCost();
			}
		}

		System.out.println(answer - lastCost);
	}

	static void unionParent(int houseA, int houseB) {
		int a = findParent(houseA);
		int b = findParent(houseB);

		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	static int findParent(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = findParent(parent[x]);
	}

	public static void main(String[] args) {
		input();
		solution();
	}

	static class Road {

		private int houseA;
		private int houseB;
		private int cost;

		public Road(int houseA, int houseB, int cost) {
			this.houseA = houseA;
			this.houseB = houseB;
			this.cost = cost;
		}

		public int getHouseA() {
			return houseA;
		}

		public int getHouseB() {
			return houseB;
		}

		public int getCost() {
			return cost;
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
