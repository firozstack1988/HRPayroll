package com.firoztechi.UserApp.UserApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firoztechi.UserApp.UserApp.Entity.BranchConfig;
import com.firoztechi.UserApp.UserApp.Repository.BranchConfigRepository;

@Service
public class BranchConfigServiceImpl implements BranchConfigService{

	@Autowired
	private BranchConfigRepository branchConfigRepository;
	
	@Override
	public void add(BranchConfig branchConfig) throws Exception {
		try {
			branchConfigRepository.save(branchConfig);
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}

}
