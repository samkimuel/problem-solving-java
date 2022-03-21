package 프로그래머스.DFSBFS.단어변환;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	boolean[] visited;

	public static void main(String[] args) {
		Solution solution = new Solution();

		// "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
		// "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
		System.out.println(solution.solution(
			"hit",
			"cog",
			new String[]{"hot", "dot", "dog", "lot", "log", "cog"}
		));
		System.out.println(solution.solution(
			"hit",
			"cog",
			new String[]{"hot", "dot", "dog", "lot", "log"}
		));
	}

	public int solution(String begin, String target, String[] words) {
		boolean flag = false;
		for (String word : words) {
			if (word.equals(target)) {
				flag = true;
				break;
			}
		}

		if (!flag) {
			return 0;
		}

		visited = new boolean[words.length];

		return bfs(begin, target, words);
	}

	public int bfs(String begin, String target, String[] words) {
		Queue<Elem> q = new LinkedList<>();
		int depth = 0;
		q.offer(new Elem(begin, depth));

		while (!q.isEmpty()) {
			Elem e = q.poll();

			if (e.getWord().equals(target)) {
				depth = e.getDepth();
				break;
			}

			for (int i = 0; i < words.length; i++) {
				if (!visited[i] && isNext(e.getWord(), words[i])) {
					q.offer(new Elem(words[i], e.getDepth() + 1));
					visited[i] = true;
				}
			}
		}

		return depth;
	}

	public boolean isNext(String now, String next) {
		int cnt = 0;
		for (int i = 0; i < now.length(); i++) {
			if (now.charAt(i) == next.charAt(i)) {
				cnt++;
			}
		}

		if (cnt == now.length() - 1) {
			return true;
		}

		return false;
	}
}

class Elem {

	private String word;
	private int depth;

	public Elem(String word, int depth) {
		this.word = word;
		this.depth = depth;
	}

	public String getWord() {
		return word;
	}

	public int getDepth() {
		return depth;
	}
}
