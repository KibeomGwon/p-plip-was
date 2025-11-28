package com.pplip.domain.trip.attraction.api.controller;

import com.pplip.domain.trip.attraction.api.response.AttractionResponse;
import com.pplip.global.api.code.SuccessCode;
import com.pplip.global.api.response.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trip/attractions")
public class AttractionController {

    @GetMapping("/region")
    public CommonResponse<List<AttractionResponse.Region>> getAdministrativeDistrict() {
        return CommonResponse.success(SuccessCode.SUCCESS, null);
    }

}
