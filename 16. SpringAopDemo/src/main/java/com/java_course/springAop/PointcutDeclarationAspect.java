package com.java_course.springAop;

import org.aspectj.lang.annotation.*;

/**
 *
 */
//@Aspect
//@Component
public class PointcutDeclarationAspect {
	/**
	 * перехват выполнения gete-ов
	 */

	@Pointcut("execution(public * com.java_course.springAop.UserDAO.get*(..))") // pointcut expression
	public void userDAOGetTrackerPointcut() {
	}

	/**
	 * перехват выполнения сеттеров
	 */
	@Pointcut("execution(public * com.java_course.springAop.UserDAO.set*(..))") // pointcut expression
	public void userDAOSetTrackerPointcut() {
	}

	/**
	 * в случае необходимоси перехвата и того и другого
	 */
	@Pointcut("userDAOGetTrackerPointcut() || userDAOSetTrackerPointcut()") // pointcut expression
	public void userDAOGetOrSetTrackerPointcut() {
	}

	@Before("userDAOGetOrSetTrackerPointcut()") // || && !
	public void userDAOGetOrSetTracker() {
		System.out.println("В классе UserDAO вызывают геттер или сеттер");
	}
}
