package astarta.web.config.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

public class JsonMapper extends ObjectMapper {
	private static final long serialVersionUID = 1L;
	public SimpleBeanPropertyFilter _simpleBeanPropertyFilter;

	public JsonMapper() {
		this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
	}

}