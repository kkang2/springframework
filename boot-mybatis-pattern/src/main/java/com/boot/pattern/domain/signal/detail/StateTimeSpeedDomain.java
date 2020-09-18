package com.boot.pattern.domain.signal.detail;

import lombok.Getter;
import lombok.Setter;

public class StateTimeSpeedDomain {
	@Getter @Setter private int eventState;
	@Getter @Setter private int minEndTime;
}