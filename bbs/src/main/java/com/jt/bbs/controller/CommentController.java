package com.jt.bbs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jt.bbs.common.Result;
import com.jt.bbs.entity.Comment;
import com.jt.bbs.entity.User;
import com.jt.bbs.service.CommentService;

@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;

	@RequestMapping("comment")
	public Result comment(@Valid Comment comment, Errors errors,@SessionAttribute(name="loginedUser",required=false) User user) {
		if (errors.hasErrors()) {
			return  new Result(-1, "评论失败", errors.getAllErrors());	
		}
		Comment comm;
		try {
			comment.setCreateby(user.getId());
			comm = commentService.addAComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "评论失败");
		}
		return new Result(1, "评论成功", comm);
	}
}
