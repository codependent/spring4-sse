package com.codependent.spring4.sse.dto;

import java.io.Serializable;

public class Alert implements Serializable{

	private static final long serialVersionUID = -1838463717230679389L;

	private Long alertId;
	
	private String message;

	public Alert(){}
	
	public Alert(Long alertId, String message) {
		super();
		this.alertId = alertId;
		this.message = message;
	}
	
	public Long getAlertId() {
		return alertId;
	}

	public void setAlertId(Long alertId) {
		this.alertId = alertId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Alert [alertId=" + alertId + ", message=" + message + "]";
	}
	
}
