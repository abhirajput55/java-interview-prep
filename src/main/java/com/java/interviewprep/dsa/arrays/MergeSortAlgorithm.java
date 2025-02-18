package com.java.interviewprep.dsa.arrays;

public class MergeSortAlgorithm {

	public static void main(String[] args) {

		int[] arr = { 5, 2, 9, 1, 6 };

		mergeSort(arr, 0, arr.length - 1);

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void mergeSort(int[] arr, int left, int right) {

		if (left < right) {

			int mid = (left + right) / 2;

			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);

			merge(arr, left, mid, right);
		}

	}

	private static void merge(int[] arr, int left, int mid, int right) {

		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] lArr = new int[n1];
		int[] rArr = new int[n2];

		for (int i = 0; i < n1; i++) {
			lArr[i] = arr[left + i];
		}

		for (int i = 0; i < n2; i++) {
			rArr[i] = arr[mid + 1 + i];
		}

		int i = 0, j = 0;
		int k = left;

		while (i < n1 && j < n2) {
			if (lArr[i] <= rArr[j]) {
				arr[k] = lArr[i];
				i++;
			} else {
				arr[k] = rArr[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = lArr[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = rArr[j];
			j++;
			k++;
		}

	}

}
