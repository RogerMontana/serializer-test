package com.serialization.benchmark.test.serializer;

/**
 * Created by Artem Karpov
 */
public interface Serializer {

	<T> T toObject(byte[] bytes, Class<T> type);

	byte[] objectToByteArray(Object object);

}
