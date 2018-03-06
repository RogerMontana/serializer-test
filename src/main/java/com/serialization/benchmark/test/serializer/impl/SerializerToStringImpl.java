package com.serialization.benchmark.test.serializer.impl;

import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.serialization.benchmark.test.serializer.Serializer;
import com.serialization.benchmark.test.serializer.exceptions.SerializerException;

/**
 * Created by Artem Karpov
 */
public class SerializerToStringImpl implements Serializer {
	private static final String encoding = "UTF8";
	private Gson gson = new Gson();

	@Override
	public <T> T toObject(byte[] bytes, Class<T> type) {
		String string = null;
		try {
			string = new String(bytes, encoding);
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return (T) gson.fromJson(string, type);
	}

	@Override
	public byte[] objectToByteArray(Object object) {
		return serialize(gson.toJson(object));
	}



	public byte[] serialize(String data) {
		try {
			if (data == null)
				return null;
			else
				return data.getBytes(encoding);
		} catch (UnsupportedEncodingException e) {
			throw new SerializerException("Error when serializing string reason - unsupported encoding " + encoding);
		}
	}

	public String deserialize(byte[] data) {
		try {
			if (data == null)
				return null;
			else
				return new String(data, encoding);
		} catch (UnsupportedEncodingException e) {
			throw new SerializerException("Error when deserializing reason -  unsupported encoding " + encoding);
		}
	}
}
