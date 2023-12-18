package com.firoztechi.UserApp.UserApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.firoztechi.UserApp.UserApp.Entity.Employee;
import com.firoztechi.UserApp.UserApp.Entity.SalaryAllowance;
@Repository
public interface SalaryAllowanceRepository extends JpaRepository<SalaryAllowance,Long>{
    
	//@Query(value="SELECT s.house_rent,s.lunch,s.medical,s.transport,s.city_allowance,s.credit_allowance,s.provident_fund FROM salary_allowance s where s.year=:year ",nativeQuery=true)
	//public SalaryAllowance getSalaryAllowance(@Param("year") int year);
    public SalaryAllowance getSalaryAllowanceByYear(@Param("year") int year);
}
