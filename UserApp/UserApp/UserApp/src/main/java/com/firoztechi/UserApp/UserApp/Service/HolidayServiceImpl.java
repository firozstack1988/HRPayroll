package com.firoztechi.UserApp.UserApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firoztechi.UserApp.UserApp.Entity.Holidays;
import com.firoztechi.UserApp.UserApp.Repository.HolidaysRepository;

@Service
public class HolidayServiceImpl implements HolidayService{

	@Autowired
	private HolidaysRepository holidaysRepository;
	@Override
	public void add(Holidays holidays) throws Exception {
		try {
			holidaysRepository.save(holidays);
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	}

}
