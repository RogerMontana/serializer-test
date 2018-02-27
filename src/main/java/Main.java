import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

import homemadeserializer.Serializer;
import homemadeserializer.SerializerImpl;

/**
 * Created by Artem Karpov
 */
public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Serializer serializer = new SerializerImpl();

		byte[] f = serializer.objectToByteArray(BigDecimal.ZERO);

		System.out.println(Arrays.toString(f));

		BigDecimal bigDecimal = serializer.toObject(f, BigDecimal.class);

		System.out.println(bigDecimal.toString());

	}
}
