package com.edu.interceptor;

import com.edu.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{
	private User user;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String intercept(ActionInvocation ai) throws Exception {
		if(user==null){
			System.out.println("login");
			return Action.LOGIN;
		}
		else {
			System.out.println("next");
			return ai.invoke();
		}
		
		
	}
	

	
}
