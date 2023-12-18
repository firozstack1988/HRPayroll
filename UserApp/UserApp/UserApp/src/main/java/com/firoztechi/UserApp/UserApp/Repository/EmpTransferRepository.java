package com.firoztechi.UserApp.UserApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firoztechi.UserApp.UserApp.Entity.EmpTransfer;

@Repository
public interface EmpTransferRepository extends JpaRepository<EmpTransfer,Long>{

}
