package com.pplip.global.docs;

import com.pplip.domain.board.notice.api.request.NoticeRequest;
import com.pplip.domain.board.notice.api.response.NoticeResponse;
import com.pplip.global.api.response.CommonResponse;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Tag(name = "공지게시판 API", description = "공지게시판 API")
public interface NoticeDocsController {

    @Operation(summary = "공지게시판 페이징 조회")
    @ApiResponse(responseCode = "200", description = "성공")
    CommonResponse<Page<NoticeResponse.BoardList>> listNoticeBoard(PageRequest pageRequest);

    @Operation(summary = "공지게시판 게시글 작성")
    @ApiResponse(responseCode = "201", description = "생성")
    CommonResponse<NoticeResponse.Detail> postNoticeBoard(NoticeRequest.BoardPost request, UserDetails userDetails);

    @Operation(summary = "공지게시판 게시글 상세 조회")
    @ApiResponse(responseCode = "200", description = "성공")
    CommonResponse<NoticeResponse.Detail> findNoticeBoard(Long id);


    @Operation(summary = "공지게시판 게시판 수정")
    @ApiResponse(responseCode = "202", description = "성공")
    CommonResponse<NoticeResponse.BoardUpdate> updateNoticeBoard(NoticeRequest.BoardUpdate update, Long id);

    @Operation(summary = "공지게시판 게시판 삭제")
    @ApiResponse(responseCode = "203", description = "성공")
    CommonResponse<NoticeResponse.BoardRemove> removeNoticeBoard(Long id);

    @Operation(summary = "공지게시판 게시판 댓글 페이징 조회")
    @ApiResponse(responseCode = "200", description = "성공")
    CommonResponse<Page<NoticeResponse.CommentList>> listNoticeBoardComment(Long id);

    @Operation(summary = "공지게시판 게시판 댓글 작성")
    @ApiResponse(responseCode = "201", description = "성공")
    CommonResponse<NoticeResponse.CommentList> postNoticeBoardComment(NoticeRequest.CommentPost request,
                                                                      Long id,
                                                                      UserDetails userDetails);
}
