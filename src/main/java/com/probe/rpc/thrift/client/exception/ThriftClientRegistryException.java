package com.probe.rpc.thrift.client.exception;

public class ThriftClientRegistryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3700479052432906677L;

	public ThriftClientRegistryException(String message) {
		super(message);
	}

	public ThriftClientRegistryException(String message, Throwable t) {
		super(message, t);
	}
}
