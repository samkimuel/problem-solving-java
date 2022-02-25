package sort;

public class QuickSortV2 {

	public static void main(String[] args) {
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

		midQuickSort(arr, 0, arr.length - 1);

		for (var i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void leftQuickSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}

		int pivot = start;
		int left = start + 1;
		int right = end;
		while (left <= right) {
			while (left <= end && arr[left] <= arr[pivot]) {
				left++;
			}

			while (right > start && arr[right] >= arr[pivot]) {
				right--;
			}

			if (left <= right) {
				swap(arr, left, right);
			}
		}

		swap(arr, pivot, right);

		leftQuickSort(arr, start, right - 1);
		leftQuickSort(arr, right + 1, end);
	}

	private static void rightQuickSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}

		int pivot = end;
		int left = start;
		int right = end - 1;
		while (left <= right) {
			while (left < end && arr[left] <= arr[pivot]) {
				left++;
			}

			while (right >= start && arr[right] >= arr[pivot]) {
				right--;
			}

			if (left <= right) {
				swap(arr, left, right);
			}
		}

		swap(arr, pivot, left);

		rightQuickSort(arr, start, left - 1);
		rightQuickSort(arr, left + 1, end);
	}

	private static void midQuickSort(int[] arr, int start, int end) {
		int pivot = (start + end) / 2;
		int left = start;
		int right = end;

		while (left <= right) {
			while (arr[left] < arr[pivot]) {
				left++;
			}

			while (arr[right] > arr[pivot]) {
				right--;
			}

			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}

		if (start < left - 1) {
			midQuickSort(arr, start, left - 1);
		}

		if (end > left) {
			midQuickSort(arr, left, end);
		}
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
