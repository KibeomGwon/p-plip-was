package com.pplip.domain.board.notice.usecase.impl;

import com.pplip.domain.auth.persistence.entity.Account;
import com.pplip.domain.board.notice.api.request.NoticeCommentRequest;
import com.pplip.domain.board.notice.api.response.NoticeCommentResponse;
import com.pplip.domain.board.notice.persistence.dao.NoticeCommentDao;
import com.pplip.domain.board.notice.persistence.entity.NoticeComment;
import com.pplip.domain.board.notice.usecase.NoticeCommentService;
import com.pplip.domain.board.notice.usecase.model.NoticeCommentModel;
import com.pplip.domain.board.notice.utils.NoticeCommentParser;
import com.pplip.global.api.code.ErrorCode;
import com.pplip.global.exception.BoardLogicException;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class NoticeCommentServiceImpl implements NoticeCommentService {

    private final NoticeCommentDao dao;
    private final NoticeCommentParser parser;
    @Override
    public Page<NoticeCommentResponse.Summary> findAllByBoardId(Long boardId, PageRequest pageRequest) {
        return new Page<>(dao.findAll(boardId, pageRequest),
                pageRequest.getPageNum(),
                pageRequest.getPageSize(),
                dao.noticeBoardCommentAllCount(boardId));
    }

    @Override
    public NoticeCommentResponse.Detail post(NoticeCommentRequest.Post post, Long boardId, UserDetails userDetails) {
        Long userId = ((Account) userDetails).getUserId();
        NoticeCommentModel model = new NoticeCommentModel(post, boardId, userId);
        NoticeComment entity = model.toEntity();

        if (dao.insert(entity) != 1) {
            throw new BoardLogicException(ErrorCode.COMMENT_CREATE_ERROR);
        }
        return dao.findById(entity.getId()).orElseThrow(() -> new BoardLogicException(ErrorCode.COMMENT_NOT_FOUND));
    }

    @Override
    public NoticeCommentResponse.Update update(NoticeCommentRequest.Update update,
                                               Long id,
                                               UserDetails userDetails) {
        Long userId = ((Account) userDetails).getUserId();

        NoticeCommentModel model = new NoticeCommentModel(update, id, userId);
        dao.update(model.toEntity());

        NoticeCommentResponse.Detail detail = dao.findById(id)
                .orElseThrow(() -> new BoardLogicException(ErrorCode.COMMENT_NOT_FOUND));

        return parser.detailResToUpdateRes(detail);
    }

    @Override
    public void delete(Long id) {
        if (dao.delete(id) != 1) {
            throw new BoardLogicException(ErrorCode.COMMENT_DELETE_FAIL_ERROR);
        }
    }
}
