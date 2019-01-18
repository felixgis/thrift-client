package com.probe.rpc.thrift.client.exception;

public class ThriftApplicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5659501988233659367L;

	public ThriftApplicationException(String message) {
		super(message);
	}

	public ThriftApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
}
