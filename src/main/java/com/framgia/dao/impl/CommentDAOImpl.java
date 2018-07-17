package com.framgia.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import com.framgia.dao.CommentDAO;
import com.framgia.model.Comment;
import com.framgia.model.News;

public class CommentDAOImpl extends GenericDAOAbstract<Comment, Integer> implements CommentDAO {

	@Override
	public List<Comment> findCommentsByNewsId(Integer newsId) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Comment> cr = builder.createQuery(Comment.class);
		Root<Comment> root = cr.from(Comment.class);
		Join<Comment, News> join_news = root.join("news");
		if (newsId != null) {
			cr.where(builder.equal(join_news.get("id"), newsId));
		}
		return getSession().createQuery(cr.select(root)).getResultList();
	}

}
