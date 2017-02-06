package astarta.db.converter;

import java.io.IOException;
import javax.persistence.AttributeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import astarta.db.exception.JsonParsingRuntimeException;
import astarta.web.controller.ReportExceptionHandler;

public class JpaConverterJson implements AttributeConverter<JsonNode, String>{
	private static final Logger logger = LoggerFactory.getLogger(ReportExceptionHandler.class);
	
	@Override
	public String convertToDatabaseColumn(JsonNode meta) {
		return meta.toString();
	}

	@Override
	public JsonNode convertToEntityAttribute(String dbData){

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		try {
			node = mapper.readValue(dbData, JsonNode.class);
		} catch (IOException ex) {
			logger.error("Error parsing/mapping json from DB. " + ex.toString());
			throw new JsonParsingRuntimeException("exception.payslip.jsonparsing",ex);
		}
		return node;
	}

}
