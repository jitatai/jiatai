package com.jt.bbs.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.jt.bbs.entity.Article;
import com.jt.bbs.entity.Category;
import com.jt.bbs.entity.User;
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
	
	@RequestMapping("toedit")
	public String toEdit(Model model){
		model.addAttribute("article", new Article());
		return "article_edit";
	}
	
	@RequestMapping("saveArticle")
	public String save(@SessionAttribute("loginedUser")User user,Model model,Article article){
		article.setAuthor(user.getName());
		article.setCreatetime(new Date());
		articleService.save(article);
		return article(1, article.getId(), model);
	}
	
	@PostMapping("upload")
	@ResponseBody
	public String upload(@RequestParam(name="upload")MultipartFile upload,String CKEditorFuncNum) throws Exception{
		String dest = "d:/upload/" + upload.getOriginalFilename();
		upload.transferTo(new File(dest));
		String js = "<script type=\"text/javascript\">";
		js +="window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum
                + ",'upload/" + upload.getOriginalFilename() + "','')</script>";
		return js;
	}
	
	
}
