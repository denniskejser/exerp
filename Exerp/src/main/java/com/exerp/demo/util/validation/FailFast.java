package com.exerp.demo.util.validation;

/** 
 * 
 * Use FailFast to make the code fail as quickly as possible, if you a developer know something is wrong it eg. wrong input parameters 
 * 
 * Only to be used for system validations - not business validations, that must be on a form where i18n is possible
 * 
 * */
public class FailFast {

	/** Will cause a RuntimeException if input is null */
	public static void notNull(Object in, String message){
		if (in == null)
			throw new RuntimeException(message);
	}

}
