package jp.sigre.sort;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class SortTest {

	@Test
	public void insertionSortTest1() {
		Integer[] testData = {1,2,3,4};
		assertThat(Sort.insertionSort(testData), is(arrayContaining(1,2,3,4)));
	}

	@Test
	public void insertionSortTest2() {
		Integer[] testData = {2,3,1,4};
		assertThat(Sort.insertionSort(testData), is(arrayContaining(1,2,3,4)));
	}


	@Test
	public void insertionSortTest3() {
		Integer[] testData = {4,3,2,1};
        assertThat(Sort.insertionSort(testData), is(arrayContaining(1,2,3,4)));
	}

	@Test
	public void bubbleSortTest1() {
		Integer[] testData = {1,2,3,4};
		assertThat(Sort.bubbleSort(testData), is(arrayContaining(1,2,3,4)));
	}

	@Test
	public void bubbleSortTest2() {
		Integer[] testData = {2,3,1,4};
		assertThat(Sort.bubbleSort(testData), is(arrayContaining(1,2,3,4)));
	}


	@Test
	public void bubbleSortTest3() {
		Integer[] testData = {4,3,2,1};
		assertThat(Sort.bubbleSort(testData), is(arrayContaining(1,2,3,4)));
	}
	@Test
	public void selectionSortTest1() {
		Integer[] testData = {1,2,3,4};
		assertThat(Sort.selectionSort(testData), is(arrayContaining(1,2,3,4)));
	}

	@Test
	public void selectionSortTest2() {
		Integer[] testData = {2,3,1,4};
		assertThat(Sort.selectionSort(testData), is(arrayContaining(1,2,3,4)));
	}


	@Test
	public void selectionSortTest3() {
		Integer[] testData = {4,3,2,1};
		assertThat(Sort.selectionSort(testData), is(arrayContaining(1,2,3,4)));
	}
}
