package com.firoztechi.UserApp.UserApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firoztechi.UserApp.UserApp.Entity.EmpTransfer;
import com.firoztechi.UserApp.UserApp.Repository.EmpTransferRepository;

@Service
public class EmpTransferServiceImpl implements EmpTransferService{
 
	@Autowired
	private EmpTransferRepository empTransferRepository;
	
	@Override
	public void add(EmpTransfer empTransfer) throws Exception {
		try {
			empTransferRepository.save(empTransfer);
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}

}
