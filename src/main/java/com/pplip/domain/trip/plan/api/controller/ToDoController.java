package com.pplip.domain.trip.plan.api.controller;

import com.pplip.domain.trip.plan.api.request.ToDoRequest;
import com.pplip.domain.trip.plan.api.response.ToDoResponse;
import com.pplip.global.api.response.CommonResponse;
import com.pplip.global.docs.ToDoDocsController;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trip/plan")
public class ToDoController implements ToDoDocsController {

    /**
     * 유저의 TODO 리스트를 조회합니다.
     *
     * @param userDetails 유저 정보
     * @return 유저의 TODO 리스트
     */
    @Override
    @GetMapping("/todo")
    public CommonResponse<ToDoResponse.Summary> listToDo(UserDetails userDetails) {
        return null;
    }

    /**
     * 계획의 TODO 리스트를 조회합니다.
     *
     * @param planId 계획 아이디
     * @return 계획의 TODO 리스트
     */
    @Override
    @GetMapping("/{planId}/todo")
    public CommonResponse<ToDoResponse.Summary> listToDo(Long planId) {
        return null;
    }

    /**
     * TODO를 생성합니다.
     *
     * @param request 생성할 TODO 정보
     * @param planId 계획 아이디
     * @return 생성된 TODO 정보
     */
    @Override
    @PostMapping("/{planId}/todo")
    public CommonResponse<ToDoResponse.Detail> listToDo(List<ToDoRequest.Post> request, Long planId) {
        return null;
    }

    /**
     * TODO를 단건 조회합니다.
     *
     * @param id TODO 아이디
     * @return TODO 정보
     */
    @Override
    @GetMapping("/todo/{id}")
    public CommonResponse<ToDoResponse.Detail> getToDo(Long id) {
        return null;
    }

    /**
     * TODO를 수정합니다.
     *
     * @param update 수정할 TODO 정보
     * @param planId 계획 아이디
     * @return 수정된 TODO 정보
     */
    @Override
    @PutMapping("/{planId}/todo")
    public CommonResponse<ToDoResponse.Update> updateToDo(List<ToDoRequest.Update> update, Long planId) {
        return null;
    }

    /**
     * TODO를 삭제합니다.
     *
     * @param id TODO 아이디
     * @return 203
     */
    @Override
    @DeleteMapping("/todo/{id}")
    public CommonResponse<?> deleteToDo(Long id) {
        return null;
    }
}
