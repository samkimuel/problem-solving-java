package 프로그래머스.해시.위장;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		// [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]	5
		// [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]	3
		System.out.println(
			solution.solution(
				new String[][]{
					{"yellowhat", "headgear"},
					{"bluesunglasses", "eyewear"},
					{"green_turban", "headgear"}
				}
			)
		);
	}

	public int solution(String[][] clothes) {
		int answer = 1;

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}

		for (String key : map.keySet()) {
			answer *= map.get(key) + 1;
		}

		return answer - 1;
	}
}
