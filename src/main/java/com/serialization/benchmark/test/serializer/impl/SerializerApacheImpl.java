package com.serialization.benchmark.test.serializer.impl;

import java.io.Serializable;

import org.apache.commons.lang.SerializationUtils;

import com.serialization.benchmark.test.serializer.Serializer;

/**
 * Created by Artem Karpov
 */
public class SerializerApacheImpl implements Serializer {

	@Override
	public <T> T toObject(byte[] bytes, Class<T> type) {
		return (T) SerializationUtils.deserialize(bytes);
	}

	@Override
	public byte[] objectToByteArray(Object object) {
		return SerializationUtils.serialize((Serializable) object);
	}
}
