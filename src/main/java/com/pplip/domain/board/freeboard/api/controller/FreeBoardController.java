package com.pplip.domain.board.freeboard.api.controller;

import com.pplip.domain.board.freeboard.api.request.FreeBoardRequest;
import com.pplip.domain.board.freeboard.api.response.FreeBoardResponse;
import com.pplip.global.api.code.SuccessCode;
import com.pplip.global.api.response.CommonResponse;
import com.pplip.global.docs.FreeBoardDocsController;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;
import lombok.RequiredArgsConstructor;
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
    public CommonResponse<FreeBoardResponse.Detail> getFreeBoardDetail(@PathVariable Long id) {
        return null;
    }

    @Override
    public CommonResponse<FreeBoardResponse.Detail> getFreeBoardDetail(FreeBoardRequest.BoardPost request, UserDetails principal) {
        return null;
    }

    @Override
    public CommonResponse<FreeBoardResponse.Update> postFreeBoardUpdate(FreeBoardRequest.BoardUpdate update, Long id, UserDetails principal) {
        return null;
    }

    @Override
    public CommonResponse<FreeBoardResponse.Remove> postBoardUpdate(Long id, UserDetails principal) {
        return null;
    }
}
