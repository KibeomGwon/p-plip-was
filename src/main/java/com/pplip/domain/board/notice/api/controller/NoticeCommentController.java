package com.pplip.domain.board.notice.api.controller;

import com.pplip.domain.board.notice.api.request.NoticeCommentRequest;
import com.pplip.domain.board.notice.api.request.NoticeRequest;
import com.pplip.domain.board.notice.api.response.NoticeResponse;
import com.pplip.global.api.response.CommonResponse;
import com.pplip.global.docs.NoticeCommentDocsController;
import com.pplip.global.page.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice/{id}/comment")
public class NoticeCommentController implements NoticeCommentDocsController {
    @GetMapping
    public CommonResponse<Page<NoticeResponse.CommentList>> listNoticeBoardComment(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public CommonResponse<NoticeResponse.CommentList> postNoticeBoardComment(
            NoticeCommentRequest.Post request,
            @PathVariable Long id,
            @AuthenticationPrincipal UserDetails userDetails) {
        return null;
    }

}
