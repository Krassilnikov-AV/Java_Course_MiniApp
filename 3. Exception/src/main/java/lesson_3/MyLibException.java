/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package lesson_3;

/**
 * Класс MyLibException
 */
public class MyLibException extends RuntimeException {

	public MyLibException() {}

	public MyLibException(String message) {
		super(message);
	}
}