package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.GroupOrder;
import com.example.demo.login.domain.model.SignupForm;

@Controller
public class SignupController {

	// 라디오 버튼
	private Map<String, String> radioMarriage;
	
	// 라디오 버튼 초기화 메소드
	private Map<String, String> initRadioMarrige(){
		
		Map<String, String> radio = new LinkedHashMap<>();
	
		// 기혼, 미혼
		radio.put("기혼","true");
		radio.put("미혼","false");
		
		return radio;
	}
	
	/** @ModelAttribute : 자동으로 Model 클래스에 등록 (addAttribute)
	 * 다음의 코드를 추가한 것과 같다
	 * model.addAttribute("SignupForm",form);
	 * 또 @ModelAttribute을 붙이면 default로 클래스 명(최초글자 소문자로 바꿔서)이 key로서 등록된다
	 * ex) @ModelAttribute SignupForm form -> "signupForm"이 키로 등록된다.
	 * 만약 키를 변경하고 싶은 경우에는 -> @ModelAttribute("<바꾸고 싶은 key명>") 
	**/
	// 유저 등록화면의 GET용 컨트롤러
	@GetMapping("/signup")
	public String getSignUp(@ModelAttribute SignupForm form, Model model) {
		
		// 라디오 버튼의 초기화
		radioMarriage = initRadioMarrige();
		
		// 라디오 버튼용 Map을 Model에 등록
		model.addAttribute("radioMarriage",radioMarriage);
		
		// signup.html으로 이동
		return "login/signup";
		
	}
	
	/**@Validated VS @Valid
	 * @Validated : 스피링 기준의 어노테이션, 통상 이 어노테이션을 사용
	 *  @Valid : J2EE부터 기준 탑재되어있는 BeanValidator(유효성 검사용 어노테이션)이다. 이 어노테이션도 유효성 검사 실시해준다.
	 *  그러나 메세지용 프로퍼티명이나 메세지를 적는 법이 @Validated에 비해 조금 다르다
	 * **/
	
	// 유저 등록화면의 POST용 컨트롤러
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) SignupForm form, 
			BindingResult bindingResult, 
			Model model) {
		
		/**
		 * 데이터바인드 결과 받기위해서는 메소드의 인수에 BindingResult 클래스를 추가한다.
		 * 이 클래스의 hasErros()메소드를 이용해서 데이터 바인드가 실패 여부를 알 수 있다.
		 * 또  유효성 체크에서 에러가 발생한 경우에도 BindingResult 클래스의 hasErros()로 실패 여부를 확인 가능
		 * 
		 * 유효성 검사에 실패 한 경우
		 * false가 반환된다
		**/
		// 데이터바인드가 실패한 경우
		// 유효성 체크에 걸린 경우 유저 등록화면으로 이동
		if(bindingResult.hasErrors()){
			
			// GET리퀘스트용의 메소드를 불러서 유저 등록화면으로 돌아간다.
			return getSignUp(form, model);
		}
		
		// form의 내용을 콘솔 창에 출력해서 확인
		System.out.println(form);
		
		// login.html로 리다이렉트
		return "redirect:/login";
	}
}
