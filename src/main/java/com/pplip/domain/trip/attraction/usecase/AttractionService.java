package com.pplip.domain.trip.attraction.usecase;

import com.pplip.domain.trip.ai.dto.response.AiResponse;
import com.pplip.domain.trip.attraction.api.request.AttractionRequest;
import com.pplip.domain.trip.attraction.api.response.AttractionResponse;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;

import java.util.List;

public interface AttractionService {
    Page<AttractionResponse.Summary> findAllBySearch(AttractionRequest.Search search, PageRequest pageRequest);

    List<AiResponse.SuggestAttraction> suggestAttractions(AttractionRequest.Suggest suggest);

    AttractionResponse.Details findByNo(Long no);


}
