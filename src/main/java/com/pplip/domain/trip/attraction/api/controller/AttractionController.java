package com.pplip.domain.trip.attraction.api.controller;

import com.pplip.domain.trip.attraction.api.response.AttractionResponse;
import com.pplip.global.api.code.SuccessCode;
import com.pplip.global.api.response.CommonResponse;
import com.pplip.global.docs.AttractionDocsController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 여행지 관련 API 요청을 처리하는 컨트롤러
 */
@RestController
@RequestMapping("/trip/attractions")
public class AttractionController implements AttractionDocsController {

    /**
     * 행정구역 정보를 조회합니다.
     *
     * @return 행정구역 정보 목록
     */
    @GetMapping("/region")
    @Override
    public CommonResponse<List<AttractionResponse.Region>> getAdministrativeDistrict() {
        return CommonResponse.success(SuccessCode.SUCCESS, null);
    }

}
