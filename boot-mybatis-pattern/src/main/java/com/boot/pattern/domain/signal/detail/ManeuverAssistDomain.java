package com.boot.pattern.domain.signal.detail;

import lombok.Getter;
import lombok.Setter;

public class ManeuverAssistDomain {
	@Getter @Setter private int connectionId;
	@Getter @Setter private String pedBicycleDetect;
}