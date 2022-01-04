package sort;

public class InsertionSort {

	public static void main(String[] args) {

		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		int n = arr.length;

		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				} else {
					break;
				}
			}
		}

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}
