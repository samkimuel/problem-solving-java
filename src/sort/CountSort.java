package sort;

import java.util.Arrays;

/*
 * 데이터의 크기 범위가 제한되어 정수 형태로 표현할 수 있을 때만 사용할 수 있다.
 * 일반적으로 가장 큰 데이터와 가장 작은 데이터의 차이가 1,000,000을 넘지 않을 때 효과적으로 사용할 수 있다.
 * (모든 범위를 담을 수 있는 크기의 리스트-배열-을선언해야하기 때문이다.)
 */
public class CountSort {

	public static void main(String[] args) {

		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
		int n = arr.length;
		int maxValue = Arrays.stream(arr).max().getAsInt();
		int[] count = new int[maxValue + 1];

		countArr(arr, n, count);

		printSortedArray(maxValue, count);
	}

	private static void countArr(int[] arr, int n, int[] count) {
		for (int i = 0; i < n; i++) {
			count[arr[i]] += 1;
		}
	}

	private static void printSortedArray(int maxValue, int[] count) {
		for (int i = 0; i <= maxValue; i++) {
			for (int j = 0; j < count[i]; j++) {
				System.out.print(i + " ");
			}
		}
	}

}
