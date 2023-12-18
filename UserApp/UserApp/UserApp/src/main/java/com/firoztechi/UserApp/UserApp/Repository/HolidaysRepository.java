package com.firoztechi.UserApp.UserApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.firoztechi.UserApp.UserApp.Entity.Employee;
import com.firoztechi.UserApp.UserApp.Entity.Holidays;
import com.firoztechi.UserApp.UserApp.Model.UserDto;

@Repository
public interface HolidaysRepository extends JpaRepository<Holidays,Long>{

	public Holidays getHolidaysByMonth(@Param("month") String month);
}
