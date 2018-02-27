package homemadeserializer;

import java.io.IOException;

/**
 * Created by Artem Karpov
 */
public interface Serializer {

	<T> T toObject(byte[] bytes, Class<T> type) throws IOException, ClassNotFoundException;

	byte[] objectToByteArray(Object object) throws IOException;


}
