package 이취코테.DFSBFS.미로탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] graph;
	static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = scan.nextLine();
			for (int j = 0; j < M; j++) {
				graph[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
	}

	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));

		while (!q.isEmpty()) {
			Node node = q.poll();
			x = node.getX();
			y = node.getY();

			for (int i = 0; i < 4; i++) {
				int nextX = x + dir[i][0];
				int nextY = y + dir[i][1];

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
					continue;
				}

				if (graph[nextX][nextY] == 0) {
					continue;
				}

				if (graph[nextX][nextY] == 1) {
					graph[nextX][nextY] = graph[x][y] + 1;
					q.offer(new Node(nextX, nextY));
				}
			}
		}
	}

	static void solution() {
		bfs(0, 0);

		System.out.println(graph[N - 1][M - 1]);
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

class Node {

	private int x;
	private int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
