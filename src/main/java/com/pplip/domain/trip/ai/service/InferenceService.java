package com.pplip.domain.trip.ai.service;

import com.pplip.domain.trip.ai.dto.request.AiRequest;
import com.pplip.domain.trip.ai.dto.response.AiResponse;

import java.util.List;

public interface InferenceService {
	List<AiResponse.SuggestAttraction> suggestAttraction(AiRequest.SuggestAttractions request);
}
