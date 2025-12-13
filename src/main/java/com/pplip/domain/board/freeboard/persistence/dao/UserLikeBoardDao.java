package com.pplip.domain.board.freeboard.persistence.dao;

import com.pplip.domain.board.freeboard.persistence.entity.UserLikeBoard;
import com.pplip.domain.user.persistence.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserLikeBoardDao {
	Optional<UserLikeBoard> findById(@Param("userId") Long userId, @Param("userId") Long boardId);
	int insert (UserLikeBoard userLikeBoard);
	int delete (UserLikeBoard userLikeBoard);
	int count (@Param("boardId") Long boardId);
	boolean isLike(@Param("userId") Long userId, @Param("boardId") Long boardId);
}
