package com.pplip.domain.trip.ai.dto.request;

import lombok.*;

import java.math.BigDecimal;

public class AiRequest {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class SuggestAttractions{
		private String query;
		@Builder.Default
		private int range = 1000;
		private BigDecimal lat;
		private BigDecimal lng;
		@Builder.Default
		private int k = 5;
	}
}
