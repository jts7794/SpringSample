package com.example.demo.login.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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
	@Before("execution( * *..*.*Controller.*(..))")
	public void startLog(JoinPoint jp) {
		System.out.println("method start : "+jp.getSignature());
	}
	
	/*AOP의 사용
	 * @After("execution( * com.example.demo.login.controller.LoginController.getLogin(..))")
	 * */
	@After("execution( * *..*.*Controller.*(..))")
	public void endLog(JoinPoint jp) {
		System.out.println("method end : "+jp.getSignature());
	}
}
