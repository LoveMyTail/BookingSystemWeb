package com.example.demo.dao;

import com.example.demo.entity.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> queryComment();
    List<Comment> queryCommentByShowId(int showId);
    List<Comment> queryCommentByUserId(String userId);
    int insertComment(Comment comment);
    int deleteComment(int commentId);
}
