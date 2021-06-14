package jp.sigre.sort;

/**
 * @author sigre
 *
 */
public class Sort {

	public static Integer[] selectionSort(Integer[] a) {

		for (int i = 0; i < a.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[minIndex] > a[j]) minIndex = j;
			}
			swap(a, i, minIndex);
		}

		return a;
	}

	public static Integer[] bubbleSort(Integer[] intArgs) {
		// i は先頭のソート完了した数字の数。末尾2つを残してソートしたあとの処理が最後
		for (int i = 0; i <= intArgs.length - 2; i++) {
			for (int j = intArgs.length - 1; j > i; j--) {
				swap(intArgs, j-1, j);
			}
		}

		return  intArgs;
	}

	public static Integer[] insertionSort(Integer[] intArgs) {

		for (int i = 1; i < intArgs.length; i++) {
			while (i > 0) {
				if (swap(intArgs, i-1, i)) {
					i--;
				} else {
					break;
				}
			}
		}
		return intArgs;
	}

	@SuppressWarnings("unused")
	private static void print(Integer[] arg) {
		for (int i : arg) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	private static boolean swap(Integer[] a, int i, int j) {
		if(a[i] > a[j]) {
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
			return true;
		}
		return false;
	}
}