package com.pplip.domain.board.notice.usecase.impl;

import com.pplip.domain.auth.persistence.entity.Account;
import com.pplip.domain.board.notice.api.request.NoticeRequest;
import com.pplip.domain.board.notice.api.response.NoticeResponse;
import com.pplip.domain.board.notice.usecase.NoticeService;
import com.pplip.global.exception.BoardLogicException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class NoticeServiceImplTest {

}