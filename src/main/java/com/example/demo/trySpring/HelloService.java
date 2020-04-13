package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Autowired
	private HelloRepository helloRepository;
	
	public Employee findOne(int id) {
		
		// 1건 검색 실행
		Map<String, Object> map = helloRepository.findOne(id);
		
		// Map에서 값 취득
		int employeeId = (Integer) map.get("employee_id");
		String employeeName = (String) map.get("employee_name");
		int age = (Integer) map.get("age");
		
		// Employee 클래스에 세트
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setAge(age);
		
		return employee;
	}
}
