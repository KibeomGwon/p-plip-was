package com.pplip.global.docs;

import com.pplip.domain.board.notice.api.request.NoticeRequest;
import com.pplip.domain.board.notice.api.response.NoticeResponse;
import com.pplip.global.api.response.CommonResponse;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.userdetails.UserDetails;

@Tag(name = "공지게시판 API", description = "공지게시판 API")
public interface NoticeDocsController {

    @Operation(summary = "공지게시판 페이징 조회")
    @ApiResponse(responseCode = "200", description = "성공")
    CommonResponse<Page<NoticeResponse.Summary>> listNoticeBoard(PageRequest pageRequest);

    @Operation(summary = "공지게시판 게시글 작성")
    @ApiResponse(responseCode = "201", description = "생성")
    CommonResponse<NoticeResponse.Detail> postNoticeBoard(NoticeRequest.Post request, UserDetails userDetails);

    @Operation(summary = "공지게시판 게시글 상세 조회")
    @ApiResponse(responseCode = "200", description = "성공")
    CommonResponse<NoticeResponse.Detail> findNoticeBoard(Long id);


    @Operation(summary = "공지게시판 게시판 수정")
    @ApiResponse(responseCode = "202", description = "수정")
    CommonResponse<NoticeResponse.Update> updateNoticeBoard(NoticeRequest.Update update, Long id);

    @Operation(summary = "공지게시판 게시판 삭제")
    @ApiResponse(responseCode = "203", description = "삭제")
    CommonResponse<NoticeResponse.Update> removeNoticeBoard(Long id);

}
