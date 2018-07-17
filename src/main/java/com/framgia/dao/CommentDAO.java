package com.framgia.dao;

import java.util.List;

import com.framgia.model.Comment;

public interface CommentDAO extends BaseDAO<Comment, Integer> {
	List<Comment> findCommentsByNewsId(Integer newsId);
}
