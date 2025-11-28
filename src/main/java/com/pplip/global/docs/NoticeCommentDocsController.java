package com.pplip.global.docs;

import com.pplip.domain.board.notice.api.request.NoticeCommentRequest;
import com.pplip.domain.board.notice.api.request.NoticeRequest;
import com.pplip.domain.board.notice.api.response.NoticeResponse;
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
    CommonResponse<Page<NoticeResponse.CommentList>> listNoticeBoardComment(Long id);

    @Operation(summary = "공지게시판 게시판 댓글 작성")
    @ApiResponse(responseCode = "201", description = "성공")
    CommonResponse<NoticeResponse.CommentList> postNoticeBoardComment(NoticeCommentRequest.Post request,
                                                                      Long id,
                                                                      UserDetails userDetails);
}
