package com.firoztechi.UserApp.UserApp.Service;

import com.firoztechi.UserApp.UserApp.Entity.FundTransfer;

public interface FundTransferService {

	public void add(FundTransfer fundTransfer)throws Exception;
	public double getAvailBal(Long debitAcc)throws Exception;
}
