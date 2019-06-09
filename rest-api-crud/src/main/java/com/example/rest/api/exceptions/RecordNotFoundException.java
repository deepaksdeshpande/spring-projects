/**
 * 
 */
package com.example.rest.api.exceptions;

/**
 * @author deepak
 *
 */
public class RecordNotFoundException extends Exception {

	private String exceptionMsg;
	
	public RecordNotFoundException(String exceptionMsg) {
		// TODO Auto-generated constructor stub
		this.setExceptionMsg(exceptionMsg);
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4137651647769482315L;

}
