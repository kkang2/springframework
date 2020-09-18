package com.boot.pattern.domain.signal.detail;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class LaneSetDomain {
	@Getter @Setter private int laneId;
	@Getter @Setter private String directionalUse;
	@Getter @Setter private String maneuvers;
	@Getter @Setter private List<SignalMapNodeDomain> nodeList;
	@Getter @Setter private List<ConnectsToDomain> connectsTo;
}