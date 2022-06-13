package com.backend.rentcar.projection;

import java.util.Set;

public interface ProjectUser {
	
	Long getId();
	
	String getFirstName();
	
	String getLastName();
	
	String getPhoneNumber();
	
	String getEmail();
	
	String getAddress();
	
	String getZipCode();
	
	Set<String> getRoles();
	
	Boolean getBuiltIn();
	

}
