package com.probe.rpc.thrift.client.exception;

public class ThriftClientException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4181208873464756358L;

	public ThriftClientException(String message) {
		super(message);
	}

	public ThriftClientException(String message, Throwable t) {
		super(message, t);
	}
}
