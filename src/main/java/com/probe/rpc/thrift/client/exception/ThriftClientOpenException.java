package com.probe.rpc.thrift.client.exception;

public class ThriftClientOpenException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5244687771499420668L;

	public ThriftClientOpenException(String message) {
		super(message);
	}

	public ThriftClientOpenException(String message, Throwable cause) {
		super(message, cause);
	}

}
