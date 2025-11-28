package com.pplip.domain.board.notice.api.controller;

import com.pplip.domain.board.notice.api.request.NoticeCommentRequest;
import com.pplip.domain.board.notice.api.response.NoticeCommentResponse;
import com.pplip.global.api.response.CommonResponse;
import com.pplip.global.docs.NoticeCommentDocsController;
import com.pplip.global.page.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeCommentController implements NoticeCommentDocsController {

    @Override
    @GetMapping("/{id}/comment")
    public CommonResponse<Page<NoticeCommentResponse.Summary>> listNoticeBoardComment(@PathVariable Long id) {
        return null;
    }

    @Override
    @PostMapping("/{id}/comment")
    public CommonResponse<NoticeCommentResponse.Detail> postNoticeBoardComment(
            NoticeCommentRequest.Post request,
            @PathVariable Long id,
            @AuthenticationPrincipal UserDetails userDetails) {
        return null;
    }

    @Override
    @PutMapping("/comment/{id}")
    public CommonResponse<NoticeCommentResponse.Update> updateNoticeBoardComment(NoticeCommentRequest.Update update,
                                                                                 @PathVariable Long id) {
        return null;
    }

    @Override
    @DeleteMapping("/comment/{id}")
    public CommonResponse<?> deleteNoticeBoardComment(@PathVariable Long id) {
        return null;
    }

}
