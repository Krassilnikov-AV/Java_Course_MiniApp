package com.Java_course.spring.core.current.example;

public class ShapesClassNameGenerator implements ClassNameGenerator {
    public String generateClassName() {
        String[] names = {"Square", "Circle", "Ellipse", "Triangle"};
        return names[(int) (Math.random() * 4)];
    }
}
