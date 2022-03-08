package 백준.에디터1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static String string;
	static int M;
	static String[] command;
	static Deque<Character> stackL = new ArrayDeque<>();
	static Deque<Character> stackR = new ArrayDeque<>();

	static void input() {
		string = scan.nextLine();
		for (int i = 0; i < string.length(); i++) {
			stackL.push(string.charAt(i));
		}

		M = scan.nextInt();

		command = new String[M];
		for (int i = 0; i < M; i++) {
			command[i] = scan.nextLine();
		}
	}

	static void solution() {
		for (int i = 0; i < M; i++) {
			char commandType = command[i].charAt(0);

			switch (commandType) {
				case 'L' :
					commandL();
					break;
				case 'D' :
					commandD();
					break;
				case 'B' :
					commandB();
					break;
				case 'P' :
					commandP(command[i].charAt(2));
					break;
				default:
					break;
			}
		}

		while (!stackL.isEmpty()) {
			stackR.push(stackL.pop());
		}

		while (!stackR.isEmpty()) {
			sb.append(stackR.pop());
		}

		System.out.println(sb);
	}

	static void commandL() {
		if (!stackL.isEmpty()) {
			stackR.push(stackL.pop());
		}
	}

	static void commandD() {
		if (!stackR.isEmpty()) {
			stackL.push(stackR.pop());
		}
	}

	static void commandB() {
		if (!stackL.isEmpty()) {
			stackL.pop();
		}
	}

	static void commandP(char value) {
		stackL.push(value);
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
