package com.gomez.androidapplicationproject;



//PINAG SAMA KO YUNG COMMENT TABLE SAKA COMMENTS DITO

public class Comment {
    private Integer commentTable_id, comment_id;
    private String comment_string;
    private Boolean comment_like;
    private String comment_res;


    public Comment(Integer comment_id, String comment_string, Boolean comment_like, String comment_res) {
        this.comment_id = comment_id;
        this.comment_string = comment_string;
        this.comment_like = comment_like;
        this.comment_res = comment_res;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", comment_string='" + comment_string + '\'' +
                ", comment_like=" + comment_like +
                ", comment_res='" + comment_res + '\'' +
                '}';
    }

    public Integer getCommentTable_id() {
        return commentTable_id;
    }

    public void setCommentTable_id(Integer commentTable_id) {
        this.commentTable_id = commentTable_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_string() {
        return comment_string;
    }

    public void setComment_string(String comment_string) {
        this.comment_string = comment_string;
    }

    public Boolean getComment_like() {
        return comment_like;
    }

    public void setComment_like(Boolean comment_like) {
        this.comment_like = comment_like;
    }

    public String getComment_res() {
        return comment_res;
    }

    public void setComment_res(String comment_res) {
        this.comment_res = comment_res;
    }
}
