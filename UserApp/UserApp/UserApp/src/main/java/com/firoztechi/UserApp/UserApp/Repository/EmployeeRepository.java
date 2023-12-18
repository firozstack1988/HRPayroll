package com.firoztechi.UserApp.UserApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.firoztechi.UserApp.UserApp.Entity.Employee;
import com.firoztechi.UserApp.UserApp.Model.EmpDto;
import com.firoztechi.UserApp.UserApp.Model.UserDto;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
 
	  @Query(value = "Select e.emp_id,e.name,e.email_address,e.mobile_no,e.designation,e.dept_name from employee e ",nativeQuery=true)
	  public List<EmpDto> getEployees();
	  
	  public Employee getEmployeeByEmpId(@Param("empId") String empId);
	  
}
