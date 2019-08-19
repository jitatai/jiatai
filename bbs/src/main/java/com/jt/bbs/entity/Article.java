package com.jt.bbs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Article implements Serializable {
	private Category category;
	
    private Integer id;

    private String author;

    private String title;

    private String keywords;

    private String description;

    private Integer categoryid;

    private String label;

    private String titleimgs;

    private String status;

    private Date createtime;

    private Integer readcnt;

    private Integer agreecnt;

    private Integer commcnt;

    private String content;
    
    private List<Comment> commentList;

    private static final long serialVersionUID = 1L;

    public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
    public List<Comment> getCommentList() {
		return commentList;
	}
    
    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getTitleimgs() {
        return titleimgs;
    }

    public void setTitleimgs(String titleimgs) {
        this.titleimgs = titleimgs == null ? null : titleimgs.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getReadcnt() {
        return readcnt;
    }

    public void setReadcnt(Integer readcnt) {
        this.readcnt = readcnt;
    }

    public Integer getAgreecnt() {
        return agreecnt;
    }

    public void setAgreecnt(Integer agreecnt) {
        this.agreecnt = agreecnt;
    }

    public Integer getCommcnt() {
        return commcnt;
    }

    public void setCommcnt(Integer commcnt) {
        this.commcnt = commcnt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", author=").append(author);
        sb.append(", title=").append(title);
        sb.append(", keywords=").append(keywords);
        sb.append(", description=").append(description);
        sb.append(", categoryid=").append(categoryid);
        sb.append(", label=").append(label);
        sb.append(", titleimgs=").append(titleimgs);
        sb.append(", status=").append(status);
        sb.append(", createtime=").append(createtime);
        sb.append(", readcnt=").append(readcnt);
        sb.append(", agreecnt=").append(agreecnt);
        sb.append(", commcnt=").append(commcnt);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}