package com.boot.pattern;

import javax.annotation.PostConstruct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.boot.pattern.domain.signal.SignalMapBodyDomain;
import com.boot.pattern.domain.signal.SignalMapBodyProxyDomain;
import com.boot.pattern.service.SignalMapService;
import com.boot.pattern.util.DayTimeUtil;

import lombok.extern.slf4j.Slf4j;

// http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/

@SpringBootApplication
@MapperScan(basePackages = "com.boot.pattern.mapper")
@Slf4j
public class BootMybatisPatternApplication {
	@Autowired private SignalMapService signalMapService;
	
	@PostConstruct
	public void start() throws Exception {
		SignalMapBodyProxyDomain smbDomain = new SignalMapBodyProxyDomain();
		
		smbDomain.setCenterId("seoul-cits-" + (int)(Math.random()*10000));
		smbDomain.setCenterName("서울C-ITS");
		smbDomain.setIntersectionId((int)(Math.random()*10000));
		smbDomain.setIntersectionName("미정");
		smbDomain.setCreationDate(DayTimeUtil.getCurDateTime("yyyyMMddHHmmss"));
		smbDomain.setModifyDate(null);
		smbDomain.setPushInfo(null);
		smbDomain.setRefPoint(null);
		smbDomain.setLaneSet("[\n" + 
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
				"            }");
		
		signalMapService.insertMapInfoCandidate(smbDomain);
		
		//SignalMapBodyProxyDomain smbResultDomain = signalMapService.selectMapInfoCandidate(smbDomain);
		
		//log.info("smbResultDomain : {}", smbResultDomain);
	}
	
    public static void main(String[] args) {
        SpringApplication.run(BootMybatisPatternApplication.class, args);
    }

}
