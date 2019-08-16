package com.jt.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.jt.bbs.dao.ArticleMapper;
import com.jt.bbs.entity.Article;
import com.jt.bbs.entity.ArticleExample;

@Service
public class ArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	
	public List<Article> queryLatestArticleList(int page){
		ArticleExample example = new ArticleExample();
		example.setOrderByClause("createTime desc");
		PageHelper.startPage(page, 5);
		return articleMapper.selectByExampleWithBLOBs(example);
	}

	public List<Article> queryLatestArticleList(int id, int page) {
		ArticleExample example = new ArticleExample();
		example.createCriteria().andCategoryidEqualTo(id);
		PageHelper.startPage(page, 5);
		return articleMapper.selectByExampleWithBLOBs(example);
		
	}
}
