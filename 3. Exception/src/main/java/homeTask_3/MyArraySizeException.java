/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package homeTask_3;

/**
 * Класс MyArraySizeException
 */
public class MyArraySizeException extends MyLibHomeException {
	public MyArraySizeException() {
		super("Размер входного массива не 4х4");
	}
}