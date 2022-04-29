package 백준.정렬.화살표그리기15970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static List<Point> points;


	static void input() {
		N = scan.nextInt();

		points = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			points.add(new Point(x, y));
		}
	}

	static void solution() {
		points.sort(Comparator.comparing(Point::getX));

		Map<Integer, List<Point>> colourListMap = points.stream()
			.collect(Collectors.groupingBy(Point::getY));

		int answer = 0;
		for (int colour : colourListMap.keySet()) {
			List<Point> list = colourListMap.get(colour);
			list.sort(Comparator.comparing(Point::getX));

			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					answer += Math.abs(list.get(i).getX() - list.get(i + 1).getX());
					continue;
				}

				if (i == list.size() - 1) {
					answer += Math.abs(list.get(i).getX() - list.get(i - 1).getX());
					continue;
				}

				answer += Math.min(
					Math.abs(list.get(i).getX() - list.get(i + 1).getX()),
					Math.abs(list.get(i).getX() - list.get(i - 1).getX())
				);
			}
		}

		System.out.println(answer);
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

	static class Point {

		private final int x; // 좌표
		private final int y; // 색깔

		public Point(int x, int y) {
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
}
