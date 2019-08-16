package com.jt.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.bbs.dao.CategoryMapper;
import com.jt.bbs.entity.Category;

@Service
public class CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;
	
	public List<Category> getAllCatList(){
		return categoryMapper.selectByExample(null);
	}
}
