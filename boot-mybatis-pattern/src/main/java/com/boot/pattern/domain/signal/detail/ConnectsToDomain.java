package com.boot.pattern.domain.signal.detail;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ConnectsToDomain {
	private int laneId;
	private String maneuvers;
	private int signalGroupId;
}