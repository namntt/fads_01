package com.framgia.action;

import java.util.ArrayList;
import java.util.List;

import com.framgia.model.Category;
import com.framgia.model.City;
import com.framgia.model.News;
import com.framgia.search.Search;
import com.framgia.search.SearchNews;

public class CategoryAction extends BaseAction {

	private Category category;
	private List<Category> categories;
	private List<News> subCategory;
	private Integer id;
	private List<String> cityNames;
	private List<City> cities;
	private String keyword;
	private String choiceAdress;

	public String index() {
		categories = categoryService.findAll();
		return "success";
	}

	public String showNews() {
		Search<News> searchNew = new SearchNews();
		searchNew.getFieldsSearch().setTittle(getKeyword());
		cities = cityService.findAll();
		cityNames = new ArrayList<String>();
		for (City city : cities) {
			cityNames.add(city.getName());
		}
		if (getChoiceAdress() != null) {
			searchNew.getFieldsSearch().getCity().setId(cityService.findByName(getChoiceAdress()).getId());
		}
		subCategory = newsService.findNewsByCategoryId(id, 1, searchNew);
		return "success";
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

	public List<News> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<News> subCategory) {
		this.subCategory = subCategory;
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
}
