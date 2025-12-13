package com.pplip.domain.trip.ai.service;

import com.pplip.domain.trip.ai.dto.request.AiRequest;
import com.pplip.domain.trip.ai.dto.response.AiResponse;
import com.pplip.global.exception.AIServerErrorException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class InferenceServiceImpl implements InferenceService {
	private final RestClient restClient;
	@Value("${inference-server.url}")
	private String url;
	@Value("${inference-server.suggest}")
	private String suggestPath;

	@Override
	public List<AiResponse.SuggestAttraction> suggestAttraction(AiRequest.SuggestAttractions request) {
		log.info("ai_request:{}", request);
		ResponseEntity<List<AiResponse.SuggestAttraction>> response = null;
		try {
			response = restClient.post().uri(url + suggestPath)
					.contentType(MediaType.APPLICATION_JSON)
					.body(request)
					.retrieve()
					.toEntity(new ParameterizedTypeReference<List<AiResponse.SuggestAttraction>>() {
					});
			log.info("ai_response:{}", response.getBody());

		}catch (HttpServerErrorException e){
			throw new AIServerErrorException();
		}
		//예외 처리 로직 추가 구현?
		return response.getBody();
	}


}
