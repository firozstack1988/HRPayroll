package com.firoztechi.UserApp.UserApp.Model;

import lombok.Data;

@Data
public class ResponseModel {

	private String success;
	private String errorMsg;
	private Object content;
	private String generatedSerial;
}
