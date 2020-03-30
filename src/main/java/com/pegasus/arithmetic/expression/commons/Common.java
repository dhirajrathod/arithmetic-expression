package com.pegasus.arithmetic.expression.commons;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Common {
	
    private static final Logger LOGGER = Logs.getAppLoggers();

	public static Object jsonToObject(String jsonString, String className) {
		Object object = null;
		try {
			if (StringUtils.isNotEmpty(jsonString) && StringUtils.isNotEmpty(className)) {
				ObjectMapper mapper = new ObjectMapper();
				object = mapper.readValue(jsonString, Class.forName(className));
			}
		} catch (Exception e) {
			LOGGER.error("Exception occurred in jsonToObject in Common : " + e.getMessage());
		}
		return object;
	}

	public static String objectToJSON(Object object) {
		String jsonString = StringUtils.EMPTY;
		try {
			if (object != null) {
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
				jsonString = mapper.writeValueAsString(object);
			}
		} catch (Exception e) {
			LOGGER.error("Exception occurred in objectToJSON in Common : " + e.getMessage());
		}
		return jsonString;
	}

}
