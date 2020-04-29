package com.example.demo.login.domain.model;

import javax.validation.GroupSequence;

//그룹의 실행 순서
/* Validation을 그룹 실행하기위해서는 실행 순서를 설정하는 인터페이스에 @GroupSequence어노테이션을 붙여야한다.
 * 어노테이션 파라메터에는 각 그룹의 이름.class
 * 또 지정된 순서는 왼쪽부터 순서대로
 * */
@GroupSequence({ValidGroup1.class, ValidGroup2.class, ValidGroup3.class})
public interface GroupOrder {
	
}
