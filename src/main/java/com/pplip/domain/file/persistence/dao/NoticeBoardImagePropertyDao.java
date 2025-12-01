package com.pplip.domain.file.persistence.dao;

import com.pplip.domain.file.persistence.entity.FreeBoardImageProperty;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeBoardImagePropertyDao {
    int insert(FreeBoardImageProperty property);

    int delete(Long id);

    int bulkUpdateBoardId(List<Long> imageIds, Long boardId);
}
