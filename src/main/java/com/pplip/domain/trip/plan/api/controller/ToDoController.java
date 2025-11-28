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

    @Override
    @GetMapping("/todo")
    public CommonResponse<ToDoResponse.Summary> listToDo(UserDetails userDetails) {
        return null;
    }

    @Override
    @GetMapping("/{planId}/todo")
    public CommonResponse<ToDoResponse.Summary> listToDo(Long planId) {
        return null;
    }

    @Override
    @PostMapping("/{planId}/todo")
    public CommonResponse<ToDoResponse.Detail> listToDo(List<ToDoRequest.Post> request, Long planId) {
        return null;
    }

    @Override
    @GetMapping("/todo/{id}")
    public CommonResponse<ToDoResponse.Detail> getToDo(Long id) {
        return null;
    }

    @Override
    @PutMapping("/{planId}/todo")
    public CommonResponse<ToDoResponse.Update> updateToDo(List<ToDoRequest.Update> update, Long planId) {
        return null;
    }

    @Override
    @DeleteMapping("/todo/{id}")
    public CommonResponse<?> deleteToDo(Long id) {
        return null;
    }
}
