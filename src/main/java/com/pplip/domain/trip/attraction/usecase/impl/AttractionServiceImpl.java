package com.pplip.domain.trip.attraction.usecase.impl;

import com.pplip.domain.trip.ai.dto.request.AiRequest;
import com.pplip.domain.trip.ai.dto.response.AiResponse;
import com.pplip.domain.trip.ai.service.InferenceService;
import com.pplip.domain.trip.attraction.api.request.AttractionRequest;
import com.pplip.domain.trip.attraction.api.response.AttractionResponse;
import com.pplip.domain.trip.attraction.persistence.dao.AttractionDao;
import com.pplip.domain.trip.attraction.persistence.dao.TagDao;
import com.pplip.domain.trip.attraction.persistence.entity.ContentType;
import com.pplip.domain.trip.attraction.usecase.AttractionService;
import com.pplip.global.api.code.ErrorCode;
import com.pplip.global.exception.BusinessLogicException;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttractionServiceImpl implements AttractionService {

	private final AttractionDao attractionDao;
	private final TagDao tagDao;
	private final InferenceService inferenceService;

	@Override
	public Page<AttractionResponse.Summary> findAllBySearch(AttractionRequest.Search search, PageRequest pageRequest) {
		List<AttractionResponse.Summary> resData = attractionDao.findAllBySearch(search).stream().map(data -> {
			data.setContentType(ContentType.getContentType(data.getContentTypeId().intValue()));
			return data;
		}).toList();

		return new Page<>(resData, pageRequest.getPageNum(), pageRequest.getPageSize(), attractionDao.countAllBySearch(search));
	}

	@Override
	public List<AiResponse.SuggestAttraction> suggestAttractions(AttractionRequest.Suggest suggest) {
		return inferenceService.suggestAttraction(AiRequest.SuggestAttractions.builder()
				.lat(suggest.getLat())
				.lng(suggest.getLng())
				.query(suggest.getQuery())
				.range(suggest.getM())
				.k(5)
				.build());
	}

	@Override
	public AttractionResponse.Details findByNo(Long no) {
		AttractionResponse.Details resData = attractionDao.findByNo(no)
				.orElseThrow(() -> new BusinessLogicException(ErrorCode.ATTRACTION_NOT_FOUND, "장소의 정보가 존재하지 않습니다."));

		resData.setTagNames(tagDao.findAllByAttractionNo(no).stream().map(tag -> tag.getName()).toList());
		resData.setContentType(ContentType.getContentType(resData.getContentTypeId().intValue()));

		return resData;
	}
}
