package 이취코테.구현.게임개발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int characterX, characterY, direction;
	static int[][] visited = new int[50][50];
	static int[][] map = new int[50][50];

	static int[] moveX = {-1, 0, 1, 0};
	static int[] moveY = {0, 1, 0, -1};

	public static void input() {
		N = scan.nextInt();
		M = scan.nextInt();

		characterX = scan.nextInt();
		characterY = scan.nextInt();
		visited[characterX][characterY] = 1;
		direction = scan.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scan.nextInt();
			}
		}
	}

	public static void solution() {
		int moveCount = 1;
		int turnCount = 0;
		while (true) {
			turnLeft();
			int nextX = characterX + moveX[direction];
			int nextY = characterY + moveY[direction];
			if (map[nextX][nextY] == 0 && visited[nextX][nextY] == 0) {
				characterX = nextX;
				characterY = nextY;
				visited[characterX][characterY] = 1;
				turnCount = 0;
				moveCount++;
				continue;
			} else if (visited[nextX][nextY] == 1) {
				turnCount++;
			}

			if (turnCount == 4) {
				nextX = characterX - moveX[direction];
				nextY = characterY - moveY[direction];
				if (map[nextX][nextY] == 0) {
					characterX = nextX;
					characterY = nextY;
				} else if (map[nextX][nextY] == 1) {
					break;
				}
				turnCount = 0;
			}
		}

		System.out.println(moveCount);
	}

	public static void turnLeft() {
		direction--;
		if (direction == -1) {
			direction = 3;
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
