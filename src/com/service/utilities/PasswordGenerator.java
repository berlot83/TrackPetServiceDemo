package com.service.utilities;

import java.time.Instant;
import java.util.Date;

/* Password Generator, takes the Date at the moment of create QR with new Date() and convert to Instant and the takes seconds */
public class PasswordGenerator {
	
	public static String genPass(Date today) {	
		Instant instant = today.toInstant();
		String strInstant = String.valueOf(instant.getEpochSecond()).toString();
		return strInstant;
	}
	
	public static void main(String[] args) {
		PasswordGenerator.genPass(new Date());
	}
}
