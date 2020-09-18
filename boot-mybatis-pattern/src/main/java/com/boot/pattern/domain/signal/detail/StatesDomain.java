package com.boot.pattern.domain.signal.detail;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class StatesDomain {
	@Getter @Setter private String movementName;
	@Getter @Setter private int signalGroup;
	@Getter @Setter private StateTimeSpeedDomain stateTimeSpeed;
	@Getter @Setter private List<ManeuverAssistDomain> maneuverAssist;
}