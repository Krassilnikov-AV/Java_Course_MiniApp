/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package homeTask_3;

public class MainExceptionHomeWork {

	public static void main(String[] args) {
		String[][] arr = {
			{"1", "2", "3", "5"},
			{"4", "5", "6", "6"},
			{"4", "5", "6", "8"},
			{"4", "5", "6", "8"}
		};
		try {
			System.out.println(calculate(arr));

		} catch (MyLibHomeException e) {
			System.out.println("ignored");
		}
	}

	public static int calculate(String[][] data) {

		if (data.length != 4) {
			throw new MyArraySizeException();
		}
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if (data[i].length != 4) {
				throw new MyArraySizeException();
			}
			for (int j = 0; j < 4; j++) {
				try {
					sum += Integer.parseInt(data[i][j]);
				} catch (NumberFormatException e) {
					throw new MyArrayDataException();
				}
			}
		}
		return sum;
	}
}