package com.probe.rpc.thrift.client.exception;

public class ThriftClientInstantiateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 134166710727164824L;

	public ThriftClientInstantiateException(String message) {
		super(message);
	}

	public ThriftClientInstantiateException(String message, Throwable cause) {
		super(message, cause);
	}
}
