package com.example.codeclan.manylab;

import com.example.codeclan.manylab.models.Department;
import com.example.codeclan.manylab.models.Employee;
import com.example.codeclan.manylab.models.Project;
import com.example.codeclan.manylab.repositories.DepartmentRepository;
import com.example.codeclan.manylab.repositories.EmployeeRepository;
import com.example.codeclan.manylab.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class ManylabApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void getDepartmentAndEmployee() {
		Department department = new Department("Admin");
		departmentRepository.save(department);

		Employee employee = new Employee("John", "Smith", department);
		employeeRepository.save(employee);

		Project project = new Project("test", 5);
		projectRepository.save(project);

		project.addEmployee(employee);
		projectRepository.save(project);
	}
}
