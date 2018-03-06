package com.serialization.benchmark.test;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.serialization.benchmark.test.dto.ParamsDto;
import com.serialization.benchmark.test.dto.ProgrammingLangDTO;
import com.serialization.benchmark.test.serializer.Serializer;
import com.serialization.benchmark.test.serializer.impl.SerializerApacheImpl;
import com.serialization.benchmark.test.serializer.impl.SerializerImpl;
import com.serialization.benchmark.test.serializer.impl.SerializerToStringImpl;

/**
 * Created by Artem Karpov
 */
public class Main {

	private static ParamsDto flatDto = new ParamsDto("x","11","333");
	private static ProgrammingLangDTO graphDto = new ProgrammingLangDTO("GoLang","Typed","Rob Pike", flatDto);

	@Benchmark
	@BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.NANOSECONDS)
	public static void testSerializationHomeBrewSerializer() {
		Serializer serializer = new SerializerImpl();

		byte[] bytes = serializer.objectToByteArray(graphDto);

		ProgrammingLangDTO dto1 = serializer.toObject(bytes, ProgrammingLangDTO.class);

	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.NANOSECONDS)
	public static void testSerializationKryoSerializer() {
		Kryo kryo = new Kryo();

		byte[] object = new byte[1024];

		Output output = new Output(object);

		kryo.writeObject(output, graphDto);
		output.close();
		Input input = new Input(object);

		ProgrammingLangDTO someObject = kryo.readObject(input, ProgrammingLangDTO.class);
		input.close();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.NANOSECONDS)
	public static void testSerializationHomeBrewSerializerFlatObj() {
		Serializer serializer = new SerializerImpl();

		byte[] bytes = serializer.objectToByteArray(flatDto);

		ParamsDto dto1 = serializer.toObject(bytes, ParamsDto.class);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.NANOSECONDS)
	public static void testSerializationKryoSerializerFlatObj() {
		Kryo kryo = new Kryo();

		byte[] object = new byte[1024];

		Output output = new Output(object);

		kryo.writeObject(output, flatDto);
		output.close();
		Input input = new Input(object);

		ParamsDto someObject = kryo.readObject(input, ParamsDto.class);
		input.close();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.NANOSECONDS)
	public static void testSerializationApacheSerializer() {
		Serializer serializer = new SerializerApacheImpl();

		byte[] bytes = serializer.objectToByteArray(graphDto);

		ProgrammingLangDTO res = serializer.toObject(bytes, ProgrammingLangDTO.class);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.NANOSECONDS)
	public static void testSerializationApacheSerializerFlatObj() {
		Serializer serializer = new SerializerApacheImpl();

		byte[] bytes = serializer.objectToByteArray(flatDto);

		ParamsDto res = serializer.toObject(bytes, ParamsDto.class);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.NANOSECONDS)
	public static void testSerializationManualStringSerializerFlatObj() {
		Serializer serializer = new SerializerToStringImpl();

		byte[] bytes = serializer.objectToByteArray(flatDto);

		ParamsDto res = serializer.toObject(bytes, ParamsDto.class);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.NANOSECONDS)
	public static void testSerializationManualStringSerializerObj() {
		Serializer serializer = new SerializerToStringImpl();

		byte[] bytes = serializer.objectToByteArray(graphDto);

		ProgrammingLangDTO res = serializer.toObject(bytes, ProgrammingLangDTO.class);
	}

}
