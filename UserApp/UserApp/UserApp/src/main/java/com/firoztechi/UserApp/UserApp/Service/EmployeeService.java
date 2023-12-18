package com.firoztechi.UserApp.UserApp.Service;

import java.util.List;

import com.firoztechi.UserApp.UserApp.Entity.Employee;
import com.firoztechi.UserApp.UserApp.Model.EmployeeModel;

public interface EmployeeService {

	public String addEmployee(Employee employee) throws Exception;
	public EmployeeModel getEmployee(String empId) throws Exception;
	public String generateEmpId() throws Exception;
	public List<EmployeeModel> getEmployees() throws Exception;
}
