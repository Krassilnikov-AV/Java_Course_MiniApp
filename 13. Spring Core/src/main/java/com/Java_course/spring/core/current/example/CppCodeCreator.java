package com.Java_course.spring.core.current.example;

public class CppCodeCreator implements CodeCreator {
	ClassNameGenerator classNameGenerator;

	public void setClassNameGenerator(ClassNameGenerator classNameGenerator) {
		this.classNameGenerator = classNameGenerator;
	}

	@Override
	public String getClassExample() {
		return "public class " + classNameGenerator.generateClassName() + " {\n\n}";
	}

	public CppCodeCreator(ClassNameGenerator classNameGenerator) {
		this.classNameGenerator = classNameGenerator;
	}
}
