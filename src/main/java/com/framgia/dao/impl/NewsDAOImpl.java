package com.framgia.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;

import com.framgia.dao.NewsDAO;
import com.framgia.model.Category;
import com.framgia.model.City;
import com.framgia.model.News;
import com.framgia.search.Search;

public class NewsDAOImpl extends GenericDAOAbstract<News, Integer> implements NewsDAO {

	@Override
	public List<News> findNewsByCategoryId(Integer category_id, Integer status, Search<News> search) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<News> cr = builder.createQuery(News.class);
		Root<News> root = cr.from(News.class);
		Join<News, Category> join_category = root.join("category");
		Join<News, City> join_city = root.join("city");
		if (category_id != null) {
			cr.where(
					builder.and(builder.equal(join_category.get("id"), category_id), builder.equal(root.get("status"), status)));
		}
		if (StringUtils.isNotBlank(search.getFieldsSearch().getTittle())
				|| search.getFieldsSearch().getCity().getId() != null) {
			cr.where(builder.and(
					builder.like(builder.lower(root.get("tittle")),
							"%" + search.getFieldsSearch().getTittle() + "%"),
					builder.equal(join_category.get("id"), category_id), builder.equal(root.get("status"), status),
					builder.equal(join_city.get("id"), search.getFieldsSearch().getCity().getId())));
		}
		cr.orderBy(builder.desc(root.get("startDate")));
		return (List<News>) getSession().createQuery(cr.select(root)).getResultList();
	}

}
