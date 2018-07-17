package com.framgia.action;

import com.framgia.model.Comment;
import com.framgia.model.News;

public class CommentAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Comment comment;
	private Integer newsId;
	private String description;
	private String subDescription;
	private Integer parentId;

	public String newComment() {
		News news = newsService.findById(newsId);
		if (news == null)
			return ERROR;
		if (parentId == null) {
			comment = new Comment(description, 0);
		} else {
			comment = new Comment(subDescription, parentId);
		}
		comment.setUserAccount(getCurrentUser());
		comment.setNews(news);
		commentService.createComment(comment);
		return SUCCESS;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubDescription() {
		return subDescription;
	}

	public void setSubDescription(String subDescription) {
		this.subDescription = subDescription;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
