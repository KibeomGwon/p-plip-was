package com.pplip.domain.board.freeboard.api.controller;

import com.pplip.domain.board.freeboard.api.request.FreeBoardRequest;
import com.pplip.domain.board.freeboard.api.response.FreeBoardResponse;
import com.pplip.global.api.code.SuccessCode;
import com.pplip.global.api.response.CommonResponse;
import com.pplip.global.docs.FreeBoardDocsController;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/free-board")
@RequiredArgsConstructor
public class FreeBoardController implements FreeBoardDocsController {

    @Override
    @GetMapping
    public CommonResponse<Page<FreeBoardResponse.BoardList>> retrieveFreeBoard(@ModelAttribute PageRequest pageRequest) {
        return CommonResponse.success(SuccessCode.SUCCESS, null);
    }

    @Override
    @GetMapping("/{id}")
    public CommonResponse<FreeBoardResponse.Detail> postFreeBoardDetail(@PathVariable Long id) {
        return CommonResponse.success(SuccessCode.SUCCESS, null);
    }

    @Override
    @PostMapping
    public CommonResponse<FreeBoardResponse.Detail> postFreeBoardDetail(
            @RequestBody
            FreeBoardRequest.BoardPost request,
            @AuthenticationPrincipal
            UserDetails principal) {
        return CommonResponse.success(SuccessCode.SUCCESS, null);
    }

    @Override
    @PutMapping("/{id}")
    public CommonResponse<FreeBoardResponse.Update> updateFreeBoardUpdate(
            @RequestBody
            FreeBoardRequest.BoardUpdate update,
            @PathVariable
            Long id,
            @AuthenticationPrincipal
            UserDetails principal) {
        return CommonResponse.success(SuccessCode.SUCCESS, null);
    }

    @Override
    @DeleteMapping("/{id}")
    public CommonResponse<FreeBoardResponse.Remove> removeFreeBoard(
            @PathVariable
            Long id,
            @AuthenticationPrincipal
            UserDetails principal) {
        return CommonResponse.success(SuccessCode.SUCCESS, null);
    }
}
