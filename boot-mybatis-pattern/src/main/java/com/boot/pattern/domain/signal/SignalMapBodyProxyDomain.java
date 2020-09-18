package com.boot.pattern.domain.signal;

import java.util.List;

import com.boot.pattern.domain.signal.detail.LaneSetDomain;
import com.boot.pattern.domain.signal.detail.PositionDomain;
import com.boot.pattern.domain.signal.detail.SignalMapPushInfoDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class SignalMapBodyProxyDomain {
	@Getter @Setter private String centerId;
	@Getter @Setter private String centerName;
	@Getter @Setter private int intersectionId;
	@Getter @Setter private String intersectionName;
	
	@Getter @Setter private String creationDate;
	@Getter @Setter private String modifyDate;
	
	@Getter @Setter private String pushInfo;
	@Getter @Setter private String refPoint;
	@Getter @Setter private String laneSet;
}