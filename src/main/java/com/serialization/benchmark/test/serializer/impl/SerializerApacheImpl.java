package com.serialization.benchmark.test.serializer.impl;

import java.io.IOException;
import java.io.Serializable;
import java.util.zip.DataFormatException;

import org.apache.commons.lang.SerializationUtils;

import com.serialization.benchmark.test.serializer.Serializer;

/**
 * Created by Artem Karpov
 */
public class SerializerApacheImpl implements Serializer {

	@Override
	public <T> T toObject(byte[] bytes, Class<T> type) throws IOException, ClassNotFoundException, DataFormatException {
		return (T) SerializationUtils.deserialize(bytes);
	}

	@Override
	public byte[] objectToByteArray(Object object) throws IOException {
		return SerializationUtils.serialize((Serializable) object);
	}
}
