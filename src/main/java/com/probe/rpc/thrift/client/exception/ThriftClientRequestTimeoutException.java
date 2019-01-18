package com.probe.rpc.thrift.client.exception;

public class ThriftClientRequestTimeoutException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5421731799835098184L;

	public ThriftClientRequestTimeoutException(String message) {
		super(message);
	}

	public ThriftClientRequestTimeoutException(String message, Throwable cause) {
		super(message, cause);
	}
}
