package com.jt.bbs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.jt.bbs.entity.Article;
import com.jt.bbs.entity.Category;
import com.jt.bbs.service.ArticleService;
import com.jt.bbs.service.CategoryService;
import com.jt.bbs.service.CommentService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private CommentService commentService;
	@ModelAttribute("categoryList")
	public List<Category> initCatList(){
		return categoryService.getAllCatList();
	}
	
	@GetMapping("index")
	public String index(@RequestParam(defaultValue="1")Integer page,Model model){
		model.addAttribute("latestArticleList", articleService.queryLatestArticleList(page));
		return "index";
	}
	
	@RequestMapping("catArticle")
	public String categoryArticle(@RequestParam(defaultValue="1")Integer page,
			Integer id,Model model){
		model.addAttribute("latestArticleList",
				articleService.queryLatestArticleList(id,page));
		return "category";
	}
	
	@RequestMapping("article")
	public String article(@RequestParam(defaultValue="1")Integer page,
			Integer id,Model model){
		Article article = articleService.read(id);
		List<Article> recoList = articleService.recommend(article.getCategoryid());
		PageHelper.startPage(page,5);
		article.getCommentList();
		model.addAttribute("article",article);
		model.addAttribute("recoList",recoList);
		return "article";
	}
	
	
}
