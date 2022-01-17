package 이취코테.구현.상하좌우;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static String[] plan;
	static int x = 1, y = 1;
	static int[] moveX = {0, 0, -1, 1};
	static int[] moveY = {-1, 1, 0, 0};
	static String[] moveType = {"L", "R", "U", "D"};

	static void input() {
		N = scan.nextInt();
		plan = scan.nextLine().split(" ");
	}

	static void solution() {
		for (int i = 0; i < plan.length; i++) {
			int nextX = 0, nextY = 0;
			for (int j = 0; j < 4; j++) {
				if (plan[i].equals(moveType[j])) {
					nextX = x + moveX[j];
					nextY = y + moveY[j];
				}
			}

			if (nextX < 1 || nextY < 1 || nextX > N || nextY > N) {
				continue;
			}
			x = nextX;
			y = nextY;
		}

		System.out.println(sb.append(x).append(" ").append(y));
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

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
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
