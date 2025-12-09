package com.pplip.domain.board.notice.usecase.impl;

import com.pplip.domain.auth.persistence.entity.Account;
import com.pplip.domain.board.notice.api.request.NoticeRequest;
import com.pplip.domain.board.notice.api.response.NoticeResponse;
import com.pplip.domain.board.notice.persistence.dao.NoticeDao;
import com.pplip.domain.board.notice.persistence.entity.NoticeBoard;
import com.pplip.domain.board.notice.usecase.NoticeService;
import com.pplip.domain.board.notice.usecase.model.NoticeBoardModel;
import com.pplip.domain.board.notice.utils.NoticeBoardParser;
import com.pplip.domain.file.persistence.dao.NoticeBoardImagePropertyDao;
import com.pplip.global.api.code.ErrorCode;
import com.pplip.global.exception.BoardLogicException;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class NoticeServiceImpl implements NoticeService {

    private final NoticeDao dao;
    private final NoticeBoardImagePropertyDao imagePropertyDao;
    private final NoticeBoardParser noticeBoardParser;

    @Override
    public Page<NoticeResponse.Summary> findAll(PageRequest pageRequest) {
        List<NoticeResponse.Summary> datas = dao.findAll(pageRequest);
        int count = dao.noticeBoardAllCount();

        return new Page<>(datas, pageRequest.getPageNum(), pageRequest.getPageSize(), count);
    }

    @Override
    public NoticeResponse.Detail post(NoticeRequest.Post post, UserDetails userDetails) {
        Long userId = ((Account) userDetails).getUserId();

        NoticeBoardModel boardModel = new NoticeBoardModel(post, userId);
        NoticeBoard entity = boardModel.toEntity();

        if (dao.insert(entity) == 0) {
            throw new BoardLogicException(ErrorCode.FAIL_TO_CREATE_BOARD);
        }

        // 이미지들의 board_id 값을 업데이트.
        if (imagePropertyDao.bulkUpdate(post.getImageIds(), entity.getId()) != post.getImageIds().size()) {
            throw new BoardLogicException(ErrorCode.FAIL_TO_CREATE_BOARD);
        }

        return dao.findById(entity.getId())
                .orElseThrow(() -> new BoardLogicException(ErrorCode.FAIL_TO_CREATE_BOARD));
    }

    @Override
    public NoticeResponse.Detail findById(Long id) {
        return dao.findById(id)
                .orElseThrow(() -> new BoardLogicException(ErrorCode.BOARD_NOT_FOUND_ERROR));
    }

    @Override
    public NoticeResponse.Update update(NoticeRequest.Update update, Long id) {
        NoticeBoardModel model = new NoticeBoardModel(update, id);

        NoticeBoard entity = model.toEntity();
        dao.update(entity);

        imagePropertyDao.bulkUpdate(update.getImageIds(), id);

        NoticeResponse.Detail detail = dao.findById(id)
                .orElseThrow(() -> new BoardLogicException(ErrorCode.BOARD_NOT_FOUND_ERROR));

        return noticeBoardParser.detailResToUpdateRes(detail);
    }

    @Override
    public void remove(Long id) {
        if (dao.delete(id) != 1) {
            throw new BoardLogicException(ErrorCode.BOARD_FAIL_DELETE);
        }
    }
}
