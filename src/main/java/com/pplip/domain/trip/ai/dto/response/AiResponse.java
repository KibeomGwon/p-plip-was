package com.pplip.domain.trip.ai.dto.response;

import com.pplip.domain.trip.attraction.persistence.entity.ContentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AiResponse {

	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class SuggestAttraction {
		private Long no;
		private String title;
		private String overview;
		private BigDecimal latitude;
		private BigDecimal longitude;
		private ContentType contentType;
		private String address;
		private String bigImage;
		private String thumbnail;
		private String homepage;
		@Builder.Default
		private List<String> tags = new ArrayList<>();
	}
}
