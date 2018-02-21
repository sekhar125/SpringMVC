package com.test.common.controller;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.common.Employee;

@RestController
@RequestMapping("/hello")
public class SpringRestController {
	Map<String, Employee> employeeMap = new HashMap<String, Employee>();

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String hello(@PathVariable String name) {
		String result = "Hello " + name;
		return result;
	}

	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Employee add(@RequestBody Employee employee) {
		System.out.print("Add method Begin");
		employeeMap.put(employee.getId(), employee);
		System.out.print("Add method End" + employeeMap);
		return employee;
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON  })
	public Employee get(@PathVariable String id) {
		Employee employee = null;
		System.out.print("get method Begin" + id);
		if (employeeMap.get(id) == null) {
			employee = new Employee();
			employee.setId("0");
			employee.setName("default");
		}
		return employee;
	}
}
