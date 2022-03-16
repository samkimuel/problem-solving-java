package other;

public class 숫자뒤집기 {

	public static void main(String[] args) {
		숫자뒤집기 solution = new 숫자뒤집기();

		System.out.println(solution.solution(123)); // 321
		System.out.println(solution.solution(-25)); // -52
		System.out.println(solution.solution(520)); // 25
	}

	/*
	 * int, boolean 만 사용해서 풀기
	 */
	public int solution(int number) {
		int answer = 0;

		boolean isNegative = false;
		if (number < 0) {
			number *= -1;
			isNegative = true;
		}

		while (true) {
			answer += number % 10;
			number /= 10;

			if (number <= 0) {
				break;
			}

			answer *= 10;
		}

		if (isNegative) {
			answer *= -1;
		}

		return answer;
	}
}
