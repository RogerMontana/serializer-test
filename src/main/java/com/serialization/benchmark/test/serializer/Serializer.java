package com.serialization.benchmark.test.serializer;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * Created by Artem Karpov
 */
public interface Serializer {

	<T> T toObject(byte[] bytes, Class<T> type) throws IOException, ClassNotFoundException;

	byte[] objectToByteArray(Object object) throws IOException;

}
