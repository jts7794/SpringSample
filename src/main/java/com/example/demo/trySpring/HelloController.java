package com.example.demo.trySpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String getHello() {
		
		// hello.html이동
		return "hello";
	}
	

	// Point1 -> @PostMapping : @GetMapping랑 같은 양식, 메소드에@PostMapping어노테이션을 붙인다. Post메소드로 보내진 경우 처리가 가능하도록 
	// Point2 -> @RequestParam : 메소드 인수에 @RequestParam어노테이션을 붙이면, 화면에서부터 입력 내용을 받는다. 어노테이션 인수는 html의 name속성의 값을 지정한다.
	//                           hello.html의 소스 (일부 발췌) : <input type="text" name="text1" th:value="${text1_value}"/>
	
	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1")String str, 
			Model model) {
		
		// Point3 -> model.addAttribute : 여기에 Key랑 값을 설정하면 화면(html)로 부터 지정한 Key의 값을 받을수 있다. 
		// 화면에서 받은 문자열을 Model객체에 등록
		model.addAttribute("sample", str);
		
		// helloResponse.html에 이동
		return "helloResponse";
		
	}
	
}
