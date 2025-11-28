package com.pplip.global.docs;

import com.pplip.domain.board.notice.api.request.NoticeCommentRequest;
import com.pplip.domain.board.notice.api.response.NoticeCommentResponse;
import com.pplip.global.api.response.CommonResponse;
import com.pplip.global.page.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.userdetails.UserDetails;

@Tag(name = "공지게시판 댓글 API", description = "공지게시판 댓글 API")
public interface NoticeCommentDocsController {

    @Operation(summary = "공지게시판 게시판 댓글 페이징 조회")
    @ApiResponse(responseCode = "200", description = "성공")
    CommonResponse<Page<NoticeCommentResponse.Summary>> listNoticeBoardComment(Long id);

    @Operation(summary = "공지게시판 게시판 댓글 작성")
    @ApiResponse(responseCode = "201", description = "성공")
    CommonResponse<NoticeCommentResponse.Detail> postNoticeBoardComment(NoticeCommentRequest.Post request,
                                                                      Long id,
                                                                      UserDetails userDetails);

    @Operation(summary = "공지게시판 게시판 댓글 수정")
    @ApiResponse(responseCode = "202", description = "수정")
    CommonResponse<NoticeCommentResponse.Update> updateNoticeBoardComment(NoticeCommentRequest.Update update, Long id);

    @Operation(summary = "공지게시판 게시판 댓글 삭제")
    @ApiResponse(responseCode = "203", description = "삭제")
    CommonResponse<?> deleteNoticeBoardComment(Long id);
}
