package com.firoztechi.UserApp.UserApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firoztechi.UserApp.UserApp.Entity.Employee;
import com.firoztechi.UserApp.UserApp.Model.EmpDto;
import com.firoztechi.UserApp.UserApp.Model.EmployeeModel;
import com.firoztechi.UserApp.UserApp.Repository.EmployeeRepository;
import com.firoztechi.UserApp.UserApp.Repository.UserRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public String addEmployee(Employee employee) throws Exception {
		try {
			employeeRepository.save(employee);
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	    return null;	
	}
	@Override
	public EmployeeModel getEmployee(String empId) throws Exception {
		EmployeeModel employeeModel =null;
		try {
			Employee emp=employeeRepository.getEmployeeByEmpId(empId);
			employeeModel=modelMapper.map(emp, EmployeeModel.class);
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
		return employeeModel;
	}
	@Override
	public String generateEmpId() throws Exception {
		long genEmpId=0;
		try {
		if(countEmployee()==0) 
			genEmpId=100001;
		else	
		    genEmpId=100001+countEmployee();
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
		return String.valueOf(genEmpId);
	}
	private long countEmployee() {
		long maxRow=employeeRepository.count();
		return maxRow;
	}
	
   @Override
   public List<EmployeeModel> getEmployees() throws Exception{
	  List<EmployeeModel>list=new ArrayList<EmployeeModel>();	  
	   try {
		   List<EmpDto> employees=employeeRepository.getEployees();
		   employees.forEach(p->{
			   EmployeeModel employeeModel =new EmployeeModel();
			   employeeModel.setEmpId(p.getEmp_id());
			   employeeModel.setName(p.getName());
			   employeeModel.setDeptName(p.getDept_name());
			   employeeModel.setEmailAddress(p.getEmail_address());
			   employeeModel.setMobileNo(p.getMobile_no());
			   employeeModel.setDesignation(p.getDesignation());
			   list.add(employeeModel);
		   });  
	   }
	   catch(Exception e) {
		throw new Exception(e.getLocalizedMessage());   
	   }
	   return list;
   }
}
