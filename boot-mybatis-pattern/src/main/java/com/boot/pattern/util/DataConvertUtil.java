package com.boot.pattern.util;

import java.util.List;
import java.util.Optional;

import com.boot.pattern.domain.signal.detail.LaneSetDomain;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataConvertUtil {
	public static Object convertStringToObj(ObjectMapper om, Optional<String> content, Class<?> convertClass) {
		Object result = null;
		
		try {
			if(content.isPresent()) {
				result = om.readValue(content.get(), convertClass);
			}
		} catch(Exception e) {
			log.error("content : {}, exception : {}", content, e);
		}
		
		return result;
	}
	
	public static Object convertStringToObj(ObjectMapper om, Optional<String> content, TypeReference typeRef) {
		Object result = null;
		
		try {
			if(content.isPresent()) {
				result = om.readValue(content.get(), typeRef);
			}
		} catch(Exception e) {
			log.error("content : {}, exception : {}", content, e);
		}
		
		return result;
	}
	
	public static String convertObjToPrettyString(ObjectMapper om, Object param) {
		String content = "";
		
		try {
			content = om.writerWithDefaultPrettyPrinter().writeValueAsString(param);
			//content = om.writeValueAsString(param);
		} catch(Exception e) {
			log.error("convertObjToString error!!!", content, e);
			content = om.toString();
		}
		
		return content;
	}
	
	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();
		
		String param = "[\n" + 
				"            {\n" + 
				"               \"laneId\":1,\n" + 
				"               \"directionalUse\":\"0\",\n" + 
				"               \"maneuvers\":\"maneuverStraightAllowed\",\n" + 
				"               \"nodeList\":[\n" + 
				"                  {\n" + 
				"                     \"offsetX\":-938,\n" + 
				"                     \"offsetY\":63\n" + 
				"                  },\n" + 
				"                  {\n" + 
				"                     \"offsetX\":-383,\n" + 
				"                     \"offsetY\":-322\n" + 
				"                  },\n" + 
				"                  {\n" + 
				"                     \"offsetX\":-383,\n" + 
				"                     \"offsetY\":-322\n" + 
				"                  }\n" + 
				"               ],\n" + 
				"               \"connectsTo\":[\n" + 
				"                  {\n" + 
				"                     \"laneId\":24,\n" + 
				"                     \"maneuvers\":\"maneuverStraightAllowed\",\n" + 
				"                     \"signalGroupId\":50\n" + 
				"                  }\n" + 
				"               ]\n" + 
				"            },\n" + 
				"            {\n" + 
				"               \"laneId\":2,\n" + 
				"               \"directionalUse\":\"0\",\n" + 
				"               \"maneuvers\":\"maneuverStraightAllowed\",\n" + 
				"               \"nodeList\":[\n" + 
				"                  {\n" + 
				"                     \"offsetX\":-739,\n" + 
				"                     \"offsetY\":-176\n" + 
				"                  },\n" + 
				"                  {\n" + 
				"                     \"offsetX\":-383,\n" + 
				"                     \"offsetY\":-322\n" + 
				"                  },\n" + 
				"                  {\n" + 
				"                     \"offsetX\":-382,\n" + 
				"                     \"offsetY\":-322\n" + 
				"                  }\n" + 
				"               ],\n" + 
				"               \"connectsTo\":[\n" + 
				"                  {\n" + 
				"                     \"laneId\":23,\n" + 
				"                     \"maneuvers\":\"maneuverStraightAllowed\",\n" + 
				"                     \"signalGroupId\":50\n" + 
				"                  }\n" + 
				"               ]\n" + 
				"            }]";
		
		List<LaneSetDomain> list = (List<LaneSetDomain>)convertStringToObj(objectMapper, Optional.of(param), new TypeReference<List<LaneSetDomain>>(){});
		
		System.out.println(list);
	}
}
