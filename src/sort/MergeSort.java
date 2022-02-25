package sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8, 10, 14, 2, 1};
		int[] sorted = new int[arr.length];

		mergeSort(arr, sorted, 0, arr.length - 1);

		for (var i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void mergeSort(int[] arr, int[] sorted, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;

			mergeSort(arr, sorted, start, mid);
			mergeSort(arr, sorted, mid + 1, end);

			merge(arr, sorted, start, mid, end);
		}
	}

	private static void merge(int[] arr, int[] sorted, int start, int mid, int end) {
		int left = start;
		int right = mid + 1;
		int index = start;

		while (left <= mid && right <= end) {
			if (arr[left] <= arr[right]) {
				sorted[index] = arr[left];
				left++;
			} else {
				sorted[index] = arr[right];
				right++;
			}

			index++;
		}

		while (left <= mid) {
			sorted[index] = arr[left];
			index++;
			left++;
		}

		while (right <= end) {
			sorted[index] = arr[right];
			index++;
			right++;
		}

		for (int i = start; i <= end; i++) {
			arr[i] = sorted[i];
		}
	}
}
