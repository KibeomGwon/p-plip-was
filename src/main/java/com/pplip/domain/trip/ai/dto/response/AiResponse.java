package com.pplip.domain.trip.ai.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pplip.domain.trip.attraction.persistence.entity.ContentType;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AiResponse {

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	public static class SuggestAttraction {
		private Long no;
		private String title;
		private BigDecimal latitude;
		private BigDecimal longitude;
		@JsonProperty("content_type")
		private ContentType contentType;
		private String address;
		@JsonProperty("big_image")
		private String bigImage;
		private String thumbnail;
		private String homepage;
		@Builder.Default
		private List<String> tags = new ArrayList<>();
	}
}
