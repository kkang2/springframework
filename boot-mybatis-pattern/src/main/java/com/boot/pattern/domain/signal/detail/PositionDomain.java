package com.boot.pattern.domain.signal.detail;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class PositionDomain {
	@Getter @Setter private double latitude;
	@Getter @Setter private double longitude;
	@Getter @Setter private int elevation;
}