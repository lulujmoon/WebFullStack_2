package com.redbeet.s1.util;

public class ActionForward {
	
	private String path;
	private boolean check;	//check가 true면 forward, false면 redirect
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	

}
