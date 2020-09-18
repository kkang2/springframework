package com.boot.pattern.domain.signal.detail;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class SignalMapPushInfoDomain {
	@Getter @Setter private int signalGroupId;
	
	@Getter @Setter private String targetMeshId;
	@Getter @Setter private String targetLinkId;
	@Getter @Setter private String targetNodeId;
	@Getter @Setter private String direction; // 0(정방), 1(역방)
	
	@Getter @Setter private List<SignalMapPushRoadInfo> roadInfoList;
}