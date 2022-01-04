package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtil {

	public static void main(String[] args) {
//		sortPrimitiveArray();
//		sortArrayList();
//		sortUsingComparable();
		sortUsingComparator();
	}

	private static void sortPrimitiveArray() {
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		int n = arr.length;

		Arrays.sort(arr);

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void sortArrayList() {
		List<String> strings = Arrays.asList("pineapple", "apple", "orange", "banana");

		Collections.sort(strings);

		for (var string : strings) {
			System.out.print(string + " ");
		}
	}

	private static void sortUsingComparable() {
		List<Fruit> fruits = new ArrayList<>();
		fruits.add(new Fruit("pineapple", 90));
		fruits.add(new Fruit("apple", 100));
		fruits.add(new Fruit("orange", 80));
		fruits.add(new Fruit("banana", 70));

		Collections.sort(fruits);

		for (var fruit : fruits) {
			System.out.println(fruit.toString());
		}
	}

	private static void sortUsingComparator() {
		List<Fruit> fruits = new ArrayList<>();
		fruits.add(new Fruit("pineapple", 80));
		fruits.add(new Fruit("apple", 100));
		fruits.add(new Fruit("orange", 80));
		fruits.add(new Fruit("banana", 80));

		fruits.sort(
			Comparator
				.comparing(Fruit::getQuantity)
				.thenComparing(Fruit::getName)
		);

		for (var fruit : fruits) {
			System.out.println(fruit.toString());
		}
	}

	public static class Fruit implements Comparable<Fruit> {

		private String name;
		private int quantity;

		public Fruit(String name, int quantity) {
			this.name = name;
			this.quantity = quantity;
		}

		public String getName() {
			return name;
		}

		public int getQuantity() {
			return quantity;
		}

		@Override
		public int compareTo(Fruit other) {
			return this.quantity - other.getQuantity();
		}

		@Override
		public String toString() {
			return "Fruit{" +
				"name='" + name + '\'' +
				", quantity=" + quantity +
				'}';
		}
	}
}
