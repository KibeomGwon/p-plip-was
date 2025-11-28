package com.pplip.global.docs;

import com.pplip.domain.trip.plan.api.request.ToDoRequest;
import com.pplip.domain.trip.plan.api.response.ToDoResponse;
import com.pplip.global.api.response.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Tag(name = "여행 TODO API", description = "여행 TODO API")
public interface ToDoDocsController {

    @Operation(summary = "유저종속 TODO 페이징 조회")
    @ApiResponse(responseCode = "200", description = "성공")
    CommonResponse<ToDoResponse.Summary> listToDo(UserDetails userDetails);

    @Operation(summary = "계획종속 TODO 페이징 조회")
    @ApiResponse(responseCode = "200", description = "성공")
    CommonResponse<ToDoResponse.Summary> listToDo(Long planId);

    @Operation(summary = "TODO 생성")
    @ApiResponse(responseCode = "201", description = "생성")
    CommonResponse<ToDoResponse.Detail> listToDo(List<ToDoRequest.Post> request, Long planId);

    @Operation(summary = "TODO 단건 조회")
    @ApiResponse(responseCode = "200", description = "성공")
    CommonResponse<ToDoResponse.Detail> getToDo(Long id);

    @Operation(summary = "TODO 수정")
    @ApiResponse(responseCode = "202", description = "수정")
    CommonResponse<ToDoResponse.Update> updateToDo(List<ToDoRequest.Update> update, Long planId);

    @Operation(summary = "TODO 삭제")
    @ApiResponse(responseCode = "203", description = "삭제")
    CommonResponse<?> deleteToDo(Long id);
}
