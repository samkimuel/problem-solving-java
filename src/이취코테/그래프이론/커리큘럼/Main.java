package 이취코테.그래프이론.커리큘럼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] indegree;
	static List<List<Integer>> lectures;
	static int[] time, result;

	static void input() {
		N = scan.nextInt();
		indegree = new int[N + 1];
		time = new int[N + 1];

		lectures = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			lectures.add(new ArrayList<>());
		}

		for (int i = 1; i <= N; i++) {
			time[i] = scan.nextInt();

			while (true) {
				int pre = scan.nextInt();
				if (pre == -1) {
					break;
				}

				indegree[i] += 1;
				lectures.get(pre).add(i);
			}
		}
	}

	static void solution() {
		result = time.clone();

		topologySort();

		for (int i = 1; i <= N; i++) {
			sb.append(result[i]).append('\n');
		}
		System.out.println(sb);
	}

	static void topologySort() {
		Deque<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : lectures.get(now)) {
				indegree[next] -= 1;

				result[next] = Math.max(result[next], result[now] + time[next]);

				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
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
