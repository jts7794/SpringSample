package com.example.demo.login.domain.model;

import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	
	/**
	 * 유효성 검사 @NotBlank, @NotNull, @DateTimeFormat, @Min, @Max, @Email
	 * 
	 * message속성을 붙여줌으로써 message.properties의 단독키와 연결이 가능
	 * 연결 방법
	 * message="{<단독 키 명>}"
	 * 
	 * 참고 직접 에러메세지를 지정하는 방법
	 * @NotBlank(message="패스워드를 입력해주세요")
	 * **/
	
	// 필수 입력, 메일 형식
	@NotBlank
	@Email
	private String userId;
	
	@NotBlank
	@Length(min = 4, max =100)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String password;
	
	@NotNull
	private String userName;
	
	
	// @DateTimeFormat : 화면으로부터 전해진 문자열을 일자형으로 교환
	// pattern 속성을 이용해서 어떤 형태로 바꿀지 정할 수 있다.
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday; 
	
	// 값이 20부터 100까지
	@Min(20)
	@Max(100)
	private int age;
	
	// false가능
	@AssertFalse
	private boolean marriage; 
	
	/** 별지
		@NumberFormat : 지정된 포멧의  문자열을 수치형으로 교환 
		ex) @NumberFormat(pattern = "#,###")
		String salary;
	**/
}
