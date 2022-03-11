package 프로그래머스.해시.전화번호목록;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		//phone_book	return
		//["119", "97674223", "1195524421"]	false
		//["123","456","789"]	true
		//["12","123","1235","567","88"]	false
		System.out.println(solution.solution(new String[]{"119", "97674223", "1195524421"}));
	}

	public boolean solution(String[] phone_book) {
		boolean answer = true;

		Arrays.sort(phone_book);

		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i])) {
				return false;
			}
		}

		return answer;
	}
}
