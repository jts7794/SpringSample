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
	 * 
	 * group 속성 : 인터페이스의 클래스를 지정함으로써 필드와 그룹을 연결
	 * **/
	
	// 필수 입력, 메일 형식
	@NotBlank(groups = ValidGroup1.class)
	@Email(groups = ValidGroup2.class)
	private String userId;
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 4, max =100, groups = ValidGroup2.class)
	@Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup3.class)
	private String password;
	
	@NotBlank(groups = ValidGroup1.class)
	private String userName;
	
	
	// @DateTimeFormat : 화면으로부터 전해진 문자열을 일자형으로 교환
	// pattern 속성을 이용해서 어떤 형태로 바꿀지 정할 수 있다.
	@NotNull(groups = ValidGroup1.class)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday; 
	
	// 값이 20부터 100까지
	@Min(value = 20, groups = ValidGroup2.class)
	@Max(value = 100, groups = ValidGroup2.class)
	private int age;
	
	// false가능
	@AssertFalse(groups = ValidGroup2.class)
	private boolean marriage; 
	
	/** 별지
		@NumberFormat : 지정된 포멧의  문자열을 수치형으로 교환 
		ex) @NumberFormat(pattern = "#,###")
		String salary;
	**/
}
