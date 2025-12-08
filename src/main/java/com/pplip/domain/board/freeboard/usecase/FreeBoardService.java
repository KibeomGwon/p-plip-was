package com.pplip.domain.board.freeboard.usecase;

import com.pplip.domain.board.freeboard.api.request.FreeBoardRequest;
import com.pplip.domain.board.freeboard.api.response.FreeBoardResponse;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface FreeBoardService {

	FreeBoardResponse.Remove remove(Long id, UserDetails principal);

	FreeBoardResponse.Detail modifyFreeBoard(FreeBoardRequest.BoardUpdate update, Long id, UserDetails principal);

	FreeBoardResponse.Detail post(FreeBoardRequest.BoardPost request, UserDetails principal);

	FreeBoardResponse.Detail retrieveDetail(Long id);

	Page<FreeBoardResponse.BoardList> retrieve(PageRequest pageRequest);
}
