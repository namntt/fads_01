package com.framgia.service;

import java.util.List;

import com.framgia.model.Comment;

public interface CommentService {

	Comment createComment(Comment comment);

	List<Comment> loadCommentByNewsId(Integer newsId);

}
