package com.example.demo.login.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
@Aspect
@Component
public class LogAspect {

	/*AOP의 사용
	 * @Before("execution( * com.example.demo.login.controller.LoginController.getLogin(..))")
	 * "execution(<리턴 값><패키지 명>.<클래스 명>.<메소드 명>(<파라메터>))"
	 * 리턴 값 : *(アスタリスク)를 이용. 모든 리턴 값을 지정
	 * 패키지 명 : 『*..*』로 지정. 전 패키지가 대상
	 * 클래스명 :  『* Controller』로 지정. 말미에 Controller가 붙은 클래스가 대상
	 * 파라메터 : (..2개) 모든 파라메터가 대상
	 * */
	/*
	@Before("execution( * *..*.*Controller.*(..))")
	public void startLog(JoinPoint jp) {
		System.out.println("method start : "+jp.getSignature());
	}
	*/
	/*AOP의 사용
	 * @After("execution( * com.example.demo.login.controller.LoginController.getLogin(..))")
	 * */
	/*
	@After("execution( * *..*.*Controller.*(..))")
	public void endLog(JoinPoint jp) {
		System.out.println("method end : "+jp.getSignature());
	}
	*/
	
	/*@Around
	 * JoinPoint(실행 타이밍)에서 Around를 사용 경우, @Around 어노테이션을 사용한다 
	 * Around를 사용한 경우, 어노테이션을 붙인 메소드 중 AOP대상 클래스의 메소드를 직접 실행한다. proceed메소드에서 실행하고 있다
	 * 따라서 Around를 사용하면 메소드 실행 전후의 임의의 처리를 하는 것이 가능하다.
	 * 메소드를 직접 실행하기 때문에 반환 값에는 실행 결과의 리턴 값을 지정. *주의 : Around내의 메소드의 실행을 잊어버리면 안된다
	 * */
	@Around("execution( * *..*.*Controller.*(..))")
	public Object startLog(ProceedingJoinPoint jp)throws Throwable{
		
		System.out.println("method start : " + jp.getSignature());
		
		try {
			// 메소드 실행
			Object result = jp.proceed();
			
			System.out.println("method end : " + jp.getSignature());
			
			return result;
		}catch (Exception e) {
			System.out.println("method abnormal end : "+ jp.getSignature());
			e.printStackTrace();
			throw e;
		}
	}
}
