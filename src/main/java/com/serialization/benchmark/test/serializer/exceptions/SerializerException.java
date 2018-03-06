package com.serialization.benchmark.test.serializer.exceptions;

/**
 * Created by Artem Karpov
 */
public class SerializerException extends RuntimeException {
	public SerializerException() {
		super();
	}

	public SerializerException(String s) {
		super(s);
	}

	public SerializerException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public SerializerException(Throwable throwable) {
		super(throwable);
	}
}