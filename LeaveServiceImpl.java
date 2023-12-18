package com.firoztechi.UserApp.UserApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firoztechi.UserApp.UserApp.Entity.LeaveEntry;
import com.firoztechi.UserApp.UserApp.Repository.LeaveRpository;

@Service
public class LeaveServiceImpl implements LeaveService{

	@Autowired
	private LeaveRpository leaveRpository;
	
	@Override
	public void add(LeaveEntry leave) throws Exception {
		
		try {
			leaveRpository.save(leave);
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}

}
