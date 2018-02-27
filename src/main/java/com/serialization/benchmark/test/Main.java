package com.serialization.benchmark.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.serialization.benchmark.test.dto.ProgrammingLangDTO;
import com.serialization.benchmark.test.serializer.Serializer;
import com.serialization.benchmark.test.serializer.impl.SerializerImpl;

/**
 * Created by Artem Karpov
 */
public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Serializer serializer = new SerializerImpl();

		ProgrammingLangDTO goLangDto = new ProgrammingLangDTO("GoLang","Typed","Rob Pike");
		ProgrammingLangDTO pythonDto = new ProgrammingLangDTO("Python","DuckTyping","Van Rossum");

		List<ProgrammingLangDTO> dtoList = Arrays.asList(goLangDto, pythonDto);

		byte[] bytes = serializer.objectToByteArray(dtoList);

		System.out.println(Arrays.toString(bytes));

		List<ProgrammingLangDTO> dto1 = serializer.toObject(bytes, List.class);

		System.out.println(dto1.toString());

	}
}
