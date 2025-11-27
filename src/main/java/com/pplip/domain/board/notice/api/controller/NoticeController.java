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
    public CommonResponse<NoticeResponse.Detail> postNoticeBoard(NoticeRequest.BoardPost request,
                                                                 @AuthenticationPrincipal UserDetails userDetails) {
        return null;
    }

    @GetMapping("/{id}")
    public CommonResponse<NoticeResponse.Detail> findNoticeBoard(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}")
    public CommonResponse<NoticeResponse.BoardUpdate> updateNoticeBoard(NoticeRequest.BoardUpdate update, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public CommonResponse<NoticeResponse.BoardRemove> removeNoticeBoard(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/{id}/comment")
    public CommonResponse<Page<NoticeResponse.CommentList>> listNoticeBoardComment(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/{id}/comment")
    public CommonResponse<NoticeResponse.CommentList> postNoticeBoardComment(
            NoticeRequest.CommentPost request,
            @PathVariable Long id,
            @AuthenticationPrincipal UserDetails userDetails) {
        return null;
    }
}
