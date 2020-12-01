package com.app.store.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UserSecurity {

	@Getter @Setter
	private String username;
	
	@Getter @Setter
	private String password;
	
	@Getter @Setter
	private List<String> roles;
	
	@Getter @Setter
	private boolean status;
	
}
