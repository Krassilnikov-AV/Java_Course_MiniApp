/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task.editingMethods;

/**
 * Класс EditingArray
 */
public class EditingArray {

	/*метод, позволяющий менять местами 2 выбранные переменные массива*/
	public void swap(Object[] arr, int n1, int n2) {
		Object obj = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = obj;
	}

	/*преобразование массива в список*/
	public void arrToList(Object[] arr) {
		List arList = (new ArrayList<>(Arrays.asList(arr)));
	}

	/*преобразование массива в список через дженерик*/
	public <T> ArrayList<T> convertToList(T[] array) {
		return new ArrayList<>(Arrays.asList(array));
	}
}