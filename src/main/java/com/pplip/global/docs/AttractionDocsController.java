package com.pplip.global.docs;

import com.pplip.domain.trip.attraction.api.response.AttractionResponse;
import com.pplip.global.api.response.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

/**
 * 여행지 관련 API 명세를 정의하는 인터페이스
 */
@Tag(name = "여행지 API", description = "여행지 api")
public interface AttractionDocsController {

    /**
     * 행정구역 정보를 조회합니다.
     *
     * @return 행정구역 정보 목록
     */
    @Operation(summary = "행정구역 정보 조회")
    @ApiResponse(responseCode = "200", description = "성공")
    CommonResponse<List<AttractionResponse.Region>> getAdministrativeDistrict();
}
