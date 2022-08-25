package com.java_course.springAop;

import org.springframework.stereotype.Component;

/**данный класс для того чтобы показать что выражение addUser()
 * перехватывало бы в любом классе, а не тоько в UserDAO
 * */
@Component
public class ExternalSystemUserDAO {
    public void addUser() {
        System.out.println("New External User added");
    }
}
