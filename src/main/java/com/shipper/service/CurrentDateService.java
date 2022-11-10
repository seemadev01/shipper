package com.shipper.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import com.shipper.common.utils.Logger;

@Service
public class CurrentDateService {

	private Logger log = Logger.getLogger(getClass());
	
	public String getCurrentDate() {
		log.info("inside CurrentDateService of getCurrentDate method");
		DateTimeFormatter formatter = 
		        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm.SSz");
		LocalDateTime date =LocalDateTime.parse(new DateTime().toString(), formatter);
		return date.toString();
	}

}
