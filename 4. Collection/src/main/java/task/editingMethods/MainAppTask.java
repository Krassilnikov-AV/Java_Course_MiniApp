/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task.editingMethods;

import java.util.Arrays;

/**
 * Класс MainAppTask
 */
public class MainAppTask {

	public static void main(String[] args) {
		String[] arr = {"A", "B", "C", "E", "D"};
		System.out.println("Начальный массив: " + Arrays.toString(arr));
		EditingArray editingArray = new EditingArray();

		editingArray.swap(arr, 3, 4);
		System.out.println("Результат: " + Arrays.toString(arr));

		editingArray.arrToList(arr);
		System.out.println("Список ArrayList: " + Arrays.toString(arr));

		editingArray.convertToList(arr);

	}

}