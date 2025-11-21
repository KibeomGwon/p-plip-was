package com.pplip.global.docs;

import com.pplip.domain.board.freeboard.api.request.FreeBoardRequest;
import com.pplip.domain.board.freeboard.api.response.FreeBoardResponse;
import com.pplip.global.api.response.CommonResponse;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.userdetails.UserDetails;

@Tag(name = "자유게시판 API", description = "자유게시판 api")
public interface FreeBoardDocsController {



    @Operation(summary = "자유게시판 페이징 조회")
    @ApiResponse(responseCode = "200", description = "성공")
    public CommonResponse<Page<FreeBoardResponse.BoardList>> retrieveFreeBoard(PageRequest pageRequest);


    @Operation(summary = "자유게시판 게시글 상세 조회")
    @ApiResponse(responseCode = "200", description = "성공")
    CommonResponse<FreeBoardResponse.Detail> getFreeBoardDetail(Long id);


    @Operation(summary = "자유게시판 게시글 작성")
    @ApiResponse(responseCode = "201", description = "생성")
    CommonResponse<FreeBoardResponse.Detail> getFreeBoardDetail(FreeBoardRequest.BoardPost request, UserDetails principal);

    @Operation(summary = "자유게시판 게시글 수정")
    @ApiResponse(responseCode = "202", description = "수정")
    CommonResponse<FreeBoardResponse.Update> postFreeBoardUpdate(FreeBoardRequest.BoardUpdate update, Long id, UserDetails principal);


    @Operation(summary = "자유게시판 게시글 삭제")
    @ApiResponse(responseCode = "203", description = "삭제")
    CommonResponse<FreeBoardResponse.Remove> postBoardUpdate(Long id, UserDetails principal);

}
