package com.firoztechi.UserApp.UserApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.firoztechi.UserApp.UserApp.Entity.BranchConfig;
import com.firoztechi.UserApp.UserApp.Entity.Holidays;

@Repository
public interface BranchConfigRepository extends JpaRepository<BranchConfig,Long>{

	public BranchConfig getBranchConfigByBranchCode(@Param("branchCode") String branchCode);
}
