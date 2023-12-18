package com.firoztechi.UserApp.UserApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.firoztechi.UserApp.UserApp.Entity.LeaveEntry;

@Repository
public interface LeaveRpository extends JpaRepository<LeaveEntry,Long>{
	
	@Query(value = "Select count(number_of_days) as totalleave from leave_entry  WHERE employee_id=:empId",nativeQuery=true)
	public int getEmpLeaveByempId( @Param("empId") String empId);
}
