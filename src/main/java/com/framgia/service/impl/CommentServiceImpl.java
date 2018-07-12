package com.framgia.service.impl;

import java.util.List;

import com.framgia.dao.CommentDAO;
import com.framgia.model.Comment;
import com.framgia.service.CommentService;

public class CommentServiceImpl implements CommentService {
	private CommentDAO commentDAO;

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	@Override
	public Comment createComment(Comment comment) {
		try {
			return getCommentDAO().saveOrUpdate(comment);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Comment> loadCommentByNewsId(Integer newsId) {
		try {
			return getCommentDAO().findCommentsByNewsId(newsId);
		} catch (Exception e) {
			return null;
		}
	}

}
