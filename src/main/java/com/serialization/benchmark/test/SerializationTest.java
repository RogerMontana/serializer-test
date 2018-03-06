package com.serialization.benchmark.test;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.profile.HotspotMemoryProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.serialization.benchmark.test.dto.ParamsDto;
import com.serialization.benchmark.test.dto.ProgrammingLangDTO;
import com.serialization.benchmark.test.serializer.Serializer;
import com.serialization.benchmark.test.serializer.impl.SerializerApacheImpl;
import com.serialization.benchmark.test.serializer.impl.SerializerGsonToBytesImpl;
import com.serialization.benchmark.test.serializer.impl.SerializerImpl;

/**
 * Created by Artem Karpov
 */
public class SerializationTest {
	private static ParamsDto flatDto = new ParamsDto("x","11","333");
	private static ProgrammingLangDTO graphDto = new ProgrammingLangDTO("GoLang","Typed","Rob Pike", flatDto);


	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(".*" + SerializationTest.class.getSimpleName() + ".*")
				.warmupIterations(10)
				.addProfiler(HotspotMemoryProfiler.class)
				.measurementIterations(10)
				.forks(1)
				.build();

		new Runner(opt).run();
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.NANOSECONDS)
	public static void JavaSerializer() {
		Serializer serializer = new SerializerImpl();

		byte[] bytes = serializer.objectToByteArray(graphDto);

		ProgrammingLangDTO dto1 = serializer.toObject(bytes, ProgrammingLangDTO.class);

	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.NANOSECONDS)
	public static void KryoSerializerObj() {
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
	public static void JavaSerializerFlatObj() {
		Serializer serializer = new SerializerImpl();

		byte[] bytes = serializer.objectToByteArray(flatDto);

		ParamsDto dto1 = serializer.toObject(bytes, ParamsDto.class);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.NANOSECONDS)
	public static void KryoSerializerFlatObj() {
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
	public static void ApacheSerializerObj() {
		Serializer serializer = new SerializerApacheImpl();

		byte[] bytes = serializer.objectToByteArray(graphDto);

		ProgrammingLangDTO res = serializer.toObject(bytes, ProgrammingLangDTO.class);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.NANOSECONDS)
	public static void ApacheSerializerFlatObj() {
		Serializer serializer = new SerializerApacheImpl();

		byte[] bytes = serializer.objectToByteArray(flatDto);

		ParamsDto res = serializer.toObject(bytes, ParamsDto.class);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.NANOSECONDS)
	public static void GsonToBytesSerializerFlatObj() {
		Serializer serializer = new SerializerGsonToBytesImpl();

		byte[] bytes = serializer.objectToByteArray(flatDto);

		ParamsDto res = serializer.toObject(bytes, ParamsDto.class);
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.NANOSECONDS)
	public static void GsonToBytesSerializerObj() {
		Serializer serializer = new SerializerGsonToBytesImpl();

		byte[] bytes = serializer.objectToByteArray(graphDto);

		ProgrammingLangDTO res = serializer.toObject(bytes, ProgrammingLangDTO.class);
	}

}
