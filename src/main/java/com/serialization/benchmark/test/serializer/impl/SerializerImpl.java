package com.serialization.benchmark.test.serializer.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.atomic.AtomicReference;

import com.serialization.benchmark.test.serializer.Serializer;

/**
 * Created by Artem Karpov
 */
public class SerializerImpl implements Serializer {

	public byte[] objectToByteArray(Object object) throws IOException {
		byte[] bytes;
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			oos.writeObject(object);
			oos.flush();
			bytes = bos.toByteArray();
		}
		return bytes;
	}

	public <T> T toObject(byte[] bytes, Class<T> type) throws IOException, ClassNotFoundException {
		Object obj;
		AtomicReference<T> typed = new AtomicReference<>();
		try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes); ObjectInputStream ois = new ObjectInputStream(bis)) {
			obj = ois.readObject();
		}
		typed.set(type.cast(obj));
		return typed.get();
	}

}
