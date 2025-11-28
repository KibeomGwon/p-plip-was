package com.pplip.domain.board.notice.api.controller;

import com.pplip.domain.board.notice.api.request.NoticeRequest;
import com.pplip.domain.board.notice.api.response.NoticeResponse;
import com.pplip.global.api.response.CommonResponse;
import com.pplip.global.docs.NoticeDocsController;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController implements NoticeDocsController {

    @GetMapping
    public CommonResponse<Page<NoticeResponse.BoardList>> listNoticeBoard(@ModelAttribute PageRequest pageRequest) {
        return null;
    }

    @PostMapping
    public CommonResponse<NoticeResponse.Detail> postNoticeBoard(NoticeRequest.Post request,
                                                                 @AuthenticationPrincipal UserDetails userDetails) {
        return null;
    }

    @GetMapping("/{id}")
    public CommonResponse<NoticeResponse.Detail> findNoticeBoard(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}")
    public CommonResponse<NoticeResponse.Update> updateNoticeBoard(NoticeRequest.Update update, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public CommonResponse<NoticeResponse.Update> removeNoticeBoard(@PathVariable Long id) {
        return null;
    }
}
