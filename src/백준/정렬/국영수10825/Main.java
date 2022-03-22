package 백준.정렬.국영수10825;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static List<Student> students;

	static void input() {
		N = scan.nextInt();
		students = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			students.add(new Student(scan.next(), scan.nextInt(), scan.nextInt(), scan.nextInt()));
		}
	}

	static void solution() {
		students.sort(
			Comparator
				.comparing(Student::getKorean, Comparator.reverseOrder())
				.thenComparing(Student::getEnglish)
				.thenComparing(Student::getMath, Comparator.reverseOrder())
				.thenComparing(Student::getName)
		);

		for (var student : students) {
			sb.append(student.getName()).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		input();
		solution();
	}

	static class Student {

		private String name;
		private int korean, english, math;

		public Student(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		public String getName() {
			return name;
		}

		public int getKorean() {
			return korean;
		}

		public int getEnglish() {
			return english;
		}

		public int getMath() {
			return math;
		}
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
