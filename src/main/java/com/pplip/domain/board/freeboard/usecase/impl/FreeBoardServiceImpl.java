package com.pplip.domain.board.freeboard.usecase.impl;

import com.pplip.domain.auth.persistence.entity.Account;
import com.pplip.domain.auth.utils.SecurityUtils;
import com.pplip.domain.board.aop.annotation.CountView;
import com.pplip.domain.board.aop.enums.BoardType;
import com.pplip.domain.board.freeboard.api.request.FreeBoardRequest;
import com.pplip.domain.board.freeboard.api.response.FreeBoardResponse;
import com.pplip.domain.board.freeboard.persistence.dao.FreeBoardDao;
import com.pplip.domain.board.freeboard.persistence.entity.FreeBoard;
import com.pplip.domain.board.freeboard.usecase.FreeBoardService;
import com.pplip.domain.file.api.request.FileRequest;
import com.pplip.domain.file.persistence.dao.FreeBoardImagePropertyDao;
import com.pplip.domain.file.persistence.entity.FileStatus;
import com.pplip.domain.file.persistence.entity.FreeBoardImageProperty;
import com.pplip.domain.file.persistence.entity.ImageType;
import com.pplip.domain.file.usecase.FileService;
import com.pplip.global.api.code.ErrorCode;
import com.pplip.global.exception.BusinessLogicException;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class FreeBoardServiceImpl implements FreeBoardService {
	private final FreeBoardDao freeBoardDao;
	private final FreeBoardImagePropertyDao freeBoardImagePropertyDao;
	private final FileService fileService;

	@Override
	public FreeBoardResponse.Remove remove(Long id, UserDetails principal) {
		Long userId = ((Account) principal).getUserId();
		FreeBoard freeBoard = freeBoardDao.findById(id).orElseThrow(() -> new BusinessLogicException(ErrorCode.BOARD_NOT_FOUND_ERROR));
		if (!freeBoard.getAuthorId().equals(userId)) {
			throw new BusinessLogicException(ErrorCode.FORBIDDEN, "작성자만 삭제할 수 있습니다.");
		}
		freeBoard.setRemoved(true);
		freeBoardDao.update(freeBoard);
		return FreeBoardResponse.Remove.builder().title(freeBoard.getTitle()).id(freeBoard.getId()).build();
	}

	@Override
	public FreeBoardResponse.Detail modifyFreeBoard(FreeBoardRequest.BoardUpdate update, Long id, UserDetails principal) {
		Long userId = ((Account) principal).getUserId();
		FreeBoard freeBoard = freeBoardDao.findById(id).orElseThrow(() -> new BusinessLogicException(ErrorCode.BOARD_NOT_FOUND_ERROR));
		if (!freeBoard.getAuthorId().equals(userId)) {
			throw new BusinessLogicException(ErrorCode.FORBIDDEN, "작성자만 수정 할 수 있습니다.");
		}
		freeBoard.setTitle(update.getTitle());
		freeBoard.setContent(update.getContent());
		List<Long> removeImages = update.getImages().stream().filter(f -> f.getStatus().equals(FileStatus.REMOVE)).map(FileRequest::getId).toList();
		//현재 이미지는 생성되어 있으나, ref가 없는 상태
		List<Long> updateImageIds = update.getImages().stream().filter(f -> f.getStatus().equals(FileStatus.NEW)).map(FileRequest::getId).toList();
		List<FreeBoardImageProperty> boardImages = freeBoardImagePropertyDao.findByBoardId(freeBoard.getId());
		List<FreeBoardImageProperty> removeList = boardImages.stream().filter(img -> removeImages.contains(img.getId())).toList();

		freeBoardImagePropertyDao.bulkUpdate(updateImageIds, freeBoard.getId());
		freeBoardDao.update(freeBoard);

		fileService.deleteSavedFiles(removeList.stream().map(FreeBoardImageProperty::getId).toList(), ImageType.FREE_BOARD);//엑박 방지하려면 프로퍼티 먼저 삭제
		fileService.deleteOriginFiles(removeList.stream().map(FreeBoardImageProperty::getPath).toList());
		FreeBoardResponse.Detail detail = freeBoardDao.findByIdToDto(id).get();
		detail.setAuthor(detail.getUserId() == userId);
		return detail;
	}

	@Override
	public FreeBoardResponse.Detail post(FreeBoardRequest.BoardPost request, UserDetails principal) {
		Long userId = ((Account) principal).getUserId();
		FreeBoard freeBoard = FreeBoard.builder().authorId(userId)
				.title(request.getTitle())
				.content(request.getContent())
				.createdAt(LocalDateTime.now())
				.isRemoved(false)
				.viewCnt(0).build();
		int insert = freeBoardDao.insert(freeBoard);
		freeBoardImagePropertyDao.bulkUpdate(request.getIds(), freeBoard.getId());
		FreeBoardResponse.Detail detail = freeBoardDao.findByIdToDto(freeBoard.getId()).orElseThrow(() -> new BusinessLogicException(ErrorCode.BOARD_NOT_FOUND_ERROR, "게시글 저장에 실패했습니다."));
		detail.setAuthor(detail.getUserId() == userId);
		return detail;
	}

	@Override
	@Transactional(readOnly = true)
	@CountView(BoardType.FREE_BOARD)
	public FreeBoardResponse.Detail retrieveDetail(Long id) {

		FreeBoardResponse.Detail detail = freeBoardDao.findByIdToDto(id).orElseThrow(() -> new BusinessLogicException(ErrorCode.BOARD_NOT_FOUND_ERROR, "게시글을 찾을 수 없습니다."));
		if(!SecurityUtils.isAnonymous()){
			Account currentUser = SecurityUtils.getCurrentUser();
			detail.setAuthor(detail.getUserId() == currentUser.getUserId());
		}
		return detail;
	}

	@Override
	public Page<FreeBoardResponse.BoardList> retrieve(PageRequest pageRequest) {
		List<FreeBoardResponse.BoardList> all = freeBoardDao.findAll(pageRequest);
		int allCount = freeBoardDao.countAll();
		return new Page<>(all, pageRequest.getPageNum(), pageRequest.getPageSize(), allCount);
	}
}
