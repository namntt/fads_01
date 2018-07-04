package com.framgia.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import com.framgia.dao.NewsDAO;
import com.framgia.model.Category;
import com.framgia.model.News;

public class NewsDAOImpl extends GenericDAOAbstract<News, Integer> implements NewsDAO {

	@Override
	public List<News> findNewsByCategoryId(Integer category_id, Integer status) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<News> cr = builder.createQuery(News.class);
		Root<News> root = cr.from(News.class);
		Join<News, Category> join = root.join("category");
		if (category_id != null) {
			cr.where(
					builder.and(builder.equal(join.get("id"), category_id), builder.equal(root.get("status"), status)));
		}
		cr.orderBy(builder.desc(root.get("startDate")));
		return (List<News>) getSession().createQuery(cr.select(root)).getResultList();
	}

}
