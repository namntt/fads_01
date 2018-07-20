package com.framgia.action;

import java.util.ArrayList;
import java.util.List;

import com.framgia.model.Category;
import com.framgia.model.City;
import com.framgia.model.News;
import com.framgia.search.Search;
import com.framgia.search.SearchNews;

public class CategoryAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Category category;
	private List<Category> categories;
	private Integer id;
	private List<String> cityNames;
	private List<City> cities;
	private String keyword;
	private String choiceAdress;
	private String choicePrice;
	private List<Integer> newsIds;
	private List<News> newses;

	public String index() {
		categories = categoryService.findAll();
		newsIds = userFollowNewsService.loadQuantityUserFollowNews();
		newses = new ArrayList<News>();
		newsIds.forEach(news_id -> newses.add(newsService.findById(news_id)));
		return SUCCESS;
	}

	public String showNews() {
		Search<News> searchNew = new SearchNews();
		searchNew.getFieldsSearch().setTittle(getKeyword());
		cities = cityService.findAll();
		cityNames = new ArrayList<String>();
		cities.forEach(city -> cityNames.add(city.getName()));
		if (getChoiceAdress() != null) {
			searchNew.getFieldsSearch().setCity(cityService.findByName(getChoiceAdress()));
		}
		newses = newsService.findNewsByCategoryId(id, 1, searchNew);
		for (int i = 0; i < newses.size(); i++) {
			newses.get(i).setUser(userService.findById(newses.get(i).getUser().getId()));
		}
		return SUCCESS;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getCityNames() {
		return cityNames;
	}

	public void setCityNames(List<String> cityNames) {
		this.cityNames = cityNames;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getChoiceAdress() {
		return choiceAdress;
	}

	public void setChoiceAdress(String choiceAdress) {
		this.choiceAdress = choiceAdress;
	}

	public List<Integer> getNewsIds() {
		return newsIds;
	}

	public void setNewsIds(List<Integer> newsIds) {
		this.newsIds = newsIds;
	}

	public List<News> getNewses() {
		return newses;
	}

	public void setNewses(List<News> newses) {
		this.newses = newses;
	}

	public String getChoicePrice() {
		return choicePrice;
	}

	public void setChoicePrice(String choicePrice) {
		this.choicePrice = choicePrice;
	}

}
