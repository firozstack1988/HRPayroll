package com.firoztechi.UserApp.UserApp.Service;

import java.util.Date;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firoztechi.UserApp.UserApp.Entity.FundTransfer;
import com.firoztechi.UserApp.UserApp.Entity.LedgerBal;
import com.firoztechi.UserApp.UserApp.Entity.TranHistory;
import com.firoztechi.UserApp.UserApp.Repository.FundTransferRepository;
import com.firoztechi.UserApp.UserApp.Repository.LedgerBalRepository;
import com.firoztechi.UserApp.UserApp.Repository.TranHistoryRepository;

@Service
public class FundTransferServiceImpl implements FundTransferService{

	@Autowired
	private FundTransferRepository fundTransferRepository;
	@Autowired
	private TranHistoryRepository tranHistoryRepository;
	@Autowired
	private LedgerBalRepository ledgerBalRepository;
	
	@Override
	@Transactional
	public void add(FundTransfer fundTransfer) throws Exception {
		try {
			fundTransferRepository.save(fundTransfer);
			try {
				insertTranHistory(fundTransfer);
				try {
				updateCreditGlCodeBal(fundTransfer);
				}
				catch(Exception e) {
					throw new Exception(e.getLocalizedMessage());
				}
				updateDebitGlCodeBal(fundTransfer);
			}
			catch(Exception e) {
				throw new Exception(e.getLocalizedMessage());
			}
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}
	private void insertTranHistory(FundTransfer fundTransfer)throws Exception {
		TranHistory tranHistory=new TranHistory();
		try {
			tranHistory.setCreatedBy(fundTransfer.getCreatedBy());
			tranHistory.setCreatedOn(new Date());
			tranHistory.setCreitGlCode(fundTransfer.getCreditAcc());
			tranHistory.setDebitGlCode(fundTransfer.getDebitAcc());	
			tranHistory.setTranAmt(fundTransfer.getTranAmt());
			tranHistory.setTranDate(new Date());
			tranHistory.setTranType(fundTransfer.getTranType());
			tranHistoryRepository.save(tranHistory);
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}
	
	private void updateCreditGlCodeBal(FundTransfer fundTransfer)throws Exception{
		double presentCrGlBal=0.0;
		double presentGlCurrBal=0.0;
		try {
		Optional<LedgerBal> ledgerBal=ledgerBalRepository.findByGlCode(fundTransfer.getCreditAcc());
		if(ledgerBal.isPresent()){
			presentCrGlBal =ledgerBal.get().getCreditBal()+fundTransfer.getTranAmt();
			presentGlCurrBal=ledgerBal.get().getCurrBal()+fundTransfer.getTranAmt();
		}
		try {
			ledgerBalRepository.updateCrGlCodeBal(fundTransfer.getCreditAcc(), presentCrGlBal, presentGlCurrBal);
		}
		catch(Exception e) {
		    throw new Exception(e.getLocalizedMessage());
		}
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}
	private void updateDebitGlCodeBal(FundTransfer fundTransfer)throws Exception{
		double presentDrGlBal=0.0;
		double presentGlCurrBal=0.0;
		try {
		Optional<LedgerBal> ledgerBal=ledgerBalRepository.findByGlCode(fundTransfer.getDebitAcc());
		if(ledgerBal.isPresent()){
			double debitAmt=ledgerBal.get().getCurrBal();
			double currBal=ledgerBal.get().getCurrBal();
			if(debitAmt>fundTransfer.getTranAmt()) {
			     presentDrGlBal =debitAmt-fundTransfer.getTranAmt();
			     presentGlCurrBal=currBal-fundTransfer.getTranAmt();
			 }
			else
				throw new Exception("Current balance must greater than transaction amount");
		}
		try {
			ledgerBalRepository.updateDrGlCodeBal(fundTransfer.getDebitAcc(), presentDrGlBal, presentGlCurrBal);
		}
		catch(Exception e) {
		    throw new Exception(e.getLocalizedMessage());
		}
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}
 
	@Override
	public double getAvailBal(Long debitAcc) throws Exception {
		double availDebitAmt=0.0;
		try {
		Optional<LedgerBal> ledgerBal=ledgerBalRepository.findByGlCode(debitAcc);
		if(ledgerBal.isPresent()){
			availDebitAmt=ledgerBal.get().getCurrBal();
		}
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
		return availDebitAmt;
	}

}
