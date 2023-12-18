package com.firoztechi.UserApp.UserApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firoztechi.UserApp.UserApp.Model.SalaryProcess;
import com.firoztechi.UserApp.UserApp.Model.SalaryProcessCompositId;

@Repository
public interface SalaryProcessRepository extends JpaRepository<SalaryProcess,SalaryProcessCompositId>{

}
