package com.Java_course.spring.core.current.example;

public class JavaCodeCreator implements CodeCreator {
	ClassNameGenerator classNameGenerator;
/**
 * Spring создал объект и заэнжектил на Бин ClassNameGenerator
 * */
	public void setClassNameGenerator(ClassNameGenerator classNameGenerator) {
		this.classNameGenerator = classNameGenerator;
	}

	@Override
	public String getClassExample() {
		return "public class " + classNameGenerator.generateClassName() + "{\n\n}";
	}
}