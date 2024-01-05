package com.firoztechi.UserApp.UserApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firoztechi.UserApp.UserApp.Entity.LedgerMaster;

@Repository
public interface LedgerMasterRepository extends JpaRepository<LedgerMaster,String>{

}
