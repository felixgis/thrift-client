package com.probe.rpc.thrift.client.exception;

public class ThriftClientConfigException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8202900148766146798L;

	public ThriftClientConfigException(String message) {
		super(message);
	}

	public ThriftClientConfigException(String message, Throwable cause) {
		super(message, cause);
	}

}
