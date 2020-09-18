package com.boot.pattern.domain.signal.detail;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SignalMapNodeDomain {
	@Getter @Setter private int offsetX;
	@Getter @Setter private int offsetY;
}