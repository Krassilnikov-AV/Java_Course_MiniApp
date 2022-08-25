package com.java_course.springAop;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Aspect
 * @Component
 * @Before("execution(public void com.java_course.springAop.UserDAO.addUser())"
 * Аннотация @Before говорит о том, что кусок кода должен сработать перед каким то методом.
 */
@Aspect
@Component
public class AppLoggingAspect {
	/**
	 * ? - знак вопроса означает, что данный кусок кода не обязателен, его можно пропустить*/
	// "execution(modifier-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern)
	// throws-pattern?)"
	// execution([модификатор_метода(public, *)?] [тип_возврата] [класс?] [имя_метода]([аргументы]) [исключения?]

//    @Before("execution(public void com.java_course.springAop.UserDAO.addUser())") // pointcut expression
//    public void aopSimpleMethod() {
//        System.out.println("AOP кусок кода");
//    }

//    @Before("execution(public void com.java_course.springAop.UserDAO.addUser())") // pointcut expression
//    public void beforeAddUserInUserDAOClass() {
//        System.out.println("AOP: Поймали добавление пользователя");
//    }
/**
 *  *(звёздочка) - означает что перед словом User может быть любая комбинация символов
 *  вместо возвращаемого типа (public void com....) можно ставить " * " (public * com....),
 *  тогда будет работать с любым возвращаемым типом.
 * */
//    @Before("execution(public void com.java_course.springAop.UserDAO.*User())") // pointcut expression
//    public void beforeUserModifyInUserDAOClass() {
//        System.out.println("AOP: работа с пользователем в UserDAO");
//    }
	/**
	 *
	 * */
//    @Before("execution(public void com.java_course.springAop.UserDAO.*())") // pointcut expression
//    public void beforeAnyMethodWithoutArgsInUserDAOClass() {
//        System.out.println("AOP: любой метод без аргументов из UserDAO");
//    }
/**
 * - в аргументе метода .. означает любое количество аргументов
 * - если * - означает только один аргумент
 * - springAop.*.* - любой класс из папки springAop
 * */
//    @Before("execution(public void com.java_course.springAop.*.*(..))") // pointcut expression
//    public void beforeAnyMethodInUserDAOClass() {
//        System.out.println("AOP: любой метод без аргументов из UserDAO");
//    }
/**
 * JoinPoint joinPoint - получение информации о выполняемом методе
 * joinPoint.getSignature() - получение сигнатуры метода
 * .getArgs() - вызов метода позволит просмотреть вложенные аргументы в методе
 * */
//    @Before("execution(public void com.java_course.springAop.UserDAO.*(..))") // pointcut expression
//    public void beforeAnyMethodInUserDAOClassWithDetails(JoinPoint joinPoint) {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        System.out.println("В UserDAO был вызван метод: " + methodSignature);
//        Object[] args = joinPoint.getArgs();
//        if (args.length > 0) {
//            System.out.println("Аргументы:");
//            for (Object o : args) {
//                System.out.println(o);
//            }
//        }
//    }
/**
 *  @AfterReturning - даёт возможность вклиниться в возвращаемый метод и ввставить определённое значение
 *  result.set(0, "Donald Duck") - в первый возвращаемый аргумент вставит "Donald Duck"
 *  !!!! - необходимо осторожно обращаться с данной аннотацией
 * */
//    @AfterReturning(
//            pointcut = "execution(public * com.java_course.springAop.UserDAO.getAllUsers(..))",
//            returning = "result")
//    public void afterGetBobInfo(JoinPoint joinPoint, List<String> result) {
//        result.set(0, "Donald Duck");
//    }
/**
 * после выполнения исючения*/
//    @AfterThrowing(
//            pointcut = "execution(public * com.java_course.springAop.UserDAO.*)",
//            throwing = "exc")
//    public void afterThrowing(JoinPoint joinPoint, Throwable exc) {
//        System.out.println(exc); // logging
//    }
/**
 * после выполнения метода
 * */
//    @After("execution(public * com.java_course.springAop.UserDAO.*)")
//    public void afterMethod() {
//        System.out.println("After");
//    }
/**
 *  methodProfiling() - позволит засекать время выполнение вызываемого метода
 *  @Around - перехват метода с обеих сторон
 *  ProceedingJoinPoint proceedingJoinPoint -
 *  proceedingJoinPoint.proceed() - выполнение перехваченного метода
 *
 * */
//    @Around("execution(public * com.java_course.springAop.UserDAO.*(..))")
//    public void methodProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("start profiling");
//        long begin = System.currentTimeMillis();
//        proceedingJoinPoint.proceed();
//        long end = System.currentTimeMillis();
//        long duration = end - begin;
//        System.out.println((MethodSignature) proceedingJoinPoint.getSignature() + " duration: " + duration);
//        System.out.println("end profiling");
//    }
/**
 * refactoring - возвращает объект*/
//	@Around("execution(public * com.java_course.springAop.UserDAO.*(..))")
//	public Object methodProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		System.out.println("start profiling");
//		long begin = System.currentTimeMillis();
//		Object out = proceedingJoinPoint.proceed();
//		long end = System.currentTimeMillis();
//		long duration = end - begin;
//		System.out.println((MethodSignature) proceedingJoinPoint.getSignature() + " duration: " + duration);
//		System.out.println("end profiling");
//		return out;
//	}
}
