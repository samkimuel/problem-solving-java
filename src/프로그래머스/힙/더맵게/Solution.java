package 프로그래머스.힙.더맵게;

import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		//scoville	K	return
		//[1, 2, 3, 9, 10, 12]	7	2
		System.out.println(solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
	}

	public int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int value : scoville) {
			pq.offer(value);
		}

		while (!pq.isEmpty()) {
			if (pq.size() < 2 && pq.peek() < K) {
				return -1;
			}

			int lowest = pq.poll();

			if (lowest >= K) {
				break;
			}

			int second = pq.poll();
			int mixScoville = lowest + second * 2;
			pq.offer(mixScoville);
			answer++;
		}

		return answer;
	}
}
