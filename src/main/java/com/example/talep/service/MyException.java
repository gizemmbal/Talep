package com.example.talep.service;

@SuppressWarnings("serial")
public class MyException extends RuntimeException {

	public MyException() {
		super();
	}

	public MyException(String message) {
		super(message);
	}
}
