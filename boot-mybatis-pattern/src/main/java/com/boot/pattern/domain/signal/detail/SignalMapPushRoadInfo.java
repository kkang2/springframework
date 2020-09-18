package com.boot.pattern.domain.signal.detail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignalMapPushRoadInfo {
	@Getter @Setter private String mld16;
	@Getter @Setter private int length;
	@Getter @Setter private String meshId;
	@Getter @Setter private String linkId;
	@Getter @Setter private String direction;
	@Getter @Setter private int evPfl;
}
