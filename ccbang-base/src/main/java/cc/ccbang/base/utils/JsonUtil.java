package cc.ccbang.base.utils;

import org.codehaus.jackson.map.DeserializationConfig.Feature; 
import org.codehaus.jackson.map.ObjectMapper; 
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion; 
import org.codehaus.jackson.type.TypeReference; 
import java.io.IOException; 
import java.text.SimpleDateFormat;

public class JsonUtil {

	private static ObjectMapper MAPPER;
	static {
		MAPPER = generateMapper(Inclusion.ALWAYS);
	}

	private JsonUtil() {
	}

	public static <T> T fromJson(String json, Class<T> clazz)
			throws IOException {
		return clazz.equals(String.class) ? (T) json : MAPPER.readValue(json,
				clazz);
	}

	public static <T> T fromJson(String json, TypeReference<?> typeReference)
			throws IOException {
		return (T) (typeReference.getType().equals(String.class) ? json
				: MAPPER.readValue(json, typeReference));
	}

	public static <T> String toJson(T src, ObjectMapper mapper)
			throws IOException {
		if (null != mapper) {
			if (src instanceof String) {
				return (String) src;
			} else {
				return mapper.writeValueAsString(src);
			}
		} else {
			return null;
		}
	}
	
	

	public static ObjectMapper mapper() {
		return MAPPER;
	}
	
	private static ObjectMapper generateMapper(Inclusion inclusion) { 
		ObjectMapper customMapper = new ObjectMapper();
		customMapper.setSerializationInclusion(inclusion);
		customMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		customMapper.configure(Feature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
		customMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")); 
		return customMapper;
	}
}