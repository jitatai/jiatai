package com.jt.bbs.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jt.bbs.dao.ArticleMapper;
import com.jt.bbs.dao.CommentMapper;
import com.jt.bbs.entity.Article;
import com.jt.bbs.entity.Comment;

@Service
public class CommentService {
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private CommentMapper commentMapper;
	@Transactional
	public Comment addAComment(Comment comment){
		comment.setCreatetime(new Date());
		Article article = articleMapper.selectByPrimaryKey(comment.getArticleid());
		article.setCommcnt(article.getCommcnt() == null ? 1 : article.getAgreecnt() + 1);
		articleMapper.updateByPrimaryKey(article);
		commentMapper.insert(comment);
		return comment;
	}
}
